package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Marque;

public interface R_Marque extends JpaRepository<Marque,Integer>{
    
}
