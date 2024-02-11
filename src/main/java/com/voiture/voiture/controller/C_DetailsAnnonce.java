package com.voiture.voiture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.modele.DetailsAnnonce;
import com.voiture.voiture.services.S_DetailsAnnonce;

@RestController
@RequestMapping("/details_annonce")
@CrossOrigin("*")
public class C_DetailsAnnonce {
    private final S_DetailsAnnonce service;

    public C_DetailsAnnonce(S_DetailsAnnonce service) {
        this.service = service;
    }

    @GetMapping("/findByAnnonce/{idAnnonce}")
    public ResponseEntity<APIResponse> save(@PathVariable int idAnnonce) {
        try {
            DetailsAnnonce d = service.findByIdAnnonce(idAnnonce);
            APIResponse api = new APIResponse(null, d);
            
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<APIResponse> save(@RequestBody DetailsAnnonce details) {
        try {
            DetailsAnnonce d = service.save(details);
            APIResponse api = new APIResponse(null, d);
            
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
