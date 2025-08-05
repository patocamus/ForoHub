package com.aluracursos.foro.api.controller;

import com.aluracursos.foro.api.domain.usuario.dto.DatosAutenticacionUsuario;
import com.aluracursos.foro.api.domain.usuario.dto.DatosJWTToken;
import com.aluracursos.foro.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        var authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());
        Authentication auth = authenticationManager.authenticate(authToken);
        var JWT = tokenService.generarToken((com.aluracursos.foro.api.domain.usuario.Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JWT));
    }
}
