package com.aluracursos.foro.api.controller;

import jakarta.validation.Valid;
import com.aluracursos.foro.api.domain.topico.TopicoService;
import com.aluracursos.foro.api.domain.topico.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        var dto = service.registrar(datos);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(service.listar(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalle(id));
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody @Valid DatosActualizarTopico datos) {
        service.actualizar(datos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
