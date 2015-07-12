package mum.edu.mstore;

import java.util.logging.Logger;

import mum.edu.mstore.domain.User;
import mum.edu.mstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String signUp(Model model){
		model.addAttribute("user", new User());
		return "signup";
	}

}
