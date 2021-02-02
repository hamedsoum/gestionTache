package com.admin.spring.boot.data.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.spring.boot.data.mongodb.model.Graph;
import com.admin.spring.boot.data.mongodb.repository.GraphRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class GraphController {

  @Autowired
  GraphRepository graphRepository;
  
  @PostMapping("/Graph")
  public ResponseEntity<Graph> createGraph(@RequestBody Graph graph) {
    try {
      Graph _Graph = graphRepository.save(new Graph(graph.getProjet(),graph.getTache1(), graph.getTache2(), graph.getTache3(), graph.getTache4()));
      return new ResponseEntity<>(_Graph, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/Graph")
  public ResponseEntity<List<Graph>> getAllTutorials(@RequestParam(required = false) String projet) {
    try {
      List<Graph> Graph = new ArrayList<Graph>();

      if (projet == null)
    	  graphRepository.findAll().forEach(Graph::add);
      else
    	  graphRepository.findByProjetContaining(projet).forEach(Graph::add);

      if (Graph.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(Graph, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  
}