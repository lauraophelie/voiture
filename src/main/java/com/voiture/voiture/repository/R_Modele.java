package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.CaracteristiqueModele;
import com.voiture.voiture.modele.Modele;
import java.util.List;

@Repository
public interface R_Modele extends JpaRepository<Modele,Integer>{
    @Query(value = "select * from modele where idmarque = :id_marque", nativeQuery = true)
    List<Modele> findByMarque(@Param("id_marque") int idMarque);

    @Query(value = "select * from caracteristique_modele where id_modele = :id_modele", nativeQuery = true)
    List<CaracteristiqueModele> findByIdModeles(@Param("id_modele") int idModele);
}
