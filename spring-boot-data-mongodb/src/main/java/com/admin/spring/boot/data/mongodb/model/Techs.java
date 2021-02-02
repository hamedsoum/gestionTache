package com.admin.spring.boot.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "techs")

public class Techs{
	@Id
	private String id;
	
	private String technologie;
	
	public Techs() {
		  
	  }
	
	public Techs(String technologie  ) {
	    this.technologie = technologie;
	  }
	
	public String getId() {
	    return id;
	  }
	
	public String getTechnologie() {
	    return technologie;
	}
	public void setTechnologie(String technologie) {
	   this.technologie = technologie;
	}
}


