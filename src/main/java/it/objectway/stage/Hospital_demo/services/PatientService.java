package it.objectway.stage.Hospital_demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectway.stage.Hospital_demo.model.Patient;
import it.objectway.stage.Hospital_demo.repository.PatientRepository;
import oracle.net.aso.p;

@Service("patientService")
public class PatientService {
	@Autowired
	PatientRepository patientRepository;

	@Transactional
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		Iterable<Patient> iterable = patientRepository.findAll();
		Iterator<Patient> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			patients.add(iterator.next());
		}

		return patients;
	}

	@Transactional
	public Optional<Patient> getPatient(Long id) {
		return patientRepository.findById(id);
	}

	@Transactional
	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}

	@Transactional
	public void updatePatient(Patient patient) {
		patientRepository.save(patient);
	}

	@Transactional
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}
