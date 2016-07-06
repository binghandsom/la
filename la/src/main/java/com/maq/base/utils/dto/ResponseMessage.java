package com.maq.base.utils.dto;

import java.util.Map;

/**
 * 包装返回给客户端数据的对象
 * @author wbb
 *
 */
public class ResponseMessage {
	private Map<String,String> message;//消息内容 <消息标题，消息结果>
	private boolean isSuccess;//做某事是否成功
	public Map<String, String> getMessage() {
		return message;
	}
	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", success=" + isSuccess + "]";
	}
	
}
