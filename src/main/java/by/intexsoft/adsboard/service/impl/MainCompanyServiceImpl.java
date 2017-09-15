package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.MainCountryEntity;
import main.java.by.intexsoft.adsboard.repository.MainCountryEntityRepository;
import main.java.by.intexsoft.adsboard.service.MainCountryService;

@Service
public class MainCompanyServiceImpl extends AbstractEntityServiceImpl<MainCountryEntity> implements MainCountryService {
	@Autowired
	MainCountryEntityRepository repostitory;
}
