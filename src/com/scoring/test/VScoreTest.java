package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.VScoreMapper;
import com.scoring.service.VScoreService;
import com.scoring.model.VScore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class VScoreTest {
	@Autowired
	private VScoreMapper vScoreMapper;
	@Autowired
	private VScoreService vScoreService;

	@Test
	public void testVScoreList() {
		List<VScore> objs = vScoreMapper.list(3);
		for (VScore c : objs) {
			System.out.println(c.getScore());
		}
	}

	@Test
	public void testVScoreList2() {
		List<VScore> objs = vScoreService.list(3);
		for (VScore c : objs) {
			System.out.println(c.getScore());
		}
	}

}
