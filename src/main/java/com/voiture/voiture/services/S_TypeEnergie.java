package com.voiture.voiture.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import com.voiture.voiture.modele.TypeEnergie;
import com.voiture.voiture.repository.R_TypeEnergie;

@Service
public class S_TypeEnergie {
    private final R_TypeEnergie r_TypeEnergie;

    public S_TypeEnergie(R_TypeEnergie r_TypeEnergie) {
        this.r_TypeEnergie = r_TypeEnergie;
    }

    public TypeEnergie save(TypeEnergie typeenergie){
        return r_TypeEnergie.save(typeenergie);
    }

    public TypeEnergie update(int idTypeEnergie,TypeEnergie typeenergie){
        return r_TypeEnergie.findById(idTypeEnergie).map(
            newTypeEnergie ->{
                newTypeEnergie.setDesignation(typeenergie.getDesignation());
                return r_TypeEnergie.save(newTypeEnergie);
            }
        ).orElseThrow(() -> new RuntimeException("Aucun TypeEnergie correspondant"));
    }

    public List<TypeEnergie> findAll(){
        return r_TypeEnergie.findAll();
    }

    public TypeEnergie findById(int id){
        return r_TypeEnergie.findById(id).orElseThrow(()-> new NoSuchElementException("Type d'energie introuvable : " + id));
    }
    

}
