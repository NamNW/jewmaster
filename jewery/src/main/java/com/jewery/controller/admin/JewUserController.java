package com.jewery.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jewery.bean.JewUserBean;
import com.jewery.service.JewUserService;

@Controller
@RequestMapping("/user")
public class JewUserController {
	
	@Autowired
	private JewUserService jewUserService;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		JewUserBean userBean = new JewUserBean();
		modelAndView.addObject("userBean", userBean);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration/submit", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid JewUserBean userBean){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userBean", userBean);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
}
