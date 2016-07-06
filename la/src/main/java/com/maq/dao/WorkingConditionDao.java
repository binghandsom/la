package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.userdetailinfo.WorkingCondition;
@Repository
public class WorkingConditionDao extends CommonDao<WorkingCondition> {
	@Override
	protected Class<WorkingCondition> getEntityClass() {
		return WorkingCondition.class;
	}
}
