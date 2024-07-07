package desafio.api.foro.dominio.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Table(name="topicos")
@Entity(name="Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private int status;
    private String autor;
    @Embedded
    private Curso curso;


    public Topico(DatosTopico datosTopico) {
        this.titulo =datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fecha = datosTopico.fecha();
        this.status =1;
        this.autor = datosTopico.autor();
        this.curso = new Curso(datosTopico.curso().getCurso(),datosTopico.curso().getCategoria());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }
}
