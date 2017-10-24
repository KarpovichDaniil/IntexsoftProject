package by.intexsoft.adsboard.service;

import java.util.List;

import by.intexsoft.adsboard.model.Goods;

public interface GoodsService extends AbstractEntityService<Goods>{
	List<Goods> findByCategoryId(long categoryId);
}
