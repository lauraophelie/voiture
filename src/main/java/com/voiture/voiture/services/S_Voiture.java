package com.voiture.voiture.services;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Voiture;
import com.voiture.voiture.repository.R_Voiture;

@Service
public class S_Voiture {
    private final R_Voiture repository;

    public S_Voiture(R_Voiture repository) {
        this.repository = repository;
    }

    public Voiture save(Voiture voiture) {
        return repository.save(voiture);
    }
}
