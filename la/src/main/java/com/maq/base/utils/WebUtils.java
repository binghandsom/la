package com.maq.base.utils;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

public class WebUtils {

	public static final String CONTENTTYPE_TEXTJSON = "application/json";
	public static final String CONTENT_CHARSET_UTF8 = "UTF-8";
	public static final String CONTENTTYPE_TEXTHTML = "text/html";

	public static void sendDirectToClient(HttpServletResponse response, String contenttypeTextjson,
			String contentCharsetUtf8, String jsonResult) {
		try {
			response.setCharacterEncoding(contentCharsetUtf8);
			response.setContentType(contenttypeTextjson);
			Writer writer = response.getWriter();
			writer.write(jsonResult);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
