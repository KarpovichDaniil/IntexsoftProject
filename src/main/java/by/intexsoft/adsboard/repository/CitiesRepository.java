package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.intexsoft.adsboard.model.Cities;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Long>{

}
