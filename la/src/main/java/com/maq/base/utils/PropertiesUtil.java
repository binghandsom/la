package com.maq.base.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
	// 如果配置文件在classpath目录下可以使用ClassPathResource对象
	/**
	 * 
	 * @param configFilePath 比如："config/properties/common.properties"
	 * @param key 比如："fileSystemRoot"
	 * @return value 比如："/home/wantLoverFiles"
	 */
	public static String getPropertyValue(String configFilePath, String key) {
		Resource resource = new ClassPathResource(configFilePath);
		String value = "";
		try {
			Properties property = PropertiesLoaderUtils.loadProperties(resource);
			value = property.getProperty(key);
			// System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
