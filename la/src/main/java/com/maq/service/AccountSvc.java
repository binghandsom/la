package com.maq.service;

import javax.servlet.http.HttpSession;

import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;

public interface AccountSvc {
	void add(Account account);

	ResponseMessage loginCheck(Account account, HttpSession session);

	ResponseMessage sendValidateCode(Account account, String reason, HttpSession session);

	ResponseMessage register(Account account, HttpSession session);

	Object[] accountAvailable(Account account, HttpSession session, String valiCode, String doWhat);

	ResponseMessage changePass(Account account, HttpSession session);
}
