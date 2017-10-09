package by.intexsoft.adsboard.service;

import javax.transaction.Transactional;

import by.intexsoft.adsboard.model.Roles;

public interface RolesService  extends AbstractEntityService<Roles>{

	@Transactional
	Roles findByRole(String role);

}
