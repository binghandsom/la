package com.maq.service;

import com.maq.bean.UserMainInfo;

public interface UserSvc {

	public UserMainInfo getByName(String username);
}
