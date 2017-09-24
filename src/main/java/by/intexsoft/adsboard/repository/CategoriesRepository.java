package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
