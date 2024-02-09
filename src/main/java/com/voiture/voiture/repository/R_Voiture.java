package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.Voiture;

@Repository
public interface R_Voiture extends JpaRepository<Voiture, Integer>{

}
