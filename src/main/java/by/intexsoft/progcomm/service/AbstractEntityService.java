package by.intexsoft.progcomm.service;

import java.util.List;

import by.intexsoft.progcomm.entity.AbstractEntity;

public interface AbstractEntityService<T extends AbstractEntity> {
	List<T> findAll();

	void deleteAll();

	T save(T entity);

	T findById(Long id);

	void deleteById(Long id);
}
