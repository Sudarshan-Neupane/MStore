package mum.edu.mstore.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author sudarshan
 *
 */

public class SpringUtils {
	public static String getUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		if (userDetails != null) {
			return userDetails.getUsername();
		}
		return "";
	}

}
