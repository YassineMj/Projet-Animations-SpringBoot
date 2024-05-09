package com.example.demo.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class AnimationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titre;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    private Date dateDebut;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private Date dateFin;
    
    @Column(name = "nombre_max")
    private int nombreMax;
    
    @Column(name = "nombre_min")
    private int nombreMin;
    
    private String description;
    
    private String pathImage;
    
    private boolean annulation;
    
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private ThemeEntity theme;
    
    @ManyToOne
    @JoinColumn(name = "lien_id")
    private LienEntity lien;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNombreMax() {
		return nombreMax;
	}

	public void setNombreMax(int nombreMax) {
		this.nombreMax = nombreMax;
	}

	public int getNombreMin() {
		return nombreMin;
	}

	public void setNombreMin(int nombreMin) {
		this.nombreMin = nombreMin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAnnulation() {
		return annulation;
	}

	public void setAnnulation(boolean annulation) {
		this.annulation = annulation;
	}

	public ThemeEntity getTheme() {
		return theme;
	}

	public void setTheme(ThemeEntity theme) {
		this.theme = theme;
	}

	public LienEntity getLien() {
		return lien;
	}

	public void setLien(LienEntity lien) {
		this.lien = lien;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}   
    
}
