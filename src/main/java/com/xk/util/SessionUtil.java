package com.xk.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.xk.entity.MyUser;


public class SessionUtil {

	/**
	 * 
	 * 功能：在SESSION中保存登录用户信息的当前的用户
	 * 如果该函数引用或修改了某些全局变量或对象，也应在函数级注释中说明
	 * ---------------------------------------
	 */
	public static void setCurrAuthInfo(HttpServletRequest request, MyUser user) throws Exception {
		Assert.notNull(request);
		request.getSession(true).setAttribute("user", user);
	}


	/**
	 * @描述：获取当前用户的基本信息
	 *
	 */
	public static MyUser getCurrAuthInfo(HttpServletRequest request) {
		Assert.notNull(request);
		return (MyUser) request.getSession(true).getAttribute("user");
	}


	/**
	 * 在SESSION中放置对象
	 */
	public static void put(HttpServletRequest request, String key, Object obj) {
		Assert.notNull(request);
		request.getSession(true).setAttribute(key, obj);
	}

	/**
	 * 
	 * @Title: 保存对象到SESSION
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param request
	 * @param key
	 * @return Object
	 */
	public static Object get(HttpServletRequest request, String key) {

		return request.getSession(true).getAttribute(key);
	}
	
	public static void logout(HttpServletRequest request) {
		Assert.notNull(request);
		((HttpServletRequest) request).getSession().invalidate();
		((HttpServletRequest) request).getSession().removeAttribute("user");
	}
	
}
