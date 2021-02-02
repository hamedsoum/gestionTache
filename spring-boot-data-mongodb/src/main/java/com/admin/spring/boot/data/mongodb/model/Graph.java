package com.admin.spring.boot.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "graph")
public class Graph {
  @Id
  private String id;
  
  private String projet;
  private int tache1;
  private int tache2;
  private int tache3;
  private int tache4;
  
  
public Graph() {
	  
  }

public Graph(String projet, int tache1,  int tache2,  int tache3, int tache4 ) {
	  this.projet = projet;
	  this.tache1 = tache1;
	  this.tache2 = tache2;
	  this.tache3 = tache3;
	  this.tache4 = tache4;
}

public String getId() {
    return id;
  }

public String getProjet() {
    return projet;
  }

public void setProjet(String projet) {
    this.projet = projet;
  }


public int getTache1() {
    return tache1;
  }

public void setTache1(int tache1) {
	   this.tache1 = tache1;
}


public int getTache2() {
    return tache2;
  }

public void setTache2(int tache2) {
	   this.tache2 = tache2;
}

public int getTache3() {
    return tache3;
  }

public void setTache3(int tache3) {
	   this.tache3 = tache3;
}


public int getTache4() {
    return tache4;
  }

public void setTache4(int tache4) {
	   this.tache4 = tache4;
}

}