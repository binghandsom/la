package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.UserMainInfo;
@Repository
public class UserDao extends CommonDao<UserMainInfo> {

	@Override
	protected Class<UserMainInfo> getEntityClass() {
		return UserMainInfo.class;
	}

}
