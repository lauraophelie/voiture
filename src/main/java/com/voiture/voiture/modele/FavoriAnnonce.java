package com.voiture.voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favori_annonce")
public class FavoriAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int id_annonce;
    String id_utilisateur;
    public FavoriAnnonce(int id, int id_annonce, String id_utilisateur) {
        this.id = id;
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
    }
    public FavoriAnnonce() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }
    public String getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}
