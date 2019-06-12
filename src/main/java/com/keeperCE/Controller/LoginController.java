package com.keeperCE.Controller;

import com.keeperCE.model.User;
import com.keeperCE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController 	
public class LoginController {

	 @Autowired
	    private UserService userService;

	 @GetMapping("/")
	    public ModelAndView registration(){
	        ModelAndView modelAndView = new ModelAndView();
	        User user = new User();
	        modelAndView.addObject("user", user);
	        modelAndView.setViewName("login");
	        return modelAndView;
	    }

	    @PostMapping("/registration")
	    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	        ModelAndView modelAndView = new ModelAndView();
	        User userExists = userService.findUserByEmail(user.getEmail());
	        if (userExists != null) {
	            bindingResult
	                    .rejectValue("email", "error.user",
	                            "There is already a user registered with the email provided");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("registration");
	        } else {
	            userService.saveUser(user);
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            modelAndView.addObject("user", new User());
	            modelAndView.setViewName("registration");

	        }
	        return modelAndView;
	    }

	    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
	    public ModelAndView home(){
	        ModelAndView modelAndView = new ModelAndView();
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        User user = userService.findUserByEmail(auth.getName());
	        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLast_name() + " (" + user.getEmail() + ")");
	        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
	        modelAndView.setViewName("admin/home");
	        return modelAndView;
	    }
	    @PostMapping("/admin")
		public ModelAndView adminLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;

	}
	@PostMapping("/login/subscriber")
	public ModelAndView subscriberLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;

	}

}
