package com.voiture.voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="caracteristique_modele")
public class CaracteristiqueModele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne
    @JoinColumn(name = "id_categorie")
    Categorie categorie;
    @OneToOne
    @JoinColumn(name = "id_type_vitesse")
    BoiteVitesse boiteVitesse;
    @OneToOne
    @JoinColumn(name = "id_energie")
    TypeEnergie typeEnergie;
    public CaracteristiqueModele(Categorie categorie, BoiteVitesse boiteVitesse, TypeEnergie typeEnergie) {
        this.categorie = categorie;
        this.boiteVitesse = boiteVitesse;
        this.typeEnergie = typeEnergie;
    }
    public CaracteristiqueModele() {
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public BoiteVitesse getBoiteVitesse() {
        return boiteVitesse;
    }
    public void setBoiteVitesse(BoiteVitesse boiteVitesse) {
        this.boiteVitesse = boiteVitesse;
    }
    public TypeEnergie getTypeEnergie() {
        return typeEnergie;
    }
    public void setTypeEnergie(TypeEnergie typeEnergie) {
        this.typeEnergie = typeEnergie;
    }
}
