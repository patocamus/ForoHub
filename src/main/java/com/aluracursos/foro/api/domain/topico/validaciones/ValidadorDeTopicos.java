package com.aluracursos.foro.api.domain.topico.validaciones;

import com.aluracursos.foro.api.domain.topico.dto.DatosRegistroTopico;

public interface ValidadorDeTopicos {
    void validar(DatosRegistroTopico datos);
}
