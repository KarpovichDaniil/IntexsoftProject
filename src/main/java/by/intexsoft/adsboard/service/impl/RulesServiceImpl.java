package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Roles;
import by.intexsoft.adsboard.repository.RulesRepository;
import by.intexsoft.adsboard.service.RolesService;

@Service
public class RulesServiceImpl extends AbstractEntityServiceImpl<Roles> implements RolesService {
	@Autowired
	RulesRepository repository;
}
