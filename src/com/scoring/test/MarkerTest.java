package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.MarkerMapper;
import com.scoring.model.Marker;
import com.scoring.service.MarkerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MarkerTest {
	@Autowired
	private MarkerService markerService;
	@Autowired
	private MarkerMapper markerMapper;

	@Test
	public void testServiceList() {
		List<Marker> objs = markerService.list();
		for (Marker c : objs) {
			System.out.println("list: " + c);
		}
	}

	@Test
	public void testServiceQuery() {
		List<Marker> objs = markerService.query(3);
		for (Marker c : objs) {
			System.out.println("query(3): " + c);
		}
	}

	@Test
	public void testMapperGet() {
		Marker obj = markerMapper.selectByPrimaryKey(3);
		System.out.println("get(3): " + obj);
	}

}
