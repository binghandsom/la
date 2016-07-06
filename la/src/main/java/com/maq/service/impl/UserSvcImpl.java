package com.maq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.maq.bean.UserMainInfo;
import com.maq.dao.UserDao;
import com.maq.service.UserSvc;
@Service
public class UserSvcImpl implements UserSvc{

	@Autowired
	private UserDao userDao;

	public UserMainInfo getByName(String username) {
		return userDao.queryById(username);
	}
}
