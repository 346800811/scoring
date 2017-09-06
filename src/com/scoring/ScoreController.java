package com.scoring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scoring.model.User;
import com.scoring.service.UserService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	UserService userService;

	@RequestMapping("/list")
	public ModelAndView listUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<User> cs = userService.list();
		mav.addObject("cs", cs);
		mav.setViewName("listCategory");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		request.getSession();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

}
