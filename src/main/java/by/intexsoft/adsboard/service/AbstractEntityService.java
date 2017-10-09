package by.intexsoft.adsboard.service;

import java.util.List;


import by.intexsoft.adsboard.model.AbstractEntity;


public interface AbstractEntityService<T extends AbstractEntity> {
	List<T> findAll();

	void deleteAll();

	T save(T entity);

	void deleteById(Long id);

	T findOne(Long id);
}
