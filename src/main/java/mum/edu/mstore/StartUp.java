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
        
	private static final String FIRST_NAME1 = "sudarshan";
	private static final String LAST_NAME1 = "neupane";
	private static final String USER_NAME1 = "mesudarshan7@gmail.com";
	private static final String PASSWORD1 = "sn";

	@PostConstruct
	public void init() {
		System.out.println("Start up");
		User user = new User(FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD,
				PASSWORD);
		user.setRole(Role.ROLE_ADMIN);
		userService.add(user);
		User user1 = new User(FIRST_NAME1, LAST_NAME1, USER_NAME1, PASSWORD1,
				PASSWORD1);
		user1.setRole(Role.ROLE_USER);
		userService.add(user1);
	}
}
