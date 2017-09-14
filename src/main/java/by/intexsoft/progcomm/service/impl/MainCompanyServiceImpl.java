package by.intexsoft.progcomm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.progcomm.entity.MainCountryEntity;
import by.intexsoft.progcomm.repository.MainCountryEntityRepository;
import by.intexsoft.progcomm.service.MainCountryService;

@Service
public class MainCompanyServiceImpl extends AbstractEntityServiceImpl<MainCountryEntity> implements MainCountryService {
	@Autowired
	MainCountryEntityRepository repostitory;
}
