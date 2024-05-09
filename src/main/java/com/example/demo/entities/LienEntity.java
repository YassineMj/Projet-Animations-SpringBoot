package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LienEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String batiment;
    private String numSalle;
    
	public String getBatiment() {
		return batiment;
	}
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}
	public String getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}

}
