package by.intexsoft.progcomm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.progcomm.entity.PostEntity;
import by.intexsoft.progcomm.repository.PostEntityRepository;
import by.intexsoft.progcomm.service.PostService;

@Service
public class PostServiceImpl extends AbstractEntityServiceImpl<PostEntity> implements PostService {
	@Autowired
	PostEntityRepository repostitory;
}
