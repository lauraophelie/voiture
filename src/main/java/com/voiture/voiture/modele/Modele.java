package com.voiture.voiture.modele;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "modele")
public class Modele {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    @OneToOne
    @JoinColumn(name = "idmarque")
    Marque marque;   
    
    @Transient
    List<CaracteristiqueModele> listecaracteristique;
    public Modele(int id, String nom, Marque marque,List<CaracteristiqueModele> listecaracteristique) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.listecaracteristique = listecaracteristique;
    }
    public Modele() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Marque getMarque() {
        return marque;
    }
    public void setMarque(Marque marque) {
        this.marque = marque;
    }
    public List<CaracteristiqueModele> getListecaracteristique() {
        return listecaracteristique;
    }
    public void setListecaracteristique(List<CaracteristiqueModele> listecaracteristique) {
        this.listecaracteristique = listecaracteristique;
    }
     
}
