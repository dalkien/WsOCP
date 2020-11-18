package co.com.claro.ocp.dto;

import co.com.claro.ocp.util.InformacionParametros;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class InfoParamOcpResponse {
    @Getter
    @Setter
    private List<InformacionParametros> paraDesc;

    @Getter
    @Setter
    private GenericResponse response;

}
