package com.aluracursos.foro.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.aluracursos.foro.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    public String generarToken(Usuario usuario) {
        Algorithm algoritmo = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(usuario.getCorreoElectronico())
                .withExpiresAt(generarFechaExpiracion())
                .sign(algoritmo);
    }

    public String getSubject(String tokenJWT) {
        if (tokenJWT == null) throw new RuntimeException("Token inválido");

        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(tokenJWT)
                .getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
