package com.voiture.voiture.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.modele.Lieu;
import com.voiture.voiture.services.S_Lieu;

@RestController
@RequestMapping("/lieu")
@CrossOrigin("*")
public class C_Lieu {
    private final S_Lieu s_Lieu;

    @Autowired    
    public C_Lieu(S_Lieu s_Lieu) {
        this.s_Lieu = s_Lieu;
    }

    @PostMapping("/insert")
    public ResponseEntity<APIResponse> save(@RequestBody Lieu Lieu){
        try {
            Lieu te = s_Lieu.save(Lieu);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse> update(@PathVariable int id,@RequestBody Lieu Lieu){
        try {
            Lieu te = s_Lieu.update(id, Lieu);
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
            List<Lieu> te = s_Lieu.findAll();
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
            Lieu te = s_Lieu.findById(id);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    
}
