package com.admin.spring.boot.data.mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.spring.boot.data.mongodb.model.Techs;
import com.admin.spring.boot.data.mongodb.repository.TechsRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")


public class TechsController{
	
	@Autowired
	TechsRepository techsRepository;
	
	@PostMapping("/techs")
	public ResponseEntity<Techs> createTechs(@RequestBody Techs techs) {
	    try {
	      Techs _techs = techsRepository.save(new Techs(techs.getTechnologie()));
	      return new ResponseEntity<>(_techs, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@GetMapping("/techs")
	public ResponseEntity<List<Techs>> getAllTutorials(@RequestParam(required = false) String  technologie) {
	  try {
	    List<Techs> techs = new ArrayList<Techs>();

	    if ( technologie == null)
	    	techsRepository.findAll().forEach(techs::add);
	    else
	    	techsRepository.findByTechnologieContaining(technologie).forEach(techs::add);

	    if (techs.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(techs, HttpStatus.OK);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}



@PutMapping("/techs/{id}")
public ResponseEntity<Techs> updateTechs(@PathVariable("id") String id, @RequestBody Techs techs) {
  Optional<Techs> tutorialData = techsRepository.findById(id);

  if (tutorialData.isPresent()) {
    Techs _techs = tutorialData.get();
    _techs.setTechnologie(techs.getTechnologie());
    
    return new ResponseEntity<>(techsRepository.save(_techs), HttpStatus.OK);
  } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}


@DeleteMapping("/techs/{id}")
public ResponseEntity<HttpStatus> deleteTech(@PathVariable("id") String id) {
  try {
    techsRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

@DeleteMapping("/techs")
public ResponseEntity<HttpStatus> deleteAllTechs() {
  try {
    techsRepository.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
}
