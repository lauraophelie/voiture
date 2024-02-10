package com.voiture.voiture.services;

import java.util.List;


import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import com.voiture.voiture.modele.Modele;
import com.voiture.voiture.repository.R_Modele;

@Service
public class S_Modele {
    private R_Modele r_Modele;    
    

    public S_Modele(R_Modele r_Modele) {
        this.r_Modele = r_Modele;
    }

    public Modele save(Modele modele){
        return r_Modele.save(modele);
    }

    public Modele update(int idModele,Modele modifier){
        return this.r_Modele.findById(idModele).map(
            newModele ->{
                newModele.setNom(modifier.getNom());
                newModele.setMarque(modifier.getMarque());
                return r_Modele.save(newModele);
            }
        ).orElseThrow(() -> new RuntimeException("Aucune Modele correspondant"));
    }

    public List<Modele> findAll(){
        return r_Modele.findAll();
    }    

    public Modele findById(int id) {
        return r_Modele.findById(id).orElseThrow(()-> new NoSuchElementException("modele introuvable : " + id));
    }    
    
    public List<Modele> findByMarque(int idMarque) {
        return r_Modele.findByMarque(idMarque);
    }
}
