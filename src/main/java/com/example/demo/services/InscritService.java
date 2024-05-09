package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AnimationEntity;
import com.example.demo.entities.InscritEntity;
import com.example.demo.entities.ThemeEntity;
import com.example.demo.repositories.AnimationRepository;
import com.example.demo.repositories.InscritRepository;
import com.example.demo.repositories.ThemeRepository;

@Service
public class InscritService {

	@Autowired
    private InscritRepository inscritRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private AnimationRepository animationRepository;

    public InscritEntity addCompte(InscritEntity inscrit) {
        return inscritRepository.save(inscrit);
    }

    public InscritEntity getCompte(String email, String mdp) {
        return inscritRepository.findByEmailAndMdp(email, mdp);
    }

    public String addAnimationToStudent(Long idInscrit, Long idAnimation) {
        InscritEntity inscrit = inscritRepository.findById(idInscrit).orElse(null);
        AnimationEntity animation = animationRepository.findById(idAnimation).orElse(null);
        if (inscrit != null && animation != null) {
            inscrit.getAnimations().add(animation);
            inscritRepository.save(inscrit);
            return "ok"; // Opération réussie
        } else {
            return "error"; // Échec de l'opération (inscrit ou animation non trouvée)
        }
    }

    public String deleteAnimationFromStudent(Long idInscrit, Long idAnimation) {
        InscritEntity inscrit = inscritRepository.findById(idInscrit).orElse(null);
        AnimationEntity animation = animationRepository.findById(idAnimation).orElse(null);
        
        if (inscrit != null && animation != null && inscrit.getAnimations().contains(animation)) {
            inscrit.getAnimations().remove(animation);
            inscritRepository.save(inscrit);
            return "ok"; // Animation supprimée avec succès
        } else {
            return "error"; // Échec de la suppression (inscrit ou animation non trouvée, ou animation non associée à l'inscrit)
        }
    }


    public List<AnimationEntity> getAnimationsByCompteId(Long idInscrit) {
        InscritEntity inscrit = inscritRepository.findById(idInscrit).orElse(null);
        if (inscrit != null) {
            return inscrit.getAnimations();
        }
        return null;
    }
}
