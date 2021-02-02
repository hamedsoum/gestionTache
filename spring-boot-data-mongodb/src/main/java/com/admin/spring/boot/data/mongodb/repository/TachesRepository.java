package com.admin.spring.boot.data.mongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.spring.boot.data.mongodb.model.Taches;

public interface TachesRepository extends MongoRepository<Taches, String> {
	  List<Taches> findByClientContaining(String client);
	 
	}	