package com.ddd.ssm.dao.impl;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ddd.ssm.dao.UserDao;
import com.ddd.ssm.pojo.User;
/**
 * 接口实现
 * @author Dan
 *
 */
public class UserDaoImpl  extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) {
		//通过继承SqlSessionDaoSupport，this.getSqlSession()获取到sqlSession
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}


}
