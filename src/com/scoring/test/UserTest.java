package com.scoring.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.model.User;
import com.scoring.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void testUserList() {
		User user = new User();
		user.setName("admin");
		user.setPasswd("0"); // 密码错误
		user.setType(3);
		boolean check = userService.check(user);
		System.out.println(check);
		Assert.assertFalse(check);

		user.setPasswd("1"); // 正确
		check = userService.check(user);
		System.out.println(check);
		Assert.assertTrue(check);
	}

}
