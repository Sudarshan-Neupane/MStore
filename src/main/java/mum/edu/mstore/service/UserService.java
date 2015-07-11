package mum.edu.mstore.service;

import mum.edu.mstore.domain.User;

public interface UserService extends AbstractService<User, Long> {

	public User findByUserName(String userName);
}
