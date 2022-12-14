package com.example.redis.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
    @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .cors().and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authorizeRequests()
               .anyRequest().authenticated();
   }
}
