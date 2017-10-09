package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Categories;

/**
 * Интерфейс для генерации CRUD операций репозитория типа {@link Categories}
 */
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
