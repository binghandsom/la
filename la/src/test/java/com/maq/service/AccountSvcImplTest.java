package com.maq.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maq.service.impl.AccountSvcImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/applicationContext.xml","classpath:config/mongodb/mongodb.xml"})
public class AccountSvcImplTest  {
//
	@Autowired
	private AccountSvcImpl accountSvcImpl;
//	
	@Test
	public void testSave(){
		System.out.println("xxx");
	}
//	
//	
//	@Test
//	public void testFindBlogTransmit(){
//		BlogTransmit bt = new BlogTransmit();
//		bt.setTransmitid("108d87e93e4842e7af226a6d35404c89");
//		bt = transmitService.findBlogTransmit(bt);
//		System.out.println(bt);
//		
//	}
//	
//	@Test
//	public void testAddBlogTransmit(){
//		BlogTransmit bt = new BlogTransmit();
//		bt.setTransmitid("208d87e93e4842e7af226a6d35404c89");
//		transmitService.addBlogTransmit(bt);
//		System.out.println(bt);
		
//	}
//	
//	@Test
//	public void testDelBlogTransmit(){
//		BlogTransmit bt = new BlogTransmit();
//		bt.setTransmitid("208d87e93e4842e7af226a6d35404c89");
//		transmitService.delBlogTransmit(bt);
//		System.out.println(bt);
//		
//	}
//	
//	
//	
//	
//	
	
	
	
	
	
}

