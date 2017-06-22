package com.phamqtri.grouplanguage.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phamqtri.grouplanguage.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {
	ArrayList<LanguageModel> findAll();
}
