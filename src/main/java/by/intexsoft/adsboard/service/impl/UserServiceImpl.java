package by.intexsoft.adsboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Role;
import by.intexsoft.adsboard.model.User;
import by.intexsoft.adsboard.repository.UserRepository;
import by.intexsoft.adsboard.service.RoleService;
import by.intexsoft.adsboard.service.UserService;

@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

	private final UserRepository userRepository;
	private final RoleService roleService;

	@Autowired
	public UserServiceImpl(JpaRepository<User, Long> jpaRepository, UserRepository userRepository,
			RoleService roleService) {
		super(jpaRepository);
		this.userRepository = userRepository;
		this.roleService = roleService;
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public User register(User user) {
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.findByRole("ROLE_USER"));
		user.roles = roles;
		return userRepository.save(user);
	}

	@Override
	public User findByEnabled(boolean enabled) {
		 return userRepository.findByEnabled(enabled);
	}

	@Override
	public User obtainUser(String username) {
		  return findByUserName(username);
	}
}
