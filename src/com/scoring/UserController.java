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
import com.scoring.model.ProjType;
import com.scoring.model.User;
import com.scoring.service.ProjTypeService;
import com.scoring.service.UserService;

/**
 * 用户控制层
 * 
 * @author JianDe
 */
@Controller
@RequestMapping("/user")
public class UserController {
	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	UserService userService;
	@Autowired
	ProjTypeService projTypeService;

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
		ModelAndView mav = new ModelAndView();
		List<ProjType> list = projTypeService.list();
		mav.addObject("projType", list);
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("/login/in")
	public ModelAndView logIn(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String projtype = request.getParameter("projtype");
		User user = new User();
		user.setName(username);
		user.setPasswd(passwd);
		user.setType(Integer.parseInt(projtype));
		if (userService.check(user)) { // 用户、密码、类型验证通过
			logger.info("login true");
			PublicTools.setCurrentUser(request, user, logger);
			mav.addObject("result", true);
			mav.setViewName("loginSuccess");
		} else {
			logger.info("login false");
			mav.addObject("result", false);
			mav.setViewName("loginSuccess");
		}
		return mav;
	}

}
