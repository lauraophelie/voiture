package com.voiture.voiture.services;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.DetailsAnnonce;
import com.voiture.voiture.repository.R_DetailsAnnonce;

@Service
public class S_DetailsAnnonce {
    private final R_DetailsAnnonce repository;

    public S_DetailsAnnonce(R_DetailsAnnonce repository) {
        this.repository = repository;
    }

    public DetailsAnnonce save(DetailsAnnonce detailsAnnonce) {
        return repository.save(detailsAnnonce);
    }

    public DetailsAnnonce findByIdAnnonce(int idAnnonce) {
        return repository.findByIdAnnonce(idAnnonce);
    }
}
