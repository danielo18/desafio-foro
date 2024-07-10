package desafio.api.foro.controller;

import desafio.api.foro.dominio.topicos.*;
import desafio.api.foro.infra.errores.ValidacionDeIntegridad;
import desafio.api.foro.infra.errores.ValidarDuplicidad;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    ValidarTopicoService servicio;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) throws ValidarDuplicidad {

        System.out.println(datosTopico);
        servicio.validarDatos(datosTopico);

        servicio.validarDuplicidad(datosTopico.titulo(),datosTopico.mensaje());

        Topico topico = topicoRepository.save(new Topico(datosTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje(),topico.getCurso().getCurso(),String.valueOf(topico.getCurso().getCategoria()),topico.getStatus(), topico.getFecha());

        URI url = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listadoTopicos(@PageableDefault(size=10) Pageable paginacion){
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosRespuestaTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DatosRespuestaTopico>> topicoDetallado(@PathVariable Long id){
        if(!topicoRepository.findById(id).isPresent()){
            throw new ValidacionDeIntegridad("este id de topico no fue encontrado");
        }

        return ResponseEntity.ok(topicoRepository.findById(id).map(DatosRespuestaTopico::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<DatosRespuestaTopico>> actualizarTopico(@RequestBody @Valid DatosTopico datosTopico, @PathVariable Long id ){
        if(!topicoRepository.findById(id).isPresent()){
            throw new ValidacionDeIntegridad("este id de topico no fue encontrado");
        }

        Topico topico= topicoRepository.getReferenceById(id);
        topico.actualizar(datosTopico);
        return ResponseEntity.ok(Optional.of(new DatosRespuestaTopico(topico.getId(), topico.getAutor(),
                topico.getTitulo(), topico.getMensaje(), topico.getCurso().getCurso(),
                String.valueOf(topico.getCurso().getCategoria()), topico.getStatus(), topico.getFecha())));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        if(!topicoRepository.findById(id).isPresent()){
            throw new ValidacionDeIntegridad("este id de topico no fue encontrado");
        }
            Topico topico = topicoRepository.getReferenceById(id);
            topico.eliminar();

        return ResponseEntity.noContent().build();
    }
}
