package com.voiture.voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int nombrePlace;
    double kilometrage;
    @OneToOne
    @JoinColumn(name = "id_marque")
    Marque marque;
    @OneToOne
    @JoinColumn(name = "id_modele")
    Modele modele;
    @OneToOne
    @JoinColumn(name = "id_categorie")
    Categorie categorie;
    @OneToOne
    @JoinColumn(name = "id_energie")
    TypeEnergie energie;
    @OneToOne
    @JoinColumn(name = "id_vitesse")
    BoiteVitesse vitesse;
    public Voiture() {
    }
    public Voiture(int id, int nombrePlace, double kilometrage, Marque marque, Modele modele, Categorie categorie,
            TypeEnergie energie, BoiteVitesse vitesse) {
        this.id = id;
        this.nombrePlace = nombrePlace;
        this.kilometrage = kilometrage;
        this.marque = marque;
        this.modele = modele;
        this.categorie = categorie;
        this.energie = energie;
        this.vitesse = vitesse;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNombrePlace() {
        return nombrePlace;
    }
    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }
    public double getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }
    public Marque getMarque() {
        return marque;
    }
    public void setMarque(Marque marque) {
        this.marque = marque;
    }
    public Modele getModele() {
        return modele;
    }
    public void setModele(Modele modele) {
        this.modele = modele;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public TypeEnergie getEnergie() {
        return energie;
    }
    public void setEnergie(TypeEnergie energie) {
        this.energie = energie;
    }
    public BoiteVitesse getVitesse() {
        return vitesse;
    }
    public void setVitesse(BoiteVitesse vitesse) {
        this.vitesse = vitesse;
    }
}
