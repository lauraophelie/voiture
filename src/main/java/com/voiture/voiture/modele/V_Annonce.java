package com.voiture.voiture.modele;

import java.sql.Timestamp;

public class V_Annonce {
    public V_Annonce(int id, String nom, String description, String proprietaire, int id_voiture, int idlieu, int etat,
            String marque, String modele, String type_energie, String boite_vitesse, String lieu, double prix,
            double kilometrage, Timestamp date_heure) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.proprietaire = proprietaire;
        this.id_voiture = id_voiture;
        this.idlieu = idlieu;
        this.etat = etat;
        this.marque = marque;
        this.modele = modele;
        this.type_energie = type_energie;
        this.boite_vitesse = boite_vitesse;
        this.lieu = lieu;
        this.prix = prix;
        this.kilometrage = kilometrage;
        this.date_heure = date_heure;
    }
    public V_Annonce() {
    }
    int id;
    String nom;
    String description;
    String proprietaire;
    int id_voiture;
    int idlieu;
    int etat;
    String marque;
    String modele;
    String type_energie;
    String boite_vitesse;
    String lieu;
    double prix;
    double kilometrage;
    Timestamp date_heure;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProprietaire() {
        return proprietaire;
    }
    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
    public int getId_voiture() {
        return id_voiture;
    }
    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }
    public int getIdlieu() {
        return idlieu;
    }
    public void setIdlieu(int idlieu) {
        this.idlieu = idlieu;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public String getType_energie() {
        return type_energie;
    }
    public void setType_energie(String type_energie) {
        this.type_energie = type_energie;
    }
    public String getBoite_vitesse() {
        return boite_vitesse;
    }
    public void setBoite_vitesse(String boite_vitesse) {
        this.boite_vitesse = boite_vitesse;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public double getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }
    public Timestamp getDate_heure() {
        return date_heure;
    }
    public void setDate_heure(Timestamp date_heure) {
        this.date_heure = date_heure;
    }
}
