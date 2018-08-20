package com.jda.user.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	private static final Logger logger = Logger.getLogger(WelcomeController.class);

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView getWelcome() {

		//logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("getWelcome is executed!");
		}

		//logs exception
		Exception e = new Exception("Testing");
		logger.error("This is Error message", e.getCause());

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("msg", "Hello Spring MVC + Log4j");
		return model;

	}
}
