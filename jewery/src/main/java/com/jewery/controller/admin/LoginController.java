package com.jewery.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value = {"/login"})
	public String goToLoginPage(Model model, HttpServletRequest req){
	    return "login";
	}
}
