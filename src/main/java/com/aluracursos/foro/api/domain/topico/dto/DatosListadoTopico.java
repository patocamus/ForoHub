package com.aluracursos.foro.api.domain.topico.dto;

import com.aluracursos.foro.api.domain.topico.Topico;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje());
    }
}
