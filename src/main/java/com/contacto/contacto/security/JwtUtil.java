package com.contacto.contacto.security;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import com.contacto.contacto.model.UsuarioModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("12345678901234567890123456789012".getBytes());
    private static final long EXPIRATION_TIME = 86400000; // 1 día

    public String generateToken(UsuarioModel user) {
        return Jwts.builder()
                .subject(user.getCorreo()) // Este es el campo "principal"
                .claim("idUsuario", user.getIdUsuario())
                .claim("nombre", user.getNombre())
                .claim("rol", user.getIdRol()) // Asumiendo que es un Long o String
                .issuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public Claims parseToken(String token) throws JwtException {
        token = token.trim();
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)  // Usar setSigningKey en lugar de verifyWith
                .build()
                .parseClaimsJws(token)
                .getBody();
    }    
}
