package com.axisj.examples.spring.social.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User create(UserCreateRequestVO userCreateRequestVO) throws DuplicateEmailException {
		User user = User.fromVO(userCreateRequestVO);

		if(existUser(user.getEmail())) {
			throw new DuplicateEmailException("already registered email address");
		}

		user.setPassword(passwordEncoder.encode(userCreateRequestVO.getPassword()));

		userRepository.save(user);

		return user;
	}

	public boolean existUser(String email) {
		User user = findByEmail(email);

		return user != null ? true : false;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
