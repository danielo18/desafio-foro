package desafio.api.foro.dominio.topicos;

import desafio.api.foro.infra.errores.ValidacionDatos;
import desafio.api.foro.infra.errores.ValidacionDeIntegridad;
import desafio.api.foro.infra.errores.ValidarDuplicidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidarTopicoService {
    @Autowired
    private TopicoRepository repository;
    private int validador=0;


    public void validarDatos(DatosTopico datosTopico) {
        if (datosTopico.titulo()==null|| datosTopico.titulo().isBlank()){
            throw new ValidacionDatos("debes de proporcionar el titulo del topico ");
        }
        if (datosTopico.mensaje()==null|| datosTopico.mensaje().isBlank()){
            throw new ValidacionDatos("debes de proporcionar el mensaje del topico ");
        }
        if (datosTopico.fecha()==null){
            throw new ValidacionDatos("debes de proporcionar la fecha del topico ");
        }
        if (datosTopico.autor()==null|| datosTopico.autor().isBlank()){
            throw new ValidacionDatos("debes de proporcionar el autor del topico ");
        }
        if (datosTopico.curso().getCurso()==null|| datosTopico.curso().getCurso().isBlank()){
            throw new ValidacionDatos("debes de proporcionar el nombre del curso del topico ");
        }
        if (datosTopico.curso().getCategoria()==null){
            throw new ValidacionDatos("debes de proporcionar la categoria del topico ");
        }
    }

    public void  validarDuplicidad(String titulo, String mensaje) throws ValidarDuplicidad {
       validador=0;
        List<Topico> topicos=repository.findAll();
        for (Topico to : topicos) {
            if (to.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
                throw new ValidarDuplicidad("Este titulo ya esta en un topico");
            }
            if (to.getMensaje().toLowerCase().equals(mensaje.toLowerCase())) {
                throw new ValidarDuplicidad("Este mensaje ya esta en un topico");

            }
        }

    }
}
