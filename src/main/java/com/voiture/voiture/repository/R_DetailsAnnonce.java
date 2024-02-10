package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.DetailsAnnonce;

@Repository
public interface R_DetailsAnnonce extends JpaRepository<DetailsAnnonce, Integer>{

}
