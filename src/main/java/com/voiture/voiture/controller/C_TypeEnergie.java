package com.voiture.voiture.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.modele.TypeEnergie;
import com.voiture.voiture.services.S_TypeEnergie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/typeenergie")
@CrossOrigin(origins = "*")
public class C_TypeEnergie {
    private final S_TypeEnergie s_TypeEnergie;

    @Autowired
    public C_TypeEnergie(S_TypeEnergie s_TypeEnergie) {
        this.s_TypeEnergie = s_TypeEnergie;
    }
    
    @PostMapping("/insert")
    public ResponseEntity<APIResponse> save(@RequestBody TypeEnergie typeEnergie){        
        try {
            TypeEnergie te = s_TypeEnergie.save(typeEnergie);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse> update(@PathVariable int id,@RequestBody TypeEnergie TypeEnergie){
        try {
            TypeEnergie te = s_TypeEnergie.update(id, TypeEnergie);
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
            List<TypeEnergie> te = s_TypeEnergie.findAll();
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
            TypeEnergie te = s_TypeEnergie.findById(id);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



}
