package com.voiture.voiture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.authentification.JwtUtil;
import com.voiture.voiture.modele.Voiture;
import com.voiture.voiture.services.S_Voiture;

@RestController
@RequestMapping("/voiture")
public class C_Voiture {
    private final S_Voiture service;
    private final JwtUtil jwtUtil;

    public C_Voiture(S_Voiture service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/save")
    public ResponseEntity<APIResponse> save(@RequestBody Voiture voiture) {
        try {
            Voiture v = service.save(voiture);
            APIResponse api = new APIResponse(null, v);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
