package com.example.tacocloud.controllers;

import com.example.tacocloud.model.User;
import com.example.tacocloud.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo){
        return username->{
            User user = userRepo.findByUsername(username);
            if(user != null){
                return user;

            }
            throw new UsernameNotFoundException("User " + username + "not found");
        };
    }
//    @Bean
//    public SecurityFilterChain security(HttpSecurity http) throws Exception{
//        DefaultSecurityFilterChain user = http
//                .authorizeRequests()
//                .requestMatchers("/design", "/orders").hasRole("USER")
//                .requestMatchers("/", "/**").permitAll()
//                .and()
//                .build();
//        return user;
//    }
}
