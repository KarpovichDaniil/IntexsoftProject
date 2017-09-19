package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Goods;
import by.intexsoft.adsboard.repository.GoodsEntityRepository;
import by.intexsoft.adsboard.service.GoodsService;


@Service
public class GoodsServiceImpl extends AbstractEntityServiceImpl<Goods> implements GoodsService{
	@Autowired
	GoodsEntityRepository repostitory;
}
