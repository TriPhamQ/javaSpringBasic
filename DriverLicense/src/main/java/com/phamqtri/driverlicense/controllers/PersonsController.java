package com.phamqtri.driverlicense.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phamqtri.driverlicense.models.PersonModel;
import com.phamqtri.driverlicense.services.PersonsService;

@Controller
@RequestMapping("/persons")
public class PersonsController {
	private final PersonsService personsService;
	
	public PersonsController(PersonsService personsService) {
		this.personsService = personsService;
	}
	
	@RequestMapping("")
	public String persons(Model model) {
		ArrayList<PersonModel> persons = this.personsService.allPersons();
		model.addAttribute("persons", persons);
		return "persons";
	}
	
	@RequestMapping("/new")
	public String newPerson(Model model) {
		if (!model.containsAttribute("person")) {
			model.addAttribute("person", new PersonModel());
		}
		return "newPerson";
	}
	
	@PostMapping("/new")
	public String createPerson(@Valid @ModelAttribute("person") PersonModel person, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.person", result);
			redirectAttributes.addFlashAttribute("person", person);
			return "redirect:/persons/new";
		}
		else {
			this.personsService.createPerson(person);
			return "redirect:/persons";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String destroyPerson(@PathVariable("id") long id) {
		this.personsService.destroyPerson(id);
		return "redirect:/persons";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPerson(Model model, @PathVariable("id") long id) {
		PersonModel person = this.personsService.findPersonById(id);
		if (person != null) {
			if (!model.containsAttribute("person")) {
				model.addAttribute("person", person);
			}
			return "editPerson";
		}
		else {
			return "redirect:/persons";
		}
	}	
	
	@PutMapping("/edit/{id}")
	public String editPersonSubmit(@PathVariable("id") long id, @ModelAttribute("person") @Valid PersonModel person, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.person", result);
			redirectAttributes.addFlashAttribute("person", person);
			return "redirect:/persons/edit/{id}";
		}
		else {
			this.personsService.updatePerson(id, person);
			return "redirect:/persons";
		}
	}
}
