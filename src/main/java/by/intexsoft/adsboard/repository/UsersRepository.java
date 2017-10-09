package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Users;

/**
 * Интерфейс для генерации CRUD операций репозитория типа {@link Users}
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
