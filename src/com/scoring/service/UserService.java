package com.scoring.service;

import java.util.List;

import com.scoring.model.User;

public interface UserService {
	List<User> list();

	/**
	 * 检查用户、密码、类型是否存在
	 */
	boolean check(User user);
}
