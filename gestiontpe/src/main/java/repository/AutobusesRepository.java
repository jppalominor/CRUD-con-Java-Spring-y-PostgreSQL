package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Autobuses;

public interface AutobusesRepository extends JpaRepository<Autobuses, Integer> {

}