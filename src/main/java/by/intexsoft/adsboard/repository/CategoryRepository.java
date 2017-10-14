package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Category;

/**
 * Интерфейс для генерации CRUD операций репозитория типа {@link Category}
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
