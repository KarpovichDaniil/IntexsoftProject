package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Goods;
import by.intexsoft.adsboard.repository.GoodsRepository;
import by.intexsoft.adsboard.service.GoodsService;

@Service
public class GoodsServiceImpl extends AbstractEntityServiceImpl<Goods> implements GoodsService {

	private final GoodsRepository goodsRepository;

	@Autowired
	public GoodsServiceImpl(JpaRepository<Goods, Long> jpaRepository, GoodsRepository goodsRepository) {
		super(jpaRepository);
		this.goodsRepository = goodsRepository;
	}
}
