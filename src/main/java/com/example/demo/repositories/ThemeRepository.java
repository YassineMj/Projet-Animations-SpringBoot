package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ThemeEntity;

public interface ThemeRepository extends JpaRepository<ThemeEntity, Long>{

}
