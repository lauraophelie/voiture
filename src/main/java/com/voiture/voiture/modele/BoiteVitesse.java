package com.voiture.voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="boite_vitesse")
public class BoiteVitesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String designation;
    public BoiteVitesse(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }
    public BoiteVitesse() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
