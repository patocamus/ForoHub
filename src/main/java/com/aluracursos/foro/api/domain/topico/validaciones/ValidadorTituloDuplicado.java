package com.aluracursos.foro.api.domain.topico.validaciones;

import com.aluracursos.foro.api.domain.ValidacionException;
import com.aluracursos.foro.api.domain.topico.TopicoRepository;
import com.aluracursos.foro.api.domain.topico.dto.DatosRegistroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTituloDuplicado implements ValidadorDeTopicos {

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosRegistroTopico datos) {
        var existe = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (existe) {
            throw new ValidacionException("Ya existe un tópico con el mismo título y mensaje");
        }
    }
}
