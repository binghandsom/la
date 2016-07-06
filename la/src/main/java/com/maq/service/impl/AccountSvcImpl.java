package com.maq.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.maq.base.utils.AliDayuSMSUtil;
import com.maq.base.utils.MD5Util;
import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.dao.AccountDao;
import com.maq.service.AccountSvc;

@Service
public class AccountSvcImpl implements AccountSvc {
	@Autowired
	private AccountDao accountDao;
	private Query query;
	private Map<String, Object[]> valiCodeTimeMap;// 记录验证码和验证码的产生时间
	private Map<String, Object[]> loginFailMap;// 记录登陆失败时间和登陆次数，如果一天内登陆连续失败4次，禁止登陆
	private Map<String, Long> lockedAccountMap;// 记录被锁定的账号和锁定 的时间
	public final static String DO_REGISTER_ACCOUNT = "register";
	public final static String DO_CHANGE_PASS = "changePass";

	// 构造函数初始化Map，避免空指针
	public AccountSvcImpl() {
		loginFailMap = new HashMap<String, Object[]>();
		lockedAccountMap = new HashMap<String, Long>();
	}

	public void add(Account account) {
		accountDao.save(account);
	}

	public ResponseMessage loginCheck(Account account, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		// 存放消息 消息名》》消息内容
		Map<String, String> rmMap = new HashMap<String, String>();
		/**
		 * 注意这里的email不是表面上的email,他可以是email或者phone
		 */
		String email;
		String password;
		try {
			// 捕获空指针异常
			email = account.getEmail();
			password = account.getPassword();
		} catch (Exception ex) {
			rm.setSuccess(false);
			return rm;
		}
		if (email == null || password == null || "".equals(email) || "".equals(password)) {
			rm.setSuccess(false);
			return rm;
		}
		// 如果账号处于锁定期不继续进行验证密码
		if (lockedAccountMap.containsKey(email)) {
			long lockTime = lockedAccountMap.get(email);
			long temp = System.currentTimeMillis() - lockTime;
			if (temp < 60 * 1000 * 24) {
				rm.setSuccess(false);
				rmMap.put("failDetail", "您可以重置密码。该账号" + (24 * 60 - temp / (1000 * 60)) + "分钟后解除锁定。");
				rm.setMessage(rmMap);
				return rm;
			} else {
				// 时间到，解除锁定
				lockedAccountMap.remove(email);
			}
		}
		// 转化为md5字符串
		password = MD5Util.GetMD5Code(password);
		if (email.contains("@")) {
			// 是邮箱
			query = new Query(Criteria.where("email").is(email).andOperator(Criteria.where("password").is(password)));
		} else {
			// 账号是手机
			query = new Query(Criteria.where("phone").is(email).andOperator(Criteria.where("password").is(password)));
		}
		Account account2 = accountDao.queryOne(query);
		if (account2 != null) {
			// 将用户信息保存至session
			session.setAttribute("account", account2);
			rm.setSuccess(true);
		} else {
			int failTimes = 1;
			// 密码不正确，、
			rmMap.put("failDetail", "账号密码不正确，该账号今天剩余3次登陆尝试机会");
			if (loginFailMap.containsKey(email)) {
				Object[] failTimesAndTime = loginFailMap.get(email);
				failTimes = Integer.parseInt(failTimesAndTime[0].toString());
				if (failTimes < 4) {
					// 还可以继续尝试输入密码
					failTimes += 1;
					rmMap.put("failDetail", "账号密码不正确，该账号今天剩余" + (4 - failTimes) + "次登陆尝试机会");
				} else {
					// 锁定账号，用户必须使用手机或者邮箱重置密码
					lockedAccountMap.put(email, System.currentTimeMillis());
					rmMap.put("failDetail", "该账号被锁定一天，你可以使用手机或者邮箱重置密码");
				}
			}
			Object[] failTimesAndTime = new Object[] { failTimes, System.currentTimeMillis() };// 失败次数和失败的时间
			// 将失败的时间和失败的次数保存进loginFailMap中
			loginFailMap.put(email, failTimesAndTime);
		}
		rm.setMessage(rmMap);
		return rm;
	}

	public ResponseMessage sendValidateCode(Account account, String reason, HttpSession session) {
		ResponseMessage message = new ResponseMessage();
		// 存放某手机或邮箱的验证码和验证码产生的毫秒数 object[0] 验证码，object[1]时间
		valiCodeTimeMap = (Map<String, Object[]>) session.getAttribute("valiCodeTimeMap");
		// 保存失败详细信息的map
		Map<String, String> failMap = new HashMap<String, String>();
		// 在发送完验证码后将验证码保存在session中，
		Object[] preValiCodeAndTime = new Object[2];
		String validateCode = "";
		String phone = account.getPhone();
		String email = account.getEmail();
		if (phone != null) {
			String regRule = "^[1][0-9]{10}$";
			Pattern p = Pattern.compile(regRule);
			Matcher m = p.matcher(phone);
			if (!m.matches()) {
				// 如果手机号码格式不正确
				message.setSuccess(false);
				// 可以在message中增加信息，这样前端页面反馈给用户不一样的信息，增强用户体验
				failMap.put("failReason", "手机格式不正确");
				message.setMessage(failMap);
				return message;
			}
			if (valiCodeTimeMap == null) {
				valiCodeTimeMap = new HashMap<String, Object[]>();
			}
			if (valiCodeTimeMap.containsKey(phone)) {
				// 获取该entry的value
				preValiCodeAndTime = valiCodeTimeMap.get(phone);
				if (preValiCodeAndTime != null) {
					long preTime = (Long) preValiCodeAndTime[1];
					// 如果验证码发送未超过60秒不允许再次请求验证，如果不限制时间，可能会出现机器盗号现象
					if (System.currentTimeMillis() - preTime < 1000 * 60) {
						// 让请求失败
						message.setSuccess(false);
						// 可以在message中增加信息，这样前端页面反馈给用户不一样的信息，增强用户体验
						failMap.put("failReason", "验证码过期，请重新获取");
						message.setMessage(failMap);
						return message;
					}
				}
			}

			if ("register".equals(reason)) {
				// 发送短信注册验证码
				/**
				 * 产生验证码并发送
				 */
				// 注册账号操作，如果已经存在这样的账号，则不让继续注册，也不发验证码
				if (accountDao.isUsed(account)) {
					message.setSuccess(false);
					// 可以在message中增加信息，这样前端页面反馈给用户不一样的信息，增强用户体验
					failMap.put("failReason", "该账号已被注册，忘记密码？您可以重置密码");
					message.setMessage(failMap);
					return message;
				}
				validateCode = AliDayuSMSUtil.sendAliDayuMSG(phone, AliDayuSMSUtil.SIGNNAME_REG);

			} else if ("changePass".equals(reason)) {
				// 发送短信改密验证码
				/**
				 * 产生验证码并发送
				 */
				// 修改密码操作,如果不存在这样的账号，肯定不让修改密码,所以没必要发送改密验证码
				if (!accountDao.isUsed(account)) {
					message.setSuccess(false);
					// 可以在message中增加信息，这样前端页面反馈给用户不一样的信息，增强用户体验
					failMap.put("failReason", "不存在这样的账号，请检查账号是否填写正确（注册时用的手机号或者邮箱号）");
					message.setMessage(failMap);
					return message;
				}
				validateCode = AliDayuSMSUtil.sendAliDayuMSG(phone, AliDayuSMSUtil.SIGNNAME_CHANGE_PASSWORD);
			}

			message.setSuccess(true);

			Object[] codeAndTime = { validateCode, System.currentTimeMillis() };
			valiCodeTimeMap.put(phone, codeAndTime);

			session.setAttribute("valiCodeTimeMap", valiCodeTimeMap);

		} else if (email != null) {
			String regRule = "/^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,9})$/";
			Pattern p = Pattern.compile(regRule);
			Matcher m = p.matcher(email);
			if (!m.matches()) {
				// 如果邮箱格式不正确
				message.setSuccess(false);
				return message;
			}
			preValiCodeAndTime = (Object[]) session.getAttribute("valiCodeTimeMap");

			if (valiCodeTimeMap.containsKey(email)) {
				// 获取该entry的value
				preValiCodeAndTime = valiCodeTimeMap.get(email);
				if (preValiCodeAndTime != null) {
					long preTime = (Long) preValiCodeAndTime[1];
					// 如果验证码发送未超过60秒不允许再次请求验证，如果不限制时间，可能会出现机器盗号现象
					if (System.currentTimeMillis() - preTime < 1000 * 60) {
						// 让请求失败
						message.setSuccess(false);
						// 可以在message中增加信息，这样前端页面反馈给用户不一样的信息，增强用户体验
						return message;
					}
				}
			}
			if ("register".equals(reason)) {
				// TODO 发送邮箱注册验证码
				validateCode = "验证码XXXXX";
			} else if ("changePass".equals(reason)) {
				// TODO 发送邮箱改密验证码
				validateCode = "验证码XXXXX";
			}
			Object[] codeAndTime = { validateCode, System.currentTimeMillis() };
			valiCodeTimeMap.put(email, codeAndTime);
			session.setAttribute("valiCodeTimeMap", valiCodeTimeMap);
		}
		return message;

	}

	public ResponseMessage register(Account account, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();

		// 不存在该账号，继续注册
		account.setDel(false);
		account.setPassword(MD5Util.GetMD5Code(account.getPassword()));
		accountDao.save(account);
		rm.setSuccess(true);
		session.setAttribute("account", account);
		return rm;
	}

	public Object[] accountAvailable(Account account, HttpSession session, String valiCode, String doWhat) {
		// 如果此账号已经被注册过，不予注册
		// 判断账号可用不可用是根据session中是否有改账号来决定，因为注册前获取验证码成功后将账号放到了session中，如果session中没有此账号，则不予注册
		// 如果session中有那个账号，再验证验证码是否一致。两者一致才继续注册。否则不予注册
		// 判断验证码是否过期，过期不予注册

		if (DO_CHANGE_PASS.equals(doWhat)) {
			// 修改密码操作,如果不存在这样的账号，肯定不让修改密码
			if (!accountDao.isUsed(account)) {
				return new Object[] { false, "不存在这样的账号" };
			}
		}
		if (valiCodeTimeMap == null || valiCodeTimeMap.size() == 0) {
			return new Object[] { false, "未获取验证码" };
		} else {
			String phone = account.getPhone();
			String email = account.getEmail();
			long currentMil = System.currentTimeMillis();
			// 产生验证码的时间
			long beforeMil = 0L;
			if (valiCodeTimeMap.containsKey(phone)) {
				Object[] array = valiCodeTimeMap.get(phone);
				beforeMil = Long.parseLong(array[1].toString());
				if (currentMil - beforeMil > 60 * 1000) {
					return new Object[] { false, "验证码过期" };
				}
				if (array[0].toString().equalsIgnoreCase(valiCode)) {
					return new Object[] { true, "" };
				}
			} else if (valiCodeTimeMap.containsKey(email)) {
				Object[] array = valiCodeTimeMap.get(email);
				beforeMil = Long.parseLong((String) array[1]);
				if (currentMil - beforeMil > 60 * 1000) {
					return new Object[] { false, "验证码过期" };
				}
				if (array[0].toString().equalsIgnoreCase(valiCode)) {
					return new Object[] { true, "" };
				}
			}
		}
		return new Object[] { false, "验证码不正确" };
	}

	public ResponseMessage changePass(Account account, HttpSession session) {
		// 因为在之前验证码时已经进行过账号验证，所以此处不必进行账号验证
		// 但需要进行密码格式验证
		String email = account.getEmail();
		String phone = account.getPhone();
		ResponseMessage rm = new ResponseMessage();
		Map<String, String> rmMap = new HashMap<String, String>();
		String regRule = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^0-9a-zA-Z]).{6,40}";
		Pattern p = Pattern.compile(regRule);
		String password = account.getPassword();
		Matcher m = p.matcher(password);
		if (!m.matches()) {
			// 如果密码格式错误
			rm.setSuccess(false);
			rmMap.put("resultMess", "密码格式不正确，应该为数字、英文、特殊字符（如：* ！等）的组合");
			rm.setMessage(rmMap);
			return rm;
		}
		Update update = new Update();
		// 将密码MD5加密
		update.set("password", MD5Util.GetMD5Code(password));
		query = new Query(Criteria.where("email").is(email).orOperator(Criteria.where("phone").is(phone)));
		try {
			accountDao.updateFirst(query, update);
			rm.setSuccess(true);
			return rm;
		} catch (Exception e) {
			rm.setSuccess(false);
			rmMap.put("resultMess", "未知错误，修改密码失败");
			rm.setMessage(rmMap);
			return rm;
		}
	}

	public ResponseMessage sendValidateCode(String phoneNum, String email, String reason, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
}
