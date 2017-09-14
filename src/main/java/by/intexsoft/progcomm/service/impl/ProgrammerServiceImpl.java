package by.intexsoft.progcomm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.progcomm.entity.ProgrammerEntity;
import by.intexsoft.progcomm.repository.ProgrammerEntityRepository;
import by.intexsoft.progcomm.service.ProgrammerService;

@Service
public class ProgrammerServiceImpl extends AbstractEntityServiceImpl<ProgrammerEntity> implements ProgrammerService{
	@Autowired
	ProgrammerEntityRepository repostitory;
}
