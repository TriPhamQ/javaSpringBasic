package com.phamqtri.grouplanguage.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phamqtri.grouplanguage.models.LanguageModel;
import com.phamqtri.grouplanguage.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	private LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("language") LanguageModel languageModel) {
		ArrayList<LanguageModel> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index";
	}
}
