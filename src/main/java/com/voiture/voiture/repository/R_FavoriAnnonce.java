package com.voiture.voiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voiture.voiture.modele.FavoriAnnonce;

public interface R_FavoriAnnonce extends JpaRepository<FavoriAnnonce,Integer>{
    @Query(value = "SELECT * FROM Favori_annonce f WHERE f.id_utilisateur = :id_utilisateur", nativeQuery = true)
    List<FavoriAnnonce> listannoncebyuser(@Param("id_utilisateur") String id_utilisateur );
}
