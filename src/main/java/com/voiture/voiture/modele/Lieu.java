package com.voiture.voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lieu")
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom_lieu;
    public Lieu() {
    }
    public Lieu(int id, String nom_lieu) {
        this.id = id;
        this.nom_lieu = nom_lieu;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom_lieu() {
        return nom_lieu;
    }
    public void setNom_lieu(String nom_lieu) {
        this.nom_lieu = nom_lieu;
    }
}
