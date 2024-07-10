package desafio.api.foro.infra.errores;

public class ValidacionDatos extends NullPointerException {
    public ValidacionDatos(String s) {
        super(s);
    }
}
