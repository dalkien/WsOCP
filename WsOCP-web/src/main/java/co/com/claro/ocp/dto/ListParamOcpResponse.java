package co.com.claro.ocp.dto;

import co.com.claro.ocp.util.ListasParametros;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListParamOcpResponse {
    @Getter
    @Setter
    private List<ListasParametros> parametos;

    @Getter
    @Setter
    private GenericResponse response;

    public ListParamOcpResponse() {
    }

    public ListParamOcpResponse(List<ListasParametros> parametos, GenericResponse response) {
        this.parametos = parametos;
        this.response = response;
    }
}
