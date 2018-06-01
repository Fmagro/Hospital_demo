package it.objectway.stage.Hospital_demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.objectway.stage.Hospital_demo.model.Physician;

public interface PhysicianRepository extends CrudRepository<Physician, Long>{

}
