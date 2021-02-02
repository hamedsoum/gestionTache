package com.admin.spring.boot.data.mongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.spring.boot.data.mongodb.model.Techs;

public interface TechsRepository extends MongoRepository<Techs, String> {
	  List<Techs> findByTechnologieContaining(String technologie);
	 
	}	