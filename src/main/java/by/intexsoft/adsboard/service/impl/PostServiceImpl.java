package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.PostEntity;
import main.java.by.intexsoft.adsboard.repository.PostEntityRepository;
import main.java.by.intexsoft.adsboard.service.PostService;

@Service
public class PostServiceImpl extends AbstractEntityServiceImpl<PostEntity> implements PostService {
	@Autowired
	PostEntityRepository repostitory;
}
