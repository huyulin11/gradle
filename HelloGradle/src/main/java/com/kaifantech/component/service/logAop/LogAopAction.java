package com.kaifantech.component.service.logAop;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kaifantech.entity.LogFormMap;
import com.kaifantech.mappings.ErpLogMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.erp.util.SessionUtil;
import com.ytgrading.util.Common;
import com.ytgrading.util.AppTool;

/**
 * AOP注解方法实现日志管理 利用spring AOP 切面技术记录日志
 * 
 * 定义切面类（这个是切面类和切入点整天合在一起的),这种情况是共享切入点情况;
 * 
 * @author lanyuan 2014-04-10
 * @Email: mmm333zzz520@163.com
 * @version 1.0v
 */
@Aspect
// 该注解标示该类为切面类
@Component
public class LogAopAction {
	@Autowired
	private ErpLogMapper logMapper;

	@SuppressWarnings("rawtypes")
	public String getParamsAndValues(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		Iterator iterator = request.getParameterMap().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			sb.append(entry.getKey() + ":");
			if (entry.getValue() instanceof String[]) {
				sb.append(((String[]) entry.getValue())[0] + ";");
			} else {
				sb.append(entry.getValue() + ";");
			}
		}
		return sb.toString();
	}

	@Around("@annotation(com.ytgrading.annotation.SystemLog)")
	public Object logAll(ProceedingJoinPoint point) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Object result = null;
		String pvs = getParamsAndValues(request);
		org.aspectj.lang.Signature signature = point.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		java.lang.reflect.Method targetMethod = methodSignature.getMethod();

		Class<? extends Method> clazz = targetMethod.getClass();

		String methodName = signature.getName();
		String className = clazz.getSimpleName();

		String accountName = SessionUtil.getUserId().toString();

		String module = null;
		String methods = "";
		String description = "";
		module = className;
		methods = methodName;

		if (targetMethod.isAnnotationPresent(SystemLog.class)) {
			SystemLog systemLog = (SystemLog) targetMethod.getAnnotation(SystemLog.class);
			module = systemLog.module();
			methods = systemLog.methods();
			description = systemLog.description();
		}
		String bussModuleNameStr = "";
		{
			String name = point.getTarget().getClass().getName();
			Class<?> clazzzz;
			clazzzz = Class.forName(name);
			boolean flag = clazzzz.isAnnotationPresent(SystemLog.class);
			if (flag) {
				SystemLog bussModuleName = (SystemLog) clazzzz.getAnnotation(SystemLog.class);
				bussModuleNameStr = bussModuleName.module();
				bussModuleNameStr = (AppTool.isNull(bussModuleNameStr) ? point.getTarget().getClass().getName()
						: bussModuleNameStr);
			} else {
				System.out.println("在" + name + " 没有找到SystemLog对应该的注解!");
			}
		}

		Long start = 0L;
		Long end = 0L;
		String userIP = null;

		try {
			start = System.currentTimeMillis();
			result = point.proceed();
			if (!AppTool.isNullObj(result)) {
				description = result.toString();
			}
			end = System.currentTimeMillis();
		} catch (Throwable e) {
			description = description + "执行失败，未获取到正常结果！";
			e.printStackTrace();
		}

		try {
			userIP = Common.toIpAddr(request);
		} catch (Exception e) {
			description = description + "执行失败，无法获取登录用户Ip！";
			userIP = "无法获取登录用户Ip";
		}
		Long actionTime = end - start;
		LogFormMap log = new LogFormMap();
		log.set("accountName", accountName);
		log.set("module", AppTool.isNull(module) ? bussModuleNameStr : module);
		log.set("methods", methods);
		log.set("actionTime", ((double) actionTime) / 1000);
		log.set("userIP", userIP);
		log.set("description", description + " " + pvs);
		logMapper.addEntity(log);

		return result;
	}
}
