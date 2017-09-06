package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.ScoreMapper;
import com.scoring.model.Score;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ScoreTest {
	@Autowired
	private ScoreMapper scoreMapper;

	@Test
	public void testProjList() {
		List<Score> objs = scoreMapper.list();
		for (Score c : objs) {
			System.out.println(c);
		}
	}

}
