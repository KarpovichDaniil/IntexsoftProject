package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.RolesEntity;
import main.java.by.intexsoft.adsboard.repository.RulesEntityRepository;
import main.java.by.intexsoft.adsboard.service.RolesService;

@Service
public class RulesServiceImpl extends AbstractEntityServiceImpl<RolesEntity> implements RolesService {
	@Autowired
	RulesEntityRepository repostitory;
}
