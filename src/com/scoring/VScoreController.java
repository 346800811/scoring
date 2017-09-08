package com.scoring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.PublicTools;
import com.scoring.model.Marker;
import com.scoring.model.Proj;
import com.scoring.service.MarkerService;
import com.scoring.service.ProjService;
import com.scoring.service.VScoreService;

/**
 * 项目评分
 * 
 * @author JianDe
 */
@Controller
@RequestMapping("/vscore")
public class VScoreController {
	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	VScoreService vScoreService;
	@Autowired
	ProjService projService;
	@Autowired
	MarkerService markerService;

	@RequestMapping("/list")
	public ModelAndView listVScore(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<String> currentUser = PublicTools.getCurrentUser(request, logger);
		int type = Integer.parseInt(currentUser.get(2));
		List<Marker> marks = markerService.query(type);
		List<Proj> projs = projService.query(type);
		double[][] scarr = vScoreService.getArr(type, projs.size(), marks.size());

		// 放入转发参数
		mav.addObject("projs", projs);
		mav.addObject("marks", marks);
		mav.addObject("scarr", scarr);
		// 放入jsp路径
		mav.setViewName("scored/vscoring");
		return mav;
	}

}
