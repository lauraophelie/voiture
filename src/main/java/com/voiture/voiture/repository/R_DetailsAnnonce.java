package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.DetailsAnnonce;

@Repository
public interface R_DetailsAnnonce extends JpaRepository<DetailsAnnonce, Integer>{
    @Query(value = "select * from details_annonce where id_annonce = :id_annonce", nativeQuery = true)
    DetailsAnnonce findByIdAnnonce(@Param("id_annonce") int idAnnonce);
}
