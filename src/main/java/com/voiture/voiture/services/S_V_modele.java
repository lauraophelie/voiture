package com.voiture.voiture.services;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.V_modele;

@Service
public class S_V_modele {

    private NamedParameterJdbcTemplate JdbcTemplate;  

    public S_V_modele(NamedParameterJdbcTemplate jdbcTemplate) {
        JdbcTemplate = jdbcTemplate;
    }

    public List<V_modele> rechercheMulticritere(V_modele modele) {
        String sql = "SELECT * FROM v_modele WHERE 1=1";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
    
        if (modele.getModele() != null) {
            sql += " AND modele LIKE :modele";
            parameters.addValue("modele", "%" + modele.getModele() + "%");
        }
    
        if (modele.getMarque() != null) {
            sql += " AND marque LIKE :marque";
            parameters.addValue("marque", "%" + modele.getMarque() + "%");
        }
    
        System.out.println(sql);
    
        return JdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<>(V_modele.class));
    }
    

}
