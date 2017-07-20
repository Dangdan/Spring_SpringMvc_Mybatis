package com.ddd.ssm.dao;

import com.ddd.ssm.pojo.User;

/**
 * 用户的dao接口
 * @author Dan
 *
 */
public interface UserDao {
	//根据id查询一个user
	public User findUserById(int id);

}
