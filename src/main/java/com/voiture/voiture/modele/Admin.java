package com.voiture.voiture.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String email;
    String password;
    @Column(name = "isadmin")
    private int admin;
    public Admin(int id, String nom, String email, String password,int admin) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Admin() {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAdmin() {
        if (this.admin == 1) {
            return "ADMIN";
        }
        return "USER";
    }
    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public void setAdmin(String admin) {
        if (admin.equalsIgnoreCase("ROLE_ADMIN")) {
            this.admin = 1;
        } else {
            this.admin = 0;
        }
    }
}
