package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.UserMainInfo;

@Repository
public class UserMainInfoDao extends CommonDao<UserMainInfo> {

	@Override
	protected Class<UserMainInfo> getEntityClass() {
		return UserMainInfo.class;
	}

}
