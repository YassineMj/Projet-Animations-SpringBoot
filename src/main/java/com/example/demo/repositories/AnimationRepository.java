package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AnimationEntity;
import com.example.demo.entities.InscritEntity;

public interface AnimationRepository extends JpaRepository<AnimationEntity, Long> {
    
	List<AnimationEntity> findByThemeId(Long idTheme);
}
