package com.maq.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.bean.UserMainInfo;

public interface UserMainInfoSvc {

	ResponseMessage checkNickName(String nickName);

	void save(UserMainInfo baseInfo);

	ResponseMessage uploadHeadPics(HttpSession session);

	List<UserMainInfo> getMainInfosList(Account account);
	
}
