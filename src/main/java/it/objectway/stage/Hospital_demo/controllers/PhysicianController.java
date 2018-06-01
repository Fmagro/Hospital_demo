package it.objectway.stage.Hospital_demo.controllers;



import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.objectway.stage.Hospital_demo.model.Physician;
import it.objectway.stage.Hospital_demo.services.PhysicianService;

@Controller
public class PhysicianController {
	
	@Autowired
	PhysicianService physicianService;
	private static Logger logger = LoggerFactory.getLogger(PhysicianController.class);
	
	@RequestMapping(value = "/Physician/getAll", method = RequestMethod.GET)
	public ModelAndView getPhysicians() {
		List<Physician> list = physicianService.getAllPhysicians();
		logger.debug("Physician List {}", list);
		return new ModelAndView("Physician/allPhysicians", "list", list);
	}
	
	@RequestMapping(value = "/Physician/get/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable Long id) throws Throwable {
		Optional<Physician> phys = physicianService.getPhysician(id);
		return new ModelAndView("Physician/physInfo", "physician", phys.orElseThrow((Supplier<Throwable>) () -> new Exception("not found")));

	}
	
	@RequestMapping(value = "/Physician/addForm" , method = RequestMethod.GET)
	public ModelAndView addPhysician() {
		return new ModelAndView("Physician/insertForm", "physician", new Physician());
	}
	
	@RequestMapping(value = "/Physician/add", method = RequestMethod.POST)
	public ModelAndView physicianInsert(@ModelAttribute Physician physician) {
		physicianService.addPhysician(physician);
		return new ModelAndView("Physician/physInfo", "physician", physician);
	}
	
}
