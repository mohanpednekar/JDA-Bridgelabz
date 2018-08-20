package com.jda.user.controller;

import com.jda.user.model.User;
import com.jda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	User user = new User();

	@Autowired
	private Validator validator;

	@Autowired
	UserService userService;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@GetMapping("index")
	public ModelAndView register(User user) {
		return new ModelAndView("register");
	}

	@PostMapping("/registerProcess")
	public ModelAndView create(@ModelAttribute("user") User user, BindingResult bindingResult) throws SecurityException {
		System.out.println("UserController: create");
		userService.register(user);
		ModelAndView model = new ModelAndView("redirect:/login");

		validator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView("register");
		}
		this.user.setEmail(user.getEmail());
		this.user.setPassword(user.getPassword());
		this.user.setPhone(user.getPhone());
		return model;
	}

	@GetMapping("/register")
	public ModelAndView viewData(User user) {
		System.out.println("UserController : viewData");
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		return model;
	}
}
