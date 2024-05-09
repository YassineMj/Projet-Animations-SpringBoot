package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.AnimationEntity;
import com.example.demo.entities.InscritEntity;
import com.example.demo.services.InscritService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class InscritController {

    @Autowired
    private InscritService compteService;

    @PostMapping("/add-compte")
    public ResponseEntity<InscritEntity> addCompte(@RequestBody InscritEntity compte) {
        InscritEntity newCompte = compteService.addCompte(compte);
        return ResponseEntity.ok(newCompte);
    }

    @GetMapping("/get-compte")
    public ResponseEntity<InscritEntity> getCompte(@RequestParam String email, @RequestParam String mdp) {
    	InscritEntity compte = compteService.getCompte(email, mdp);
        if (compte != null) {
            return ResponseEntity.ok(compte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-animation")
    public ResponseEntity<Map<String, String>> addAnimationToStudent(@RequestParam Long idCompte, @RequestParam Long idAnimation) {
        String result = compteService.addAnimationToStudent(idCompte, idAnimation);
        Map<String, String> response = new HashMap<>();
        if (result.equals("ok")) {
            response.put("message", "ok");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "error");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete-animation")
    public ResponseEntity<Map<String, String>> deleteAnimationFromStudent(@RequestParam Long idCompte, @RequestParam Long idAnimation) {
        String result = compteService.deleteAnimationFromStudent(idCompte, idAnimation);
        Map<String, String> response = new HashMap<>();
        if (result.equals("ok")) {
            response.put("message", "ok");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "error");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/get-animations-by-id-compte")
    public ResponseEntity<List<AnimationEntity>> getAnimationsByCompteId(@RequestParam Long idCompte) {
        List<AnimationEntity> animations = compteService.getAnimationsByCompteId(idCompte);
        return ResponseEntity.ok(animations);
    }
}