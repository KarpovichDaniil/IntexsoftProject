package by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import by.intexsoft.adsboard.model.Role;
import by.intexsoft.adsboard.repository.RoleRepository;
import by.intexsoft.adsboard.service.RoleService;

@Service
public class RoleServiceImpl extends AbstractEntityServiceImpl<Role> implements RoleService {

	private final RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(JpaRepository<Role, Long> jpaRepository, RoleRepository roleRepository) {
		super(jpaRepository);
		this.roleRepository = roleRepository;
	}

	@Override
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}
}
