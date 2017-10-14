package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Role;

/**
 * »нтерфейс дл€ генерации CRUD операций репозитори€ типа {@link Role}
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	/**
	 * Ќаходит {@link Role} экземлп€р объекта базы данных
	 * 
	 * @param role
	 *            свойство экземлп€ра объекта {@link Role}
	 * @return найденный экземлп€р объекта {@link Role}
	 */
	Role findByRole(String role);
}
