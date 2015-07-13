package mum.edu.mstore;

import javax.annotation.PostConstruct;

import mum.edu.mstore.domain.User;
import mum.edu.mstore.domain.User.Role;
import mum.edu.mstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUp {
	@Autowired
	private UserService userService;
	private static final String FIRST_NAME = "Admin";
	private static final String LAST_NAME = "Admin";
	private static final String USER_NAME = "admin@mstore.com";
	private static final String PASSWORD = "123456";

	@PostConstruct
	public void init() {
		System.out.println("Start up");
		User user = new User(FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD,
				PASSWORD);
		user.setRole(Role.ROLE_ADMIN);
		userService.add(user);
	}
}
