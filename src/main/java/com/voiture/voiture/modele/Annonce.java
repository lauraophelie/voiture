package com.voiture.voiture.modele;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Timestamp dateHeure;
    String titre;
    String description;
    double prixVente;
    @OneToOne
    @JoinColumn(name = "lieu")
    Lieu lieu;
    String proprietaire;
    @OneToOne
    @JoinColumn(name = "id_voiture")
    Voiture voiture;
    int etat;
    int status;
    public Annonce(int id, Timestamp dateHeure, String titre, String description, double prixVente, Lieu lieu,
            String idproprietaire, Voiture voiture, int etat, int status) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.titre = titre;
        this.description = description;
        this.prixVente = prixVente;
        this.lieu = lieu;
        this.proprietaire = idproprietaire;
        this.voiture = voiture;
        this.etat = etat;
        this.status = status;
    }
    public Annonce() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getDateHeure() {
        return dateHeure;
    }
    public void setDateHeure(Timestamp dateHeure) {
        this.dateHeure = dateHeure;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }
    public Lieu getLieu() {
        return lieu;
    }
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    public String getProprietaire() {
        return proprietaire;
    }
    public void setProprietaire(String idproprietaire) {
        this.proprietaire = idproprietaire;
    }
    public Voiture getVoiture() {
        return voiture;
    }
    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
