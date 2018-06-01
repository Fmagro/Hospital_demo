package it.objectway.stage.Hospital_demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.objectway.stage.Hospital_demo.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{

}
