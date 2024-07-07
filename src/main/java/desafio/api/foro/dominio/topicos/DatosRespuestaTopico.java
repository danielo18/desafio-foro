package desafio.api.foro.dominio.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String autor,
        String titulo,
        String mensaje,
        LocalDateTime fecha
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje(), topico.getFecha());
    }
}
