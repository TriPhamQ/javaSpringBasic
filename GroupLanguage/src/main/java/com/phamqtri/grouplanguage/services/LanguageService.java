package com.phamqtri.grouplanguage.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.phamqtri.grouplanguage.models.LanguageModel;
import com.phamqtri.grouplanguage.repositories.LanguageRepository;

@Service
public class LanguageService {
	private ArrayList<LanguageModel> languages = new ArrayList<LanguageModel>(Arrays.asList(
				new LanguageModel("Java", "James Gosling", "1.8"),
				new LanguageModel("Python", "Guido van Rossum", "3.6"),
				new LanguageModel("JavaScript", "Brendan Eich", "1.9.5.23.24.7.2")
			));
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public ArrayList<LanguageModel> allLanguages() {
		return this.languageRepository.findAll();
	}
	
	public LanguageModel findLanguageByIndex(long id) {
    	return this.languageRepository.findOne(id);
    }
	
	public void addLanguage(LanguageModel language) {
		this.languageRepository.save(language);
	}
	
	public void updateLanguage(long id, LanguageModel language) {
		this.languageRepository.save(language);
    }
	
	public void destroyLanguage(long id) {
        if (this.languageRepository.findOne(id) != null) {
			this.languageRepository.delete(id);
		}
    }
}
