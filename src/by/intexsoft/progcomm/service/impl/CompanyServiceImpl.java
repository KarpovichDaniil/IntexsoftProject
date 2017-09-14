package by.intexsoft.progcomm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.progcomm.entity.CompanyEntity;
import by.intexsoft.progcomm.repository.CompanyEntityRepository;
import by.intexsoft.progcomm.service.CompanyService;

@Service
public class CompanyServiceImpl extends AbstractEntityServiceImpl<CompanyEntity> implements CompanyService {
	@Autowired
	CompanyEntityRepository repostitory;
}
