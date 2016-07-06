package com.maq.dao;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maq.bean.UserMainInfo;
import com.maq.dao.UserDao;
import com.maq.service.UserSvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/applicationContext.xml","classpath:config/mongodb/mongodb.xml"})
public class TestBaseDao{

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserSvc userSvc;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void test(){
//		User user = userSvc.getByName("meihf");
//		User user = userDao.queryOne(new Query().addCriteria(Criteria.where("loginName").is("meihf")));
		System.out.println("xx");
	}
}
