package mum.edu.mstore.test;

import mum.edu.mstore.domain.User;
import mum.edu.mstore.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserTest extends BaseTest {
	 @Autowired
	 private UserService userService;
	private static final String FIRST_NAME = "Sudarshan";
	private static final String MIDDLE_NAME = "";
	private static final String LAST_NAME = "Neupane";
	private static final String USER_NAME = "admin@mstore.com";
	private static final String PASSWORD = "nepal@123";
	private static final String RE_PASSWORD = "nepal@123";
	private static final String MOBILE = "3196140233L";
	private static final String CITY = "FAIRFIELD";
	private static final String STATE = "IOWA";
	private static final String ZIP_CODE = "52557";
	private static final boolean ENABLED= true;
	// private static final String COUNTRY = "United State of America";

	private static final String CHANGED_LAST_NAME = "Neupane JI";

//	 @Before
	@Test
	public void addUserTest() {
		// TODO implement user add test
		User user = new User(FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD, PASSWORD);
		userService.add(user);
		User u = this.userService.findByUserName(USER_NAME);
		 Assert.assertEquals(USER_NAME, u.getUserName());
	}

	// @Test
	public void updateUserTest() {
		// TODO implement user update test
		// Assert.assertEquals(CHANGED_LAST_NAME, u.getLastName());
	}
}
