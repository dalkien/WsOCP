package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.OcpCamposParametros;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class OcpCamposParamResponse {

    @Getter @Setter
    List<OcpCamposParametros> parametros ;

    @Getter @Setter
    GenericResponse response;
}
