package com.scoring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scoring.mapper.MarkerMapper;
import com.scoring.mapper.ProjMapper;
import com.scoring.model.Marker;
import com.scoring.model.Proj;
import com.scoring.service.VScoreService;

@Controller
@RequestMapping("/vscore")
public class VScoreController {
	@Autowired
	VScoreService vScoreService;
	@Autowired
	ProjMapper projMapper;
	@Autowired
	MarkerMapper markerMapper;

	@RequestMapping("/list")
	public ModelAndView listVScore(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int type = 3;
		List<Marker> marks = markerMapper.query(type);
		List<Proj> projs = projMapper.query(type);
		double[][] scarr = vScoreService.getArr(type);

		// 放入转发参数
		mav.addObject("projs", projs);
		mav.addObject("marks", marks);
		mav.addObject("scarr", scarr);
		// 放入jsp路径
		mav.setViewName("vscoring");
		return mav;
	}

}
