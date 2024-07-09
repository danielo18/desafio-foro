package desafio.api.foro.dominio.topicos;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private String curso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    public Curso actualizar(Curso curso) {
        this.categoria=curso.getCategoria();
        this.curso=curso.getCurso();
        return this;
    }
}
