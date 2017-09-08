package com.scoring.service;

import java.util.List;

import com.scoring.model.User;

public interface UserService {
	List<User> list();

	/**
	 * 检查用户、密码、类型是否存在<br>
	 * 并将数据库ID更新到对象
	 */
	boolean check(User user);
}
