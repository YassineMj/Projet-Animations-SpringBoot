package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class InscritEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nom_complet")
    private String nomComplet;
    
    private String tel;
    
    private String email;
    
    private String mdp;
    
    private String classe;

    @ManyToMany
    @JoinTable(
        name = "inscrit_animation",
        joinColumns = @JoinColumn(name = "inscrit_id"),
        inverseJoinColumns = @JoinColumn(name = "animation_id")
    )
    private List<AnimationEntity> animations;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<AnimationEntity> getAnimations() {
		return animations;
	}

	public void setAnimations(List<AnimationEntity> animations) {
		this.animations = animations;
	}
    
    
}
