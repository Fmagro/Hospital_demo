package it.objectway.stage.Hospital_demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.objectway.stage.Hospital_demo.model.Physician;
import it.objectway.stage.Hospital_demo.repository.PhysicianRepository;

@Service("physicianService")
public class PhysicianService {

	@Autowired
	PhysicianRepository physicianRepository;

	@Transactional
	public List<Physician> getAllPhysicians() {
		List<Physician> physicians = new ArrayList<>();
		Iterable<Physician> physiciansIterable = physicianRepository.findAll();
		Iterator<Physician> physiciansIterator = physiciansIterable.iterator();
		while (physiciansIterator.hasNext()) {
			physicians.add(physiciansIterator.next());
		}
		return physicians;
	}

	@Transactional
	public Optional<Physician> getPhysician(Long id) {
		return physicianRepository.findById(id);
	}

	@Transactional
	public void addPhysician(Physician physician) {
		physicianRepository.save(physician);
	}

	@Transactional
	public void updatePhysician(Physician physician) {
		physicianRepository.save(physician);
	}

	@Transactional
	public void deletePhysician(Long id) {
		physicianRepository.deleteById(id);
	}


}
