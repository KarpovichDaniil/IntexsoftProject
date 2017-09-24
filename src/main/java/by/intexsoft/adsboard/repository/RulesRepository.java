package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.intexsoft.adsboard.model.Roles;

@Repository
public interface RulesRepository extends JpaRepository<Roles, Long>{

}
