package com.scoring.mapper;

import java.util.List;

import com.scoring.model.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> list();

	/**
	 * 查询是否有匹配的用户、密码、类型
	 * @param user
	 * @return
	 */
	List<User> check(User user);
}