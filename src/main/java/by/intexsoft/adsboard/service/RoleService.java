package by.intexsoft.adsboard.service;

import javax.transaction.Transactional;

import by.intexsoft.adsboard.model.Role;

public interface RoleService  extends AbstractEntityService<Role>{

	@Transactional
	Role findByRole(String role);

}
