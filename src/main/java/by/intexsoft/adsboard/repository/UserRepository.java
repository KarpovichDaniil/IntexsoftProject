package by.intexsoft.adsboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.User;

/**
 * Интерфейс для генерации CRUD операций репозитория типа {@link User}
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	List<User> findByEnabled(boolean enabled);
}
