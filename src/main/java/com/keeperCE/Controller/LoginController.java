package com.keeperCE.Controller;

import com.keeperCE.model.CustomUser;
import com.keeperCE.model.Users;
import com.keeperCE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController 	
public class LoginController {

	 @Autowired
	    private UserService userService;


	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser customUser=(CustomUser) auth.getPrincipal();

		Users user1 = userService.findUserByEmail(customUser.getUser().getEmail()).get();
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}
