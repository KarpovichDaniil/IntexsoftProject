package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Roles;

/**
 * »нтерфейс дл€ генерации CRUD операций репозитори€ типа {@link Roles}
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	/**
	 * Ќаходит {@link Roles} экземлп€р объекта базы данных
	 * 
	 * @param role
	 *            свойство экземлп€ра объекта {@link Roles}
	 * @return найденный экземлп€р объекта {@link Roles}
	 */
	Roles findByRole(String role);
}
