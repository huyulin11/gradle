package com.ytgrading.component.controller.system.uimanage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.entity.RoleFormMap;
import com.kaifantech.entity.UserLoginFormMap;
import com.kaifantech.mappings.ErpUserLoginMapper;
import com.ytgrading.erp.util.CurrentUser;
import com.ytgrading.erp.util.SessionUtil;
import com.ytgrading.util.Common;
import com.ytgrading.util.FormMap;

/**
 * 进行管理后台框架界面的类
 * 
 * @author lijianning 2015-04-05
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/")
public class BackgroundController extends BaseController<FormMap<String, Object>> {

	@Inject
	private ErpUserLoginMapper userLoginErpMapper;

	public static final String LOGIN_PAGE = "/agvLogin";
	public static final String AGV_PAGE = "/agvIndex";
	public static final String AGV_WMS_PAGE = "/agvWms";

	/**
	 * @return
	 */
	// @RequestMapping(value = "login", method = RequestMethod.GET, produces =
	// "text/html; charset=utf-8")
	// public String login(HttpServletRequest request) {
	// request.removeAttribute("error");
	// return LOGIN_PAGE;
	// }

	@RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String loginGet(String username, String password, HttpServletRequest request) {
		return doLogin(username, password, request);
	}

	/**
	 * 功能：验证登陆 参数：username：用户名 password：密码 redirect:
	 * 用于跳转到登陆前的地址（redirect为null或空格无效，此时跳转到/manager.shtml）
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String login(String username, String password, HttpServletRequest request) {
		return doLogin(username, password, request);
	}

	private String doLogin(String username, String password, HttpServletRequest request) {
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error", "支持POST方法提交！");
			}
			if (Common.isEmpty(username) || Common.isEmpty(password)) {
				request.setAttribute("error", "用户名或密码不能为空！");
				return LOGIN_PAGE;
			}
			// 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟shiro的拦截地址内．不然后会报空指针
			Subject user = SecurityUtils.getSubject();
			// 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
			// 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
			// 当以上认证成功后会向下执行,认证失败会抛出异常
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				user.login(token);
			} catch (LockedAccountException lae) {
				token.clear();
				request.setAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
				return LOGIN_PAGE;
			} catch (DisabledAccountException dae) {
				token.clear();
				request.setAttribute("error", "用户名为:【" + username + " 】的用户已禁用！");
				return LOGIN_PAGE;
			} catch (ExcessiveAttemptsException e) {
				token.clear();
				request.setAttribute("error", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
				return LOGIN_PAGE;
			} catch (AuthenticationException e) {
				e.printStackTrace();
				token.clear();
				request.setAttribute("error", "用户或密码不正确！");
				return LOGIN_PAGE;
			}
			UserLoginFormMap userLogin = new UserLoginFormMap();
			Session session = SecurityUtils.getSubject().getSession();
			userLogin.put("userId", session.getAttribute("userSessionId"));
			userLogin.put("accountName", username);
			userLogin.put("loginIP", request.getHeader("X-real-ip"));
			userLoginErpMapper.addEntity(userLogin);
			request.removeAttribute("error");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "登录异常，请联系管理员！");
			return LOGIN_PAGE;
		}
		request.getSession().setAttribute("sessionType", CurrentUser.SESSIONTYPE_BACKSTAGE);
		if (request.getParameter("redirect") != null && !"".equals(request.getParameter("redirect"))) {
			String redirect = request.getParameter("redirect").toString();
			try {
				redirect = URLDecoder.decode(redirect, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect" + redirect;
		}

		List<RoleFormMap> roles = SessionUtil.getUserRoleList();

		boolean wmsFlag = false;
		for (RoleFormMap role : roles) {
			if ("AGVMGR".toUpperCase().equals(role.get("roleKey").toString().toUpperCase())) {
				return AGV_PAGE;
			}
			if ("weiwei-wms".equals(role.get("roleKey"))) {
				wmsFlag = true;
			}
		}
		if (wmsFlag) {
			return AGV_WMS_PAGE;
		} else {
			return AGV_WMS_PAGE;
		}
	}

	@RequestMapping("agvIndex")
	public String agvIndex(Model model) throws Exception {
		return "/agvIndex";
	}

	@RequestMapping("agvWms")
	public String agvWms(Model model) throws Exception {
		return "/agvWms";
	}

	@RequestMapping("manager")
	public String manager(Model model) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String domain = request.getHeader("Host");
		if (domain.startsWith("192.168") || domain.startsWith("127.0.0.1")
				|| domain.toLowerCase().startsWith("localhost")) {
			request.setAttribute("selfNet", "true");
		} else {
			request.setAttribute("selfNet", "false");
		}
		model.addAttribute("menuTree", getMenuTree());
		return "/manager";
	}

	@RequestMapping("index")
	public String index(Model model) throws Exception {
		model.addAttribute("menuTree", getMenuTree());
		return "/manager";
	}

	@RequestMapping("welcome")
	public String welcome(Model model) throws Exception {
		return "/welcome";
	}

	@RequestMapping("menu")
	public String menu(Model model) {
		return "/framework/menu";
	}

	@RequestMapping("getRole")
	@ResponseBody
	public String getRole() {
		List<RoleFormMap> roles = SessionUtil.getUserRoleList();

		boolean wmsFlag = false;
		for (RoleFormMap role : roles) {
			if ("admin".equals(role.get("roleKey"))) {
				return "admin";
			}
			if ("weiwei-wms".equals(role.get("roleKey"))) {
				wmsFlag = true;
			}
		}
		if (wmsFlag) {
			return "weiwei-wms";
		} else {
			return "";
		}
	}

	@RequestMapping("findAuthority")
	@ResponseBody
	public List<String> findAuthority(HttpServletRequest request) {
		return null;
	}

	@RequestMapping("download")
	public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\" + "filezip\\";
		String downLoadPath = ctxPath + fileName;
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		// 使用权限管理工具进行用户的退出，注销登录
		SecurityUtils.getSubject().logout(); // session
		// 会销毁，在SessionListener监听session销毁，清理权限缓存
		return LOGIN_PAGE;
	}

}
