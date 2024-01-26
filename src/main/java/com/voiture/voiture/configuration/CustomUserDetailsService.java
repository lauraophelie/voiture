package com.voiture.voiture.configuration;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Admin;
import com.voiture.voiture.repository.R_Admin;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final R_Admin dbUserRepository;

    public CustomUserDetailsService(R_Admin dbUserRepository) {
        this.dbUserRepository = dbUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = dbUserRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with email");
        }
        System.out.println(user.getNom());
        List<String> roles = new ArrayList<>();
        roles.add(user.getAdmin());
        UserDetails userDetails = User.builder().username(user.getEmail()).password(user.getPassword())
                .roles(roles.toArray(new String[0])).build();
        return userDetails;
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

}
