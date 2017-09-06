package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.ProjMapper;
import com.scoring.model.Proj;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProjTest {
	@Autowired
	private ProjMapper projMapper;

	@Test
	public void testProjList() {
		List<Proj> objs = projMapper.query(3);
		for (Proj c : objs) {
			System.out.println(c.getName());
		}
	}

}
