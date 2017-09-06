package com.scoring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scoring.model.Marker;
import com.scoring.service.MarkerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MarkerTest {
	@Autowired
	private MarkerService markerService;

	@Test
	public void testMarkerList() {
		List<Marker> objs = markerService.query(3);
		for (Marker c : objs) {
			System.out.println(c);
		}
	}

}
