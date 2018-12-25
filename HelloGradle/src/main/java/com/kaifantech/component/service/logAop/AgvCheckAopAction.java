package com.kaifantech.component.service.logAop;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ytgrading.util.AppTool;

@Aspect
@Component
public class AgvCheckAopAction {
	@Around("@within(com.ytgrading.annotation.AgvChecker)")
	public Object clear(ProceedingJoinPoint point) throws Exception {
		Object result = null;
		try {
			if (!"agv".equals(point.getSignature().getName())) {
				Object obj = point.getTarget();
				Class<? extends Object> clazz = obj.getClass();
				Field field = clazz.getDeclaredField("agvId");
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				Method getMethod = pd.getReadMethod();
				Integer agvId = (Integer) getMethod.invoke(obj);
				if (AppTool.isNull(agvId) || agvId < 0) {
					return "使用前必须使用agv()方法指定所要操作agv的编号";
				}
				result = point.proceed();
				Method setMethod = pd.getWriteMethod();
				setMethod.invoke(obj, -1);
			} else {
				result = point.proceed();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}
