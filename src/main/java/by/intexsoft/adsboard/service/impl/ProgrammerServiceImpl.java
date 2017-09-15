package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.ProgrammerEntity;
import main.java.by.intexsoft.adsboard.repository.ProgrammerEntityRepository;
import main.java.by.intexsoft.adsboard.service.ProgrammerService;

@Service
public class ProgrammerServiceImpl extends AbstractEntityServiceImpl<ProgrammerEntity> implements ProgrammerService{
	@Autowired
	ProgrammerEntityRepository repostitory;
}
