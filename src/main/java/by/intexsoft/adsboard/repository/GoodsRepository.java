package by.intexsoft.adsboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.intexsoft.adsboard.model.Category;
import by.intexsoft.adsboard.model.Goods;

/**
 * Интерфейс для генерации CRUD операций репозитория типа {@link Goods}
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>{

	List<Goods> findByCategoryId(long category);

}
