package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.UserMapper;
import com.scoring.mapper.VScoreMapper;
import com.scoring.model.User;
import com.scoring.model.VScore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
	@Autowired
	private UserMapper categoryMapper;
	@Autowired
	private VScoreMapper vScoreMapper;

//	public void testAdd() {
//		Category category = new Category();
//		category.setName("new Category");
//		categoryMapper.add(category);
//	}

	@Test
	public void testList() {
		List<User> cs = categoryMapper.list();
		for (User c : cs) {
			System.out.println(c.getName());
			System.out.println(c.getPasswd());
			System.out.println(c.getType());
		}
	}
	@Test
	public void testVScoreList() {
		List<VScore> cs = vScoreMapper.list(3);
		for (VScore c : cs) {
			System.out.println(c.getMname()+" " +c.getPname() + " " + c.getScore());
		}
	}

}
