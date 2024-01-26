package com.voiture.voiture.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.V_Annonce;

@Service
public class S_V_Annonce {

    private NamedParameterJdbcTemplate JdbcTemplate; 

    public S_V_Annonce(NamedParameterJdbcTemplate jdbcTemplate) {
        JdbcTemplate = jdbcTemplate;
    }

    public List<V_Annonce> rechercheMulticritere(V_Annonce annonce,Double prix1,Double prix2,Double kilometrage1,Double kilometrage2,Timestamp date1,Timestamp date2) {
        String sql = "SELECT * FROM v_annonce WHERE 1=1";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        
        if (annonce != null) {
            if (annonce.getNom() != null) {
                sql += " AND nom LIKE :nom";
                parameters.addValue("nom", "%" + annonce.getNom() + "%");
            }
    
            if (annonce.getMarque() != null) {
                sql += " AND marque LIKE :marque";
                parameters.addValue("marque", "%" + annonce.getMarque() + "%");
            }
    
            if (annonce.getModele() != null) {
                sql += " AND modele LIKE :modele";
                parameters.addValue("modele", "%" + annonce.getModele() + "%");
            }
    
            if (annonce.getType_energie() != null) {
                sql += " AND type_energie LIKE :type_energie";
                parameters.addValue("type_energie", "%" + annonce.getType_energie() + "%");
            }
    
            if (annonce.getBoite_vitesse() != null) {
                sql += " AND boite_vitesse LIKE :boite_vitesse";
                parameters.addValue("boite_vitesse", "%" + annonce.getBoite_vitesse() + "%");
            }
    
            if (annonce.getLieu() != null) {
                sql += " AND lieu LIKE :lieu";
                parameters.addValue("lieu", "%" + annonce.getLieu() + "%");
            }
        }
        
        if (prix1 != null && prix2 != null) {
            sql += " AND prix BETWEEN :prix1 AND :prix2";
            parameters.addValue("prix1",prix1);
            parameters.addValue("prix2",prix2);
        }

        if (kilometrage1 != null && kilometrage2 != null) {
            sql += " AND kilometrage BETWEEN :kilometrage1 AND :kilometrage2";
            parameters.addValue("kilometrage1",kilometrage1);
            parameters.addValue("kilometrage2",kilometrage2);
        }

        if (date1 != null && date2 != null) {
            sql += " AND date_heure BETWEEN :date1 AND :date2";
            parameters.addValue("date1",date1);
            parameters.addValue("date2",date2);
        }        

        System.out.println(sql);
    
        return JdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<>(V_Annonce.class));
    }
}
