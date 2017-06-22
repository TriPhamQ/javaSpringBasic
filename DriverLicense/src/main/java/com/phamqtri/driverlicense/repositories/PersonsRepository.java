package com.phamqtri.driverlicense.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phamqtri.driverlicense.models.PersonModel;

@Repository
public interface PersonsRepository extends CrudRepository<PersonModel, Long> {
	ArrayList<PersonModel> findAll();
}
