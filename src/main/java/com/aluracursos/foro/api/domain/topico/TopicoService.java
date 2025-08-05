package com.aluracursos.foro.api.domain.topico;

import jakarta.transaction.Transactional;
import com.aluracursos.foro.api.domain.curso.CursoRepository;
import com.aluracursos.foro.api.domain.topico.dto.*;
import com.aluracursos.foro.api.domain.usuario.UsuarioRepository;
import com.aluracursos.foro.api.domain.ValidacionException;
import com.aluracursos.foro.api.domain.topico.validaciones.ValidadorDeTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    @Transactional
    public DatosDetalleTopico registrar(DatosRegistroTopico datos) {
        validadores.forEach(v -> v.validar(datos));

        var autor = usuarioRepository.findById(datos.idAutor())
                .orElseThrow(() -> new ValidacionException("Autor no encontrado"));
        var curso = cursoRepository.findById(datos.idCurso())
                .orElseThrow(() -> new ValidacionException("Curso no encontrado"));

        var topico = new Topico(null, datos.titulo(), datos.mensaje(), null, null, autor, curso, null);
        topicoRepository.save(topico);

        return new DatosDetalleTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                autor.getNombre(),
                curso.getNombre()
        );
    }

    public Page<DatosListadoTopico> listar(Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    public DatosDetalleTopico detalle(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("Tópico no encontrado"));

        return new DatosDetalleTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

    @Transactional
    public void actualizar(DatosActualizarTopico datos) {
        var topico = topicoRepository.findById(datos.id())
                .orElseThrow(() -> new ValidacionException("Tópico no encontrado"));

        if (datos.titulo() != null) topico.setTitulo(datos.titulo());
        if (datos.mensaje() != null) topico.setMensaje(datos.mensaje());
    }

    @Transactional
    public void eliminar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("Tópico no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
