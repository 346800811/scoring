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

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		request.getSession();
		ModelAndView mav = new ModelAndView();
		// 放入jsp路径
		mav.setViewName("login");
		return mav;
	}

}
