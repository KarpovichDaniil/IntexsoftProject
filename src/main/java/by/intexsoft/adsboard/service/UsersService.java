package by.intexsoft.adsboard.service;

import javax.transaction.Transactional;

import by.intexsoft.adsboard.model.Users;

public interface UsersService extends AbstractEntityService<Users>{
	Users findByUserName(String name);

    @Transactional
    Users register(Users user);
}
