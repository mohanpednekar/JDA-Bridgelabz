package com.jda.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView getWelcome() {

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("msg", "Hello Spring MVC + Log4j");
		return model;

	}
}
