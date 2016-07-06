package com.maq.base.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 *  xml字符串解析工具类
 *  @author llchen@iflytek.com
 *  @created 2015-2-28 下午12:45:44
 *  @lastModified       
 *  @history
 */
@SuppressWarnings("unchecked")
public class ParseXmlUtil {

	/**
	 * 校验查询返回结果
	 * @param responseStr 查询返回消息内容
	 * @return 查询结果
	 * @author huiwang8
	 * @created 2015-1-7 下午9:03:39
	 */
	public static boolean checkQuery(String responseStr) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(responseStr);
			Element rootElt = doc.getRootElement();
			Iterator iterss = rootElt.elementIterator("body");
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				String result = recordEless.elementTextTrim("resultCode");
				if ("00".equals(result)) {
					return true;
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 解析XML字符串信息
	 * @param responseStr 查询返回消息内容
	 * @param clazz Class
	 * @author huiwang8
	 * @created 2015-1-7 下午9:04:09
	 */
	public static List parseXml(String responseStr, Class clazz) {
		List resultList = new ArrayList();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(responseStr);
			Element rootElt = doc.getRootElement();
			Iterator iterss = rootElt.elementIterator("body");
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				Iterator itersElIterator = recordEless
						.elementIterator("resultList");
				while (itersElIterator.hasNext()) {
					Element result = (Element) itersElIterator.next();
					Iterator itersElIterator1 = result
							.elementIterator("result");
					while (itersElIterator1.hasNext()) {
						Element temp = (Element) itersElIterator1.next();
						Object o = transferEleInfoToEntity(temp, clazz);
						resultList.add(o);
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	/**
	 *  转换查询结果到实体对象信息
	 *  @param element Element 结果元素
	 *  @param clazz Class 
	 *  @return 实体对象
	 *  @author huiwang8
	 *  @created 2015-1-8 下午4:27:07
	 */
	private static Object transferEleInfoToEntity(Element element, Class clazz) {
		Object o = null;
		try {
			o = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		for (Object e : element.elements()) {
			Element e1 = (Element) e;
			setProperty(o, e1.getQName().getName(), e1.getTextTrim());
		}
		
		return o;
	}

	/**
	 *  设置对象属性值
	 *  @param obj Object对象
	 *  @param name String 属性名
	 *  @param value String 属性值
	 *  @author huiwang8
	 *  @created 2015-1-8 下午4:25:56
	 */
	private static void setProperty(Object obj, String name, String value) {
		Class clz = obj.getClass();
		Field[] fds = clz.getDeclaredFields();
		for (int i = 0; i < fds.length; i++) {
			Field f = fds[i];
			if (f.getName().equalsIgnoreCase(name)) {
				f.setAccessible(true);
				try {
					f.set(obj, value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				return;
			}
		}
	}
}
