package by.intexsoft.adsboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Roles;
import by.intexsoft.adsboard.model.Users;
import by.intexsoft.adsboard.repository.UsersRepository;
import by.intexsoft.adsboard.service.RolesService;
import by.intexsoft.adsboard.service.UsersService;

@Service
public class UsersServiceImpl extends AbstractEntityServiceImpl<Users> implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RolesService rolesService;

	@Override
	public Users findByUserName(String userName) {
		return usersRepository.findByUsername(userName);
	}

	@Override
	public Users register(Users user) {
		List<Roles> authorities = new ArrayList<>();
		authorities.add(rolesService.findByRole("ROLE_USER"));
		user.roles = authorities;
		return usersRepository.save(user);
	}
}
