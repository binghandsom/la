package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.userdetailinfo.LivingCondition;

@Repository

public class LivingConditionDao extends CommonDao<LivingCondition> {

	@Override
	protected Class<LivingCondition> getEntityClass() {
		return LivingCondition.class;
	}

}
