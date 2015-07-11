package mum.edu.mstore.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.mstore.domain.User;
import mum.edu.mstore.repository.UserRepository;
import mum.edu.mstore.service.UserService;

@Service
@Transactional
class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	@Override
	public void add(User t) {
		User u = this.userRepository.findByUserName(t.getUserName());
		if (u != null) {
			throw new IllegalArgumentException("User already exist.");
		}
		this.userRepository.save(t);
	}

	@Transactional
	@Override
	public void update(User t) {
		User user = this.userRepository.findByUserName(t.getUserName());
		if (user == null) {
			throw new IllegalArgumentException("User does not exist.");
		}
		this.userRepository.save(t);
	}

	@Override
	public User findOne(Long obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Invalid id.");
		}
		return this.userRepository.findOne(obj);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		if(userName.isEmpty()){
			throw new IllegalArgumentException("Invalid User Name");
		}
		return this.userRepository.findByUserName(userName);
	}

}
