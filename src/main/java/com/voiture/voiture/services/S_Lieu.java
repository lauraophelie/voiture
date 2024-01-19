package com.voiture.voiture.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Lieu;
import com.voiture.voiture.repository.R_Lieu;

@Service
public class S_Lieu {
    private final R_Lieu r_Lieu;

    public S_Lieu(R_Lieu r_Lieu) {
        this.r_Lieu = r_Lieu;
    }

    public Lieu save(Lieu lieu){
        return r_Lieu.save(lieu);
    }

    public Lieu update(int idLieu,Lieu modifier){
        return this.r_Lieu.findById(idLieu).map(
            newLieu ->{
                newLieu.setNom_lieu(modifier.getNom_lieu());
                return r_Lieu.save(newLieu);
            }
        ).orElseThrow(() -> new RuntimeException("Aucune Lieu correspondant"));
    }

    public List<Lieu> findAll(){
        return r_Lieu.findAll();
    }    

    public Lieu findById(int id) {
        return r_Lieu.findById(id).orElseThrow(()-> new NoSuchElementException("Lieu introuvable : " + id));
    }
}
