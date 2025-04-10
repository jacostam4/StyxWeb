package com.contacto.contacto.security;



import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilterBean{

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String path = httpRequest.getRequestURI();

    if (path.equals("/api/usuario/auth") || path.equals("/api/usuario/register")) {
        chain.doFilter(request, response);
        return;
    }

    String authHeader = httpRequest.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        throw new ServletException("Token JWT faltante o incorrecto");
    }

    String token = authHeader.substring(7); // Remueve "Bearer "

    try {
        Claims claims = jwtUtil.parseToken(token);
        request.setAttribute("claims", claims);

        // 🧠 ESTABLECER AUTENTICACIÓN EN EL CONTEXTO DE SEGURIDAD
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(claims.getSubject(), null, Collections.emptyList());

        SecurityContextHolder.getContext().setAuthentication(authentication);

    } catch (JwtException e) {
        throw new ServletException("Token inválido: " + e.getMessage());
    }

    chain.doFilter(request, response);
    }
}
