package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.TypeEnergie;

public interface R_TypeEnergie extends JpaRepository<TypeEnergie,Integer>{
    
}
