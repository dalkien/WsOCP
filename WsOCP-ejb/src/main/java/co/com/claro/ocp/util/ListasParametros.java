package co.com.claro.ocp.util;

import lombok.Getter;
import lombok.Setter;

public class ListasParametros {

    @Getter
    @Setter
    private Long parameter;

    @Getter
    @Setter
    private String descripParameter;

    public ListasParametros() {
    }

    public ListasParametros(Long parameter, String descripParameter) {
        this.parameter = parameter;
        this.descripParameter = descripParameter;
    }
}
