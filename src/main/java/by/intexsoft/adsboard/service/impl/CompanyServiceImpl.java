package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.CompanyEntity;
import main.java.by.intexsoft.adsboard.repository.CompanyEntityRepository;
import main.java.by.intexsoft.adsboard.service.CompanyService;

@Service
public class CompanyServiceImpl extends AbstractEntityServiceImpl<CompanyEntity> implements CompanyService {
	@Autowired
	CompanyEntityRepository repostitory;
}
