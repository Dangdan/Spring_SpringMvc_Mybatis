package com.ddd.ssm.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddd.ssm.dao.UserDao;
import com.ddd.ssm.pojo.User;

public class UserDaoImplTest {
	//在setUp()方法中得到spring容器
	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		//得到bean
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		//调用userDao的方法
		User u=userDao.findUserById(1);
		System.out.println(u);
	}

}
