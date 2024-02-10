package com.voiture.voiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.CaracteristiqueModele;

@Repository
public interface R_CaracteristiqueModele extends JpaRepository<CaracteristiqueModele,Integer>{
    @Query(value = "select * from caracteristique_modele where id_modele = :id_modele", nativeQuery = true)
    List<CaracteristiqueModele> findByIdModeles(@Param("id_modele") int idModele);
}
