package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.userdetailinfo.UserInterests;

@Repository
public class UserInterestsDao extends CommonDao<UserInterests> {

	@Override
	protected Class<UserInterests> getEntityClass() {
		return UserInterests.class;
	}

}
