/**	
 * <br>
 * Copyright 2011 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.ywq.base.utils <br>
 * FileName: DistrictUtils.java <br>
 * <br>
 * @version
 * @author ShaoBing
 * @created 2014年12月31日
 * @last Modified 
 * @history
 */

package com.maq.base.utils;

/**
 * 区划编码处理工具类
 * 
 * @author sbwang2@iflytek.com
 * @lastModified
 * @history
 */

public class DistrictUtils {

	/**
	 * 市级别
	 */
	private static final String CITY_LEVEL = "2";

	/**
	 * 市编码长度
	 */
	private static final int CITY_CODE_LENGHT = 4;

	/**
	 * 区级别
	 */
	private static final String DISTRICT_LEVEL = "3";

	/**
	 * 区编码长度
	 */
	private static final int DISTRICT_CODE_LENGHT = 6;

	/**
	 * 街道级别
	 */
	private static final String STREET_LEVEL = "4";

	/**
	 * 街道编码长度
	 */
	private static final int STREET_CODE_LENGHT = 9;

	/**
	 * 社区级别
	 */
	private static final String COMMUNITY_LEVEL = "5";

	/**
	 * 社区编码长度
	 */
	private static final int COMMUNITY_CODE_LENGHT = 12;

	/**
	 * 区域编码处理
	 * 
	 * @param code
	 *            编码
	 * @param level
	 *            级别
	 * @return
	 * @author sbwang2@iflytek.com
	 * @created 2014年12月31日 下午4:55:53
	 * @lastModified
	 * @history
	 */
	public static String districtCode(String code, String level) {
		if (StringUtil.isNotBlank(code)) {
			if (StringUtil.equals(CITY_LEVEL, level)) {
				return code.substring(0, CITY_CODE_LENGHT);
			}
			if (StringUtil.equals(DISTRICT_LEVEL, level)) {
				return code.substring(0, DISTRICT_CODE_LENGHT);
			}
			if (StringUtil.equals(STREET_LEVEL, level)) {
				return code.substring(0, STREET_CODE_LENGHT);
			}
			if (StringUtil.equals(COMMUNITY_LEVEL, level)) {
				return code.substring(0, COMMUNITY_CODE_LENGHT);
			}
			return code;
		}
		return "";
	}

	/**
	 * 区划编码结尾去零
	 * 
	 * @param code
	 *            编码
	 * @return
	 * @author sbwang2@iflytek.com
	 * @created 2015年1月5日 下午3:27:15
	 * @lastModified
	 * @history
	 */
	public static String distirctCode(String code) {
		if(StringUtil.isNotBlank(code)){
			int zeroIndex = code.length();
			for (int i = code.length() - 1; i >= 0; i--) {
				if(code.charAt(i) != '0'){
					zeroIndex = i + 1;
					break;
				}
			}
			return code.substring(0,zeroIndex);
		}
		return "";
	}
}
