package com.voiture.voiture.services;

import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.R_Admin;

@Service
public class S_Admin {
    private final R_Admin R_Admin;

    public S_Admin(com.voiture.voiture.repository.R_Admin r_Admin) {
        R_Admin = r_Admin;
    }
    
    
}
