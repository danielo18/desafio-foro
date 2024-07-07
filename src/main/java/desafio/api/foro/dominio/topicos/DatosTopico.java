package desafio.api.foro.dominio.topicos;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosTopico(

        String titulo,

        String mensaje,

        LocalDateTime fecha,

        String autor,

        Curso curso

) {

}
