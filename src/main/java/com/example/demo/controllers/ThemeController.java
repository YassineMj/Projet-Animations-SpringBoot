package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AnimationEntity;
import com.example.demo.entities.ThemeEntity;
import com.example.demo.repositories.AnimationRepository;
import com.example.demo.repositories.ThemeRepository;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;
    
    @Autowired
    private AnimationRepository animationRepository;

    @GetMapping("get-all-theme")
    public List<ThemeEntity> getAllThemesWithAnimations() {
        return themeRepository.findAll(); // Ou une méthode personnalisée pour récupérer les thèmes avec les animations
    }
    
    @GetMapping("/get-animations-by-theme")
    public ResponseEntity<List<AnimationEntity>> getAnimationsByThemeId(@RequestParam Long idTheme) {
        List<AnimationEntity> animations = animationRepository.findByThemeId(idTheme);
        return ResponseEntity.ok(animations);
    }
}
