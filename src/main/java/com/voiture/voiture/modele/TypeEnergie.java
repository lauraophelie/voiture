package com.voiture.voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="type_energie")
public class TypeEnergie {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String designation;
    public TypeEnergie(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }
    public TypeEnergie() {
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
