package com.admin.spring.boot.data.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.spring.boot.data.mongodb.model.Taches;
import com.admin.spring.boot.data.mongodb.repository.TachesRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class TacheController {

  @Autowired
   TachesRepository tachesRepository;
  
  @PostMapping("/taches")
  public ResponseEntity<Taches> createTaches(@RequestBody Taches taches) {
    try {
      Taches _taches = tachesRepository.save(new Taches(taches.getReference(),taches.getClient(), taches.getProjet(), taches.getIntervenant(),taches.getChargHj(), taches.getActivite(), taches.getTechnologie()));
      return new ResponseEntity<>(_taches, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/taches")
  public ResponseEntity<List<Taches>> getAllTutorials(@RequestParam(required = false) String client) {
    try {
      List<Taches> taches = new ArrayList<Taches>();

      if (client == null)
    	  tachesRepository.findAll().forEach(taches::add);
      else
    	  tachesRepository.findByClientContaining(client).forEach(taches::add);

      if (taches.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(taches, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  
}