package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.mapper.MarkerMapper;
import com.scoring.model.Marker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MarkerTest {
	@Autowired
	private MarkerMapper markerMapper;

	@Test
	public void testMarkerList() {
		List<Marker> objs = markerMapper.query(3);
		for (Marker c : objs) {
			System.out.println(c.getName());
		}
	}

}
