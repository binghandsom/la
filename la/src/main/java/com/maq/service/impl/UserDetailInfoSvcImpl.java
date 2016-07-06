package com.maq.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.maq.base.utils.StringUtil;
import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.bean.userdetailinfo.LivingCondition;
import com.maq.bean.userdetailinfo.LoveAttitude;
import com.maq.bean.userdetailinfo.MatingPreference;
import com.maq.bean.userdetailinfo.UserInterests;
import com.maq.bean.userdetailinfo.WorkingCondition;
import com.maq.dao.LivingConditionDao;
import com.maq.dao.LoveAttitudeDao;
import com.maq.dao.MatingPreferenceDao;
import com.maq.dao.UserInterestsDao;
import com.maq.dao.WorkingConditionDao;
import com.maq.service.UserDetailInfoSvc;

@Service
public class UserDetailInfoSvcImpl implements UserDetailInfoSvc {
	@Autowired
	private UserInterestsDao interestsDao;
	@Autowired
	private LivingConditionDao livingConditionDao;
	@Autowired
	private LoveAttitudeDao loveAttitudeDao;
	@Autowired
	private MatingPreferenceDao matingPreferenceDao;
	@Autowired
	private WorkingConditionDao workingConditionDao;

	private Query query;
	private Update update;

	public ResponseMessage doEditInterests(UserInterests userInterests, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		String id = "";
		try {
			id = ((Account) session.getAttribute("account")).getId();
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		id = "测试id";
		userInterests.setId(id);
		try {
			interestsDao.save(userInterests);
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		return rm;
	}

	public ResponseMessage doEditLivingCondition(LivingCondition livingCondition, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		String id = "";
		try {
			id = ((Account) session.getAttribute("account")).getId();
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		id = "测试id";
		livingCondition.setId(id);
		try {
			livingConditionDao.save(livingCondition);
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		return rm;
	}

	public ResponseMessage doEditLoveAttitude(LoveAttitude loveAttitude, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		String id = "";
		try {
			id = ((Account) session.getAttribute("account")).getId();
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		id = "测试id";
		loveAttitude.setId(id);
		try {
			loveAttitudeDao.save(loveAttitude);
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		return rm;
	}

	public ResponseMessage doEditMatingPreference(MatingPreference matingPreference, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		String id = "";
		try {
			id = ((Account) session.getAttribute("account")).getId();
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		id = "测试id";
		matingPreference.setId(id);
		try {
			matingPreferenceDao.save(matingPreference);
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		return rm;
	}

	public ResponseMessage doEditWorkingCondition(WorkingCondition workingCondition, HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		String id = "";
		try {
			id = ((Account) session.getAttribute("account")).getId();
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		id = "测试id";
		workingCondition.setId(id);
		try {
			workingConditionDao.save(workingCondition);
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.setSuccess(false);
		}
		return rm;
	}

}
