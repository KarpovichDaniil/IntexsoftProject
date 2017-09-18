package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.model.Cities;
import main.java.by.intexsoft.adsboard.repository.CitiesEntityRepository;
import main.java.by.intexsoft.adsboard.service.CitiesService;

@Service
public class CitiesServiceImpl extends AbstractEntityServiceImpl<Cities> implements CitiesService{
	@Autowired
	CitiesEntityRepository repostitory;
}
