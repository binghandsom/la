/**	
 * <br>
 * Copyright 2014 IFlyTek.All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.mzyw.base.utils <br>
 * FileName: BrowserUtil.java <br>
 * <br>
 * @version
 * @author Administrator
 * @created 2015-2-12
 * @last Modified 
 * @history
 */
package com.maq.base.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务器端浏览器判断
 * 
 * @author miaochen
 * @created 2015-2-12 下午02:13:42
 * @lastModified
 * @history
 */
public class BrowserUtil {
	/**
	 * IE
	 */
	public static final String MSIE = "msie";
	/**
	 * 火狐
	 */
	public static final String FIREFOX = "firefox";
	/**
	 * MAC
	 */
	public static final String SAFARI = "safari";

	/**
	 * 获取浏览器客户端类型
	 * 
	 * @param request
	 * @return
	 * @author miaochen
	 * @created 2015-2-12 下午02:21:38
	 * @lastModified
	 * @history
	 */
	public static String getBrowser(HttpServletRequest request) {
		String UserAgent = request.getHeader("USER-AGENT").toLowerCase();
		if (UserAgent != null) {
			if (UserAgent.indexOf(MSIE) >= 0)
				return MSIE;
			if (UserAgent.indexOf(FIREFOX) >= 0)
				return FIREFOX;
			if (UserAgent.indexOf(SAFARI) >= 0)
				return SAFARI;
		}
		return null;
	}

}
