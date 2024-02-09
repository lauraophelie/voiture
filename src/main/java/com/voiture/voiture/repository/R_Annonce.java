package com.voiture.voiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voiture.voiture.modele.Annonce;

import jakarta.transaction.Transactional;

public interface R_Annonce extends JpaRepository<Annonce,Integer>{

    @Query(value = "SELECT * FROM Annonce a WHERE a.etat = :etat", nativeQuery = true)
    List<Annonce> listAnnonceByEtat(@Param("etat") int etat);


    @Query(value = "SELECT * FROM annonce WHERE proprietaire = :prorietaire", nativeQuery = true)
    List<Annonce> getByProprietaire(@Param("proprietaire") String proprietaire);
    
    @Query(value = "SELECT COUNT(*) FROM Annonce a")
    int nombre_annonce();
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO validation_annonce (date_heure_validation, id_admin, id_annonce) VALUES (CURRENT_TIMESTAMP, :id_admin, :id_annonce)", nativeQuery = true)
    void insertvalidation(@Param("id_admin") int id_admin, @Param("id_annonce") int id_annonce);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO favori_annonce (id_annonce, id_utilisateur) VALUES (:id_annonce, :id_utilisateur)", nativeQuery = true)
    void insert_favori_annonce(@Param("id_annonce") int id_annonce, @Param("id_utilisateur") String id_utilisateur);

}
