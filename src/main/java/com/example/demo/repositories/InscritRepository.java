package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.InscritEntity;

public interface InscritRepository extends JpaRepository<InscritEntity, Long> {
    InscritEntity findByEmailAndMdp(String email, String mdp);

}
