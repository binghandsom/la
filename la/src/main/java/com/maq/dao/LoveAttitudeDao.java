package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.userdetailinfo.LoveAttitude;

@Repository
public class LoveAttitudeDao extends CommonDao<LoveAttitude> {

	@Override
	protected Class<LoveAttitude> getEntityClass() {
		return LoveAttitude.class;
	}

}
