package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Cities;
import by.intexsoft.adsboard.repository.CitiesRepository;
import by.intexsoft.adsboard.service.CitiesService;

@Service
public class CitiesServiceImpl extends AbstractEntityServiceImpl<Cities> implements CitiesService{
	@Autowired
	CitiesRepository repository;
}
