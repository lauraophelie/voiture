package com.voiture.voiture.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.voiture.voiture.authentification.JwtUtil;
import com.voiture.voiture.modele.Admin;
import com.voiture.voiture.modele.request.LoginReq;
import com.voiture.voiture.modele.response.ErrorRes;
import com.voiture.voiture.modele.response.LoginRes;
import com.voiture.voiture.repository.R_Admin;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("/rest/auth")
@CrossOrigin("*")
public class LoginController {
    private final AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;
    private final R_Admin r_Admin;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,R_Admin r_Admin) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.r_Admin = r_Admin;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginReq loginReq) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(),
                            loginReq.getPassword()));
            String email = authentication.getName();
            Admin user = r_Admin.findByEmail(email);
            user.setAdmin(((List<? extends GrantedAuthority>)authentication.getAuthorities()).get(0).getAuthority());
            String token = jwtUtil.createToken(user);
            LoginRes loginRes = new LoginRes(email, token);

            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
    }
}
