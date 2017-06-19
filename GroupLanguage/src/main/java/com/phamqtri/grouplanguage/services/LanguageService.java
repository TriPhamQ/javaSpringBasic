package com.phamqtri.grouplanguage.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.phamqtri.grouplanguage.models.LanguageModel;

@Service
public class LanguageService {
	private ArrayList<LanguageModel> languages = new ArrayList<LanguageModel>(Arrays.asList(
				new LanguageModel("Java", "James Gosling", "1.8"),
				new LanguageModel("Python", "Guido van Rossum", "3.6"),
				new LanguageModel("JavaScript", "Brendan Eich", "1.9.5.23.24.7.2")
			));
	
	public ArrayList<LanguageModel> allLanguages() {
		return languages;
	}
}
