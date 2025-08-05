package com.aluracursos.foro.api.domain.topico.dto;

import com.aluracursos.foro.api.domain.topico.StatusTopico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        String autor,
        String curso
) {
}
