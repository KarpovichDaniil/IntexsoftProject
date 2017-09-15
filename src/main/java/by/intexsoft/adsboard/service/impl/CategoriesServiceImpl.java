package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.CategoriesEntity;
import main.java.by.intexsoft.adsboard.repository.CategoriesRepository;
import main.java.by.intexsoft.adsboard.service.CategoriesService;

@Service
public class CategoriesServiceImpl extends AbstractEntityServiceImpl<CategoriesEntity> implements CategoriesService {
	@Autowired
	CategoriesRepository repostitory;
}
