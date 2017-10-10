package by.intexsoft.adsboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.adsboard.model.AbstractEntity;
import by.intexsoft.adsboard.service.AbstractEntityService;

public class AbstractEntityServiceImpl<T extends AbstractEntity> implements AbstractEntityService<T> {

	@Autowired
	private JpaRepository<T, Long> repository;
	
	@Autowired
	public AbstractEntityServiceImpl(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public T findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.delete(id);
	}
}
