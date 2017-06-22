package com.phamqtri.grouplanguage.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phamqtri.grouplanguage.models.LanguageModel;
import com.phamqtri.grouplanguage.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("language") LanguageModel language) {
		ArrayList<LanguageModel> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index";
	}
	
	@PostMapping("")
    public String createLanguage(@ModelAttribute("language") @Valid LanguageModel language, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
        	redirectAttributes.addFlashAttribute("language", language);
        	ArrayList<LanguageModel> languages = languageService.allLanguages();
    		model.addAttribute("languages", languages);
            return "index";
        }
        else{
        	languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
	
	@RequestMapping("/edit/{id}")
    public String editLanguage(@PathVariable("id") long id, Model model, @ModelAttribute("language") LanguageModel language) {
        LanguageModel languageModel = languageService.findLanguageByIndex(id);
        if (languageModel != null){
            model.addAttribute("language", languageModel);
            return "editLanguage";
        }
        else {
            return "redirect:/languages";
        }
    }
	
	@PostMapping("/edit/{id}")
    public String updateLanguage(@PathVariable("id") long id, @ModelAttribute("language") @Valid LanguageModel language, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "editLanguage";
        }
        else {
            languageService.updateLanguage(id, language);
            return "redirect:/languages";
        }
    }
	
	@RequestMapping(value="/delete/{id}")
    public String destroyBook(@PathVariable("id") long id) {
        languageService.destroyLanguage(id);
        return "redirect:/languages";
    }
	
	@RequestMapping("/{id}")
    public String showLanguage(@PathVariable("id") long id, Model model) {
        LanguageModel languageModel = languageService.findLanguageByIndex(id);
        if (languageModel != null){
            model.addAttribute("language", languageModel);
            return "showLanguage";
        }
        else {
            return "redirect:/languages";
        }
    }
}
