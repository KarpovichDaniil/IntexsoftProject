package main.java.by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.by.intexsoft.adsboard.model.Users;

public interface UsersEntityRepository extends JpaRepository<Users, Long>{

}
