package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Roles;
import by.intexsoft.adsboard.repository.RolesRepository;
import by.intexsoft.adsboard.service.RolesService;

@Service
public class RolesServiceImpl extends AbstractEntityServiceImpl<Roles> implements RolesService {

	private final RolesRepository roleRepository;

	@Autowired
	public RolesServiceImpl(JpaRepository<Roles, Long> jpaRepository, RolesRepository roleRepository) {
		super(jpaRepository);
		this.roleRepository = roleRepository;
	}

	@Override
	public Roles findByRole(String role) {
		return roleRepository.findByRole(role);
	}
}
