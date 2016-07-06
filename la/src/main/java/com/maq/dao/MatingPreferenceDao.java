package com.maq.dao;

import org.springframework.stereotype.Repository;

import com.maq.bean.userdetailinfo.MatingPreference;

@Repository
public class MatingPreferenceDao extends CommonDao<MatingPreference> {
	@Override
	protected Class<MatingPreference> getEntityClass() {
		return MatingPreference.class;
	}
}
