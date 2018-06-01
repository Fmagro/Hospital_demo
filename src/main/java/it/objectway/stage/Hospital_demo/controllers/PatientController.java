package it.objectway.stage.Hospital_demo.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.objectway.stage.Hospital_demo.model.Patient;
import it.objectway.stage.Hospital_demo.model.Physician;
import it.objectway.stage.Hospital_demo.services.PatientService;
import it.objectway.stage.Hospital_demo.services.PhysicianService;

@Controller
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	PhysicianService physicianService;
	
	private static Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@RequestMapping(value = "/Patient/getAll", method = RequestMethod.GET)
	public ModelAndView getPatients() {
		List<Patient> list = patientService.getAllPatients();
		return new ModelAndView("Patient/allPatients", "list", list);
	}
	
	@RequestMapping(value = "/Patient/get/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable Long id) {
		Optional<Patient> patient = patientService.getPatient(id);
		return new ModelAndView("Patient/patInfo","patient", patient.get());
	}
	
	@RequestMapping(value = "/Patient/addForm", method = RequestMethod.GET)
	public ModelAndView addPatient() {
		List<Physician> physList = physicianService.getAllPhysicians();
		ModelAndView model = new ModelAndView();
		model.addObject("physList", physList);
		model.addObject("patient", new Patient());
		logger.debug("Physicians in Patients controller addForm {}", physList);
		model.setViewName("Patient/insertForm");
		return model;
	}
	
	@RequestMapping(value = "/Patient/add", method = RequestMethod.POST)
	public ModelAndView patientInsert(@ModelAttribute Patient patient) {
		patientService.addPatient(patient);
		return new ModelAndView("Patient/patientInfo", "patient", patient);
	}
	
}
