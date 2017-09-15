package main.java.by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.by.intexsoft.adsboard.entity.PostEntity;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long>{

}
