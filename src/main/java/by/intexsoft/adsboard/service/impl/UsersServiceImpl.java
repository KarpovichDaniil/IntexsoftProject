package by.intexsoft.adsboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Roles;
import by.intexsoft.adsboard.model.Users;
import by.intexsoft.adsboard.repository.UsersRepository;
import by.intexsoft.adsboard.service.RolesService;
import by.intexsoft.adsboard.service.UsersService;

@Service
public class UsersServiceImpl extends AbstractEntityServiceImpl<Users> implements UsersService {
	
	private final UsersRepository userRepository;
    private final RolesService roleService;

    @Autowired
    public UsersServiceImpl(
            JpaRepository<Users, Long> jpaRepository,
            UsersRepository userRepository,
			RolesService roleService) {
        super(jpaRepository);
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

	@Override
	public Users findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public Users register(Users user) {
		List<Roles> authorities = new ArrayList<>();
		authorities.add(roleService.findByRole("ROLE_USER"));
		user.roles = authorities;
		return userRepository.save(user);
	}
}
