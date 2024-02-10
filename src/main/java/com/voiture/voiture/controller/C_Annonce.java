package com.voiture.voiture.controller;

import java.sql.Timestamp;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.api.APIResponse;
import com.voiture.voiture.authentification.JwtUtil;
import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.FavoriAnnonce;
import com.voiture.voiture.modele.V_Annonce;
import com.voiture.voiture.services.S_Annonce;
import com.voiture.voiture.services.S_FavoriAnnonce;
import com.voiture.voiture.services.S_V_Annonce;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/annonce")
@CrossOrigin(origins = "*")
public class C_Annonce {
    private final S_Annonce s_Annonce;
    private final S_FavoriAnnonce s_FavoriAnnonce;
    private final JwtUtil jwtUtil;
    private final S_V_Annonce s_V_Annonce;

    public C_Annonce(S_Annonce s_Annonce,JwtUtil jwtUtil,S_FavoriAnnonce s_FavoriAnnonce,S_V_Annonce s_V_Annonce) {
        this.s_Annonce = s_Annonce;
        this.jwtUtil = jwtUtil;
        this.s_FavoriAnnonce=s_FavoriAnnonce;
        this.s_V_Annonce = s_V_Annonce;
    }

    @PostMapping("/insert")
    public ResponseEntity<APIResponse> save(@RequestBody Annonce annonce){
        try {
            Annonce te = s_Annonce.save(annonce);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/insert_favori_annonce")
    public ResponseEntity<APIResponse> savefavori(@RequestBody FavoriAnnonce favoriAnnonce){
        try {
            FavoriAnnonce te = s_FavoriAnnonce.save(favoriAnnonce);
            APIResponse api = new APIResponse(null,te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/find_by_user/{proprietaire}")
    public ResponseEntity<APIResponse> getByProprietaire(@PathVariable String proprietaire) {
        try {
            List<Annonce> liste = s_Annonce.findByProprietaire(proprietaire);

            APIResponse api = new APIResponse(null, liste);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/liste_annonce")
    public ResponseEntity<APIResponse> findAll(){
        try {
            List<Annonce> te = s_Annonce.findAll();
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    @PutMapping("/updatestatus/{id}")
    public ResponseEntity<APIResponse> updatestatus(@PathVariable int id,@RequestBody int status){
        try {
            System.out.println(status);
            Annonce te = s_Annonce.updatestatus(id, status);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/validation_annonce/{idannonce}")
    public ResponseEntity<APIResponse> validation_annonce(@PathVariable int idannonce,@RequestHeader(name = "Authorization") String authorizationHeader){
        try {
            int idadmin = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                idadmin = JwtUtil.getUserId(claims);
            }
            Annonce te = s_Annonce.validation_annonce(idannonce);
            s_Annonce.insertvalidation(idadmin,te.getId());
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/findAllvalidate")
    public ResponseEntity<APIResponse> findAllvalidate(){
        try {
            List<Annonce> te = s_Annonce.findAllvalidate();
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
            Annonce te = s_Annonce.findById(id);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/count_annonce")
    public ResponseEntity<APIResponse> count_annonce(){
        try {
            int te = s_Annonce.getNombre_annonce();
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/searchmulti")
    public ResponseEntity<APIResponse> multiAnnonce(@RequestBody(required = false) V_Annonce annonce,
    @RequestParam(name = "prix1", required = false) Double prix1,
    @RequestParam(name = "prix2", required = false) Double prix2,
    @RequestParam(name = "kilometrage1", required = false) Double kilometrage1,
    @RequestParam(name = "kilometrage2", required = false) Double kilometrage2,
    @RequestParam(name = "date1", required = false) Timestamp date1,
    @RequestParam(name = "date2", required = false) Timestamp date2) {
        try {
            List<V_Annonce> list = s_V_Annonce.rechercheMulticritere(annonce,prix1,prix2,kilometrage1,kilometrage2,date1,date2);
            APIResponse api = new APIResponse(null, list);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
