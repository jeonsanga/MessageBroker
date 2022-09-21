package com.example.redis.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	/* �α��� ��η� ��û�� ���� �� ȣ��Ǵ� �޼��� */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // username�� password�� �̿��� Authentication Ÿ���� ��ū ����
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(authenticationToken);
    }
    



}
