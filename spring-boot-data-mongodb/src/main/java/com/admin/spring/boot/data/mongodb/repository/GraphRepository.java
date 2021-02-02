package com.admin.spring.boot.data.mongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.spring.boot.data.mongodb.model.Graph;

public interface GraphRepository extends MongoRepository<Graph, String> {
	  List<Graph> findByProjetContaining(String projet);
	 
	}