package com.voiture.voiture.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.authentification.JwtUtil;
import com.voiture.voiture.modele.Marque;
import com.voiture.voiture.services.S_Marque;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/marque")
@CrossOrigin("*")
public class C_Marque {
    private final S_Marque s_marque;
    private final JwtUtil jwtUtil;
    
    @Autowired
    public C_Marque(S_Marque s_marque,JwtUtil jwtUtil) {        
        this.s_marque = s_marque;
        this.jwtUtil = jwtUtil;
    }
    
    @PostMapping("/insert")
    public ResponseEntity<APIResponse> save(@RequestBody Marque marque){
        try {
            Marque te = s_marque.save(marque);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse> update(@PathVariable int id,@RequestBody Marque marque){
        try {
            Marque te = s_marque.update(id, marque);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<APIResponse> findAll(){
        try {
            List<Marque> te = s_marque.findAll();
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable int id){
        try {
            Marque te = s_marque.findById(id);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
