package com.admin.spring.boot.data.mongodb.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "taches")
public class Taches {
  @Id
  private String id;

  private String reference;
  private String client;
  private String projet;
  private String intervenant;
  private int chargeHj;
  private String activite;
  private String technologie;
  


  
public Taches() {
	  
  }
  
  public Taches(String reference, String client, String projet,String intervenant,
		  int chargeHj,String activite, String technologie  ) {
    this.reference = reference;
    this.client = client;
    this.projet = projet;
    this.intervenant = intervenant;
    this.chargeHj = chargeHj;
    this.activite = activite;
    this.technologie = technologie;
  }

  public String getId() {
    return id;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getClient() {
    return client;
  }
  public void setClient(String client) {
    this.client = client;
  }

  public String getProjet() {
	return projet;
  }
   public void setProjet(String projet) {
    this.projet = projet;
  }
   
   
  public String getIntervenant() {
    return intervenant;
  }
  public void setIntervenant(String interveant) {
	this.intervenant = interveant;
  }
  
  
  public int getChargHj() {
	    return chargeHj;
  }
  public void setChargeHj(int chargeHj) {
	   this.chargeHj = chargeHj;
  }
  
  
 public String getActivite() {
	  return activite;
}
public void setActivite(String activite) {
	  this.activite = activite;
}

public String getTechnologie() {
    return technologie;
}
public void setTechnologie(String technologie) {
   this.technologie = technologie;
}


  
  

  

  
}