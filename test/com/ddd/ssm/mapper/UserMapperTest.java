package com.ddd.ssm.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddd.ssm.pojo.User;
import com.ddd.ssm.pojo.UserCustom;

public class UserMapperTest {
	// 在setUp()方法中得到spring容器
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		UserMapper userMapper=(UserMapper) applicationContext.getBean("userMapper");
		User u=userMapper.selectByPrimaryKey(1);
		System.out.println(u);
	}

}
