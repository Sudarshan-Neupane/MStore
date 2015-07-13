package mum.edu.mstore.controller;

import mum.edu.mstore.domain.User;
import mum.edu.mstore.domain.User.Role;
import mum.edu.mstore.service.UserService;
import mum.edu.mstore.utils.SpringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/secure")
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		// retrieve database data
		User user = this.userService.findByUserName(SpringUtils.getUserName());
		if (user.getRole().equals(Role.ROLE_ADMIN)) {
			return "redirect:/secure/admin/home";
		} else if (user.getRole().equals(Role.ROLE_USER)) {
			return "home";
		}
		return "";
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome() {
		return "admin/home";
	}

}
