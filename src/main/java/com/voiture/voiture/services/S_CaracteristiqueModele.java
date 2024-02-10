package com.voiture.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.CaracteristiqueModele;
import com.voiture.voiture.repository.R_CaracteristiqueModele;

@Service
public class S_CaracteristiqueModele {
    private final R_CaracteristiqueModele repository;

    public S_CaracteristiqueModele(R_CaracteristiqueModele repository) {
        this.repository = repository;
    } 

    public List<CaracteristiqueModele> findByIdModeles(int idModele) {
        return repository.findByIdModeles(idModele);
    }
}
