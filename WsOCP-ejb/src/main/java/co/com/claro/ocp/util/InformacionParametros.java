package co.com.claro.ocp.util;

import lombok.Getter;
import lombok.Setter;

public class InformacionParametros {

    @Getter @Setter
    private Long parametro;

    @Getter @Setter
    private Long subparametro;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String comentario;

    public InformacionParametros() {
    }

    public InformacionParametros(Long parametro, Long subparametro, String nombre, String comentario) {
        this.parametro = parametro;
        this.subparametro = subparametro;
        this.nombre = nombre;
        this.comentario = comentario;
    }
}
