package com.maq.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.bean.UserMainInfo;
import com.maq.bean.userdetailinfo.LivingCondition;
import com.maq.bean.userdetailinfo.LoveAttitude;
import com.maq.bean.userdetailinfo.MatingPreference;
import com.maq.bean.userdetailinfo.UserInterests;
import com.maq.bean.userdetailinfo.WorkingCondition;

public interface UserDetailInfoSvc {

	

	ResponseMessage doEditInterests(UserInterests userInterests, HttpSession session);

	ResponseMessage doEditLivingCondition(LivingCondition livingCondition, HttpSession session);

	ResponseMessage doEditLoveAttitude(LoveAttitude loveAttitude, HttpSession session);

	ResponseMessage doEditMatingPreference(MatingPreference matingPreference, HttpSession session);

	ResponseMessage doEditWorkingCondition(WorkingCondition workingCondition, HttpSession session);

	
	
}
