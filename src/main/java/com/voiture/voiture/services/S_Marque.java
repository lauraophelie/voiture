package com.voiture.voiture.services;

import java.util.List;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Marque;
import com.voiture.voiture.repository.R_Marque;

@Service
public class S_Marque {

    private final R_Marque r_marque;

    public S_Marque(R_Marque r_marque) {
        this.r_marque = r_marque;
    }

    public Marque save(Marque marque){
        return r_marque.save(marque);
    } 

    public Marque update(int idmarque,Marque modifier){
        return this.r_marque.findById(idmarque).map(
            newMarque ->{
                newMarque.setNom(modifier.getNom());
                return r_marque.save(newMarque);
            }
        ).orElseThrow(() -> new RuntimeException("Aucune marque correspondant"));
    }

    public List<Marque> findAll(){
        return r_marque.findAll();
    }    

    public Marque findById(int id) {
        return r_marque.findById(id).orElseThrow(()-> new NoSuchElementException("Marque introuvable : " + id));
    }

}
