package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.ProjTypeMapper;
import com.scoring.model.ProjType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProjTypeTest {
	@Autowired
	private ProjTypeMapper projTypeMapper;

	@Test
	public void testProjTypeList() {
		List<ProjType> objs = projTypeMapper.list();
		for (ProjType c : objs) {
			System.out.println(c.getName());
		}
	}

}
