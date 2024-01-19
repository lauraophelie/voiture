package com.voiture.voiture.services;

import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.repository.R_Annonce;

@Service
public class S_Annonce {
    private final R_Annonce r_Annonce;

    public S_Annonce(R_Annonce r_Annonce) {
        this.r_Annonce = r_Annonce;
    }

    public Annonce save(Annonce annonce){
        return r_Annonce.save(annonce);
    }

    public void save_favorite(int idannonce,String id_user){
        r_Annonce.insert_favori_annonce(idannonce, id_user);
    }

    public List<Annonce> findAll(){
        return r_Annonce.findAll();
    }

    public Annonce updatestatus(int idannonce,int status){
        return this.r_Annonce.findById(idannonce).map(
            newAnnonce ->{
                newAnnonce.setStatus(status);
                return r_Annonce.save(newAnnonce);
            }
        ).orElseThrow(() -> new RuntimeException("Aucune annonce correspondant"));
    }

    public Annonce validation_annonce(int idannonce){
        return this.r_Annonce.findById(idannonce).map(
            newAnnonce ->{
                newAnnonce.setEtat(10);
                return r_Annonce.save(newAnnonce);
            }
        ).orElseThrow(() -> new RuntimeException("Aucune annonce correspondant"));
    }

    public void insertvalidation(int admin,int annonce){
        r_Annonce.insertvalidation(admin, annonce);
    }

    public List<Annonce> findAllvalidate(){
        return r_Annonce.listAnnonceByEtat(10);
    }

    public int getNombre_annonce(){
        return r_Annonce.nombre_annonce();
    }    

    public Annonce findById(int id){
        return r_Annonce.findById(id).orElseThrow(()-> new NoSuchElementException("Annonce introuvable : " + id));
    }
}
