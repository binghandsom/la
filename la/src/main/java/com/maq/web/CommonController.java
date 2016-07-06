package com.maq.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maq.bean.Account;
import com.maq.bean.UserMainInfo;
import com.maq.service.UserMainInfoSvc;

@Controller
@RequestMapping("common")
public class CommonController {
	@Autowired
	private UserMainInfoSvc umiSvc;

	@RequestMapping("index")
	public String index(HttpSession session, Model model) {
		Account account = (Account) session.getAttribute("account");
		if (account != null) {

			List<UserMainInfo> userMainInfos = umiSvc.getMainInfosList(account);
			
			for (UserMainInfo userMainInfo : userMainInfos) {
				System.out.println(userMainInfo.toString());
			}
			model.addAttribute("userMainInfos", userMainInfos);

			return "common/index";
		}
		return "userAccount/regAndLogin";
	}

}
