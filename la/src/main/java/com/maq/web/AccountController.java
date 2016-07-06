package com.maq.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.service.AccountSvc;
import com.maq.service.UserSvc;
import com.maq.service.impl.AccountSvcImpl;

@Controller
@RequestMapping("userAccount")
public class AccountController {
	@Autowired
	private UserSvc userSvc;
	@Autowired
	private AccountSvc accountSvc;

	@RequestMapping("regAndLogin")
	public String regAndLogin() {
		return "userAccount/regAndLogin";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage register(Account account, String valiCode, HttpSession session, Model model) {
		ResponseMessage rm = new ResponseMessage();
		Map<String, String> msgMap = new HashMap<String, String>();
		Object[] availableArr = accountSvc.accountAvailable(account, session, valiCode,
				AccountSvcImpl.DO_REGISTER_ACCOUNT);
		if (!(Boolean) availableArr[0]) {
			// 如果账号不可用,或者验证码出现问题
			rm.setSuccess(false);
			msgMap.put("resultMess", availableArr[1].toString());
			rm.setMessage(msgMap);
		} else {
			rm = accountSvc.register(account, session);
		}
		System.out.println(account.toString() + valiCode);

		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "doChangePass", method = RequestMethod.POST)
	public ResponseMessage doChangePass(Account account, String valiCode, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		Map<String, String> msgMap = new HashMap<String, String>();
		Object[] availableArr = accountSvc.accountAvailable(account, session, valiCode, AccountSvcImpl.DO_CHANGE_PASS);
		if (!(Boolean) availableArr[0]) {
			// 如果账号不存在,或者验证码出现问题
			rm.setSuccess(false);
			msgMap.put("resultMess", availableArr[1].toString());
			rm.setMessage(msgMap);
		} else {
			rm = accountSvc.changePass(account, session);
		}
		System.out.println(account.toString() + valiCode);

		return rm;
	}

	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage loginCheck(Account account, HttpSession session) {
		System.out.println(account);
		// 如果此用户登录成功则将用户账号信息保存在session中，service层中以做此保存操作
		ResponseMessage rm = accountSvc.loginCheck(account, session);
		System.out.println(rm);
		return rm;

	}

	/**
	 * 
	 * @param phoneNum
	 * @param email
	 * @param reason
	 *            发送验证码的原因，可以是注册，也可以是改密
	 * @param session
	 *            将验证码保存起来
	 */
	@RequestMapping(value = "sendRegValidateCode", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage sendValidateCode(Account account, String reason, HttpSession session) {
		// System.out.println(phone);
		ResponseMessage rm = accountSvc.sendValidateCode(account, reason, session);
		System.out.println(rm);
		return rm;
	}

	@RequestMapping("changePass")
	public String changePass() {
		return "userAccount/changePass";
	}

}
