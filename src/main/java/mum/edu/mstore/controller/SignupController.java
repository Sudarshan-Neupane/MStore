package mum.edu.mstore.controller;

import javax.validation.Valid;

import mum.edu.mstore.domain.User;
import mum.edu.mstore.domain.User.Role;
import mum.edu.mstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignupController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpAdd(@Valid @ModelAttribute User user,
			BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("inside has error");
			return "signup";
		}
		if (!user.getPassword().equals(user.getRePassword())) {
			model.addAttribute("errors",
					"Password and Re-Password does not match.");
			System.out.println("password not matched");
			return "signup";
		}
		user.setRole(Role.ROLE_USER);
		userService.add(user);
		return "redirect:profile";
	}

}
