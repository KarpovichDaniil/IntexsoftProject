package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Users;
import by.intexsoft.adsboard.repository.UsersRepository;
import by.intexsoft.adsboard.service.UsersService;


@Service
public class UsersServiceImpl extends AbstractEntityServiceImpl<Users> implements UsersService {
	@Autowired
	UsersRepository repository;
}
