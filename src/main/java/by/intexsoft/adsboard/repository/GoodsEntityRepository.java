package main.java.by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.by.intexsoft.adsboard.model.Goods;

public interface GoodsEntityRepository extends JpaRepository<Goods, Long>{

}
