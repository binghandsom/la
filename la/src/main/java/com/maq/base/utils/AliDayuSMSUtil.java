package com.maq.base.utils;

import org.apache.commons.lang.RandomStringUtils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class AliDayuSMSUtil {
	private final static String URL = "http://gw.api.taobao.com/router/rest";
	private final static String APPKEY = "23342306";
	private final static String SECRET = "ae52030eaa61b96754954c4685d7b3e4";
	public final static String SIGNNAME_REG = "注册验证";
	public final static String SIGNNAME_CHANGE_PASSWORD = "变更验证";
	private static TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);

	/**
	 * 
	 * @param targetPhoneNum
	 *            接收短信的手机
	 * @param signName汉字常量
	 *            如： 注册验证 登录验证 变更验证 参考：
	 *            http://www.alidayu.com/admin/service/sign
	 * @return
	 */
	public static String sendAliDayuMSG(String targetPhoneNum, String signName) {
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName(signName);
		String validateCode = generateRandomCode();
		System.out.println(validateCode);
		req.setSmsParamString("{\"code\":\" " + validateCode + "\",\"product\":\"我要觅情网\"}");
		req.setRecNum(targetPhoneNum);
		if (SIGNNAME_REG.equals(signName)) {
			// 注册短信模板
			req.setSmsTemplateCode("SMS_7510344");
		} else if (SIGNNAME_CHANGE_PASSWORD.equals(signName)) {
			// 修改密码验证码模板
			req.setSmsTemplateCode("SMS_7510342");
		}
		// 验证码${code}，您正在登录${product}，若非本人操作，请勿泄露。
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			System.out.println(rsp.getMsg());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return validateCode;
	}

	private static String generateRandomCode() {
		return RandomStringUtils.random(6, true, true).toLowerCase();
	}

	public static void main(String[] args) {
		sendAliDayuMSG("13095531769", SIGNNAME_REG);
	}
}
