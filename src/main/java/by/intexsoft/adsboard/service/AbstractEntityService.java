package main.java.by.intexsoft.adsboard.service;

import java.util.List;

import main.java.by.intexsoft.adsboard.entity.AbstractEntity;

public interface AbstractEntityService<T extends AbstractEntity> {
	List<T> findAll();

	void deleteAll();

	T save(T entity);

	T findById(Long id);

	void deleteById(Long id);
}
