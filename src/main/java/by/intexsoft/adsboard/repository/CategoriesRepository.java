package main.java.by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.by.intexsoft.adsboard.entity.CategoriesEntity;

public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long>{

}
