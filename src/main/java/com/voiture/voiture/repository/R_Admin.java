package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.Admin;

@Repository
public interface R_Admin extends JpaRepository<Admin,Integer>{
    @Query("SELECT u FROM Admin u WHERE u.email = :email")
    public Admin findByEmail(@Param("email") String email);
}
