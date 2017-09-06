package com.scoring.service;

import java.util.List;

import com.scoring.model.User;

public interface UserService {
	/**
	 * 查询用户列表
	 * @return
	 */
	List<User> list();

	/**
	 * 检查用户、密码、类型是否存在
	 * @param user
	 * @return
	 */
	boolean check(User user);
}
