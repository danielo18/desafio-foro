package desafio.api.foro.dominio.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String autor,
        String titulo,
        String mensaje,
        String curso,
        String categoria,
        int status,
        LocalDateTime fecha
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje(),topico.getCurso().getCurso(), String.valueOf(topico.getCurso().getCategoria()),topico.getStatus(), topico.getFecha());
    }
}
