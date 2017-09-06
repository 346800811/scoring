package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.UserMapper;
import com.scoring.model.User;
import com.scoring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	public List<User> list() {
		return userMapper.list();
	}

	@Override
	public boolean check(User user) {
		List<User> check = userMapper.check(user);
		if (check == null || check.size() == 0){
			return false;
		} else {
			user.setId(check.get(0).getId());
			return true;
		}
	};

}
