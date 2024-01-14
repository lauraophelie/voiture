package com.voiture.voiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.modele.V_modele;
import com.voiture.voiture.services.S_V_modele;

@RestController
@RequestMapping("/v_modele")
public class C_v_modele {
    private final S_V_modele s_V_modele;

    @Autowired
    public C_v_modele(S_V_modele s_V_modele) {
        this.s_V_modele = s_V_modele;
    }

    @GetMapping("/searchmulti")
    public ResponseEntity<APIResponse> multi(@RequestBody V_modele modele){
        System.out.println("ohhh");
        try {
            List<V_modele> list = s_V_modele.rechercheMulticritere(modele);
            APIResponse api = new APIResponse(null, list);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
}
