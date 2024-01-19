package com.voiture.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.FavoriAnnonce;
import com.voiture.voiture.repository.R_FavoriAnnonce;

@Service
public class S_FavoriAnnonce {
    private final R_FavoriAnnonce r_FavoriAnnonce;

    public S_FavoriAnnonce(R_FavoriAnnonce r_FavoriAnnonce) {
        this.r_FavoriAnnonce = r_FavoriAnnonce;
    }

    public FavoriAnnonce save(FavoriAnnonce favoriAnnonce){
        return r_FavoriAnnonce.save(favoriAnnonce);
    }

    public List<FavoriAnnonce> listannoncebyiduser(String iduser){
        return r_FavoriAnnonce.listannoncebyuser(iduser);
    }   

    
}
