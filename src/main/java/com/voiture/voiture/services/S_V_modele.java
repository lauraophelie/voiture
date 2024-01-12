package com.voiture.voiture.services;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import com.voiture.voiture.modele.V_modele;

@Service
public class S_V_modele {

    public List<V_modele> rechercheMulticritere(String nom, String marque) {
        String sql = "SELECT * FROM v_modele WHERE 1=1";
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        if (nom != null) {
            sql += " AND modele = :nom";
            parameters.addValue("nom", nom);
        }

        if (marque != null) {
            sql += " AND marque = :marque";
            parameters.addValue("marque", marque);
        }

        return JdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<>(V_modele.class));
    }
}
