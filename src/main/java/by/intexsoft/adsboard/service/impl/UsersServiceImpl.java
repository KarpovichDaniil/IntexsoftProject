package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.model.Users;
import main.java.by.intexsoft.adsboard.repository.UsersEntityRepository;
import main.java.by.intexsoft.adsboard.service.UsersService;

@Service
public class UsersServiceImpl extends AbstractEntityServiceImpl<Users> implements UsersService {
	@Autowired
	UsersEntityRepository repostitory;
}
