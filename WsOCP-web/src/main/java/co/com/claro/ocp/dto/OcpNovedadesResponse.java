package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class OcpNovedadesResponse {

    @Getter @Setter
    private Long codigo;

    @Getter @Setter
    private String tipo;

    @Getter @Setter
    private List<OcpNovBhe> novBhes;

    @Getter @Setter
    private List<OcpNovIncLin> novIncLins;

    @Getter @Setter
    private List<OcpNovOtros> novOtros;
    @Getter @Setter
    private OcpBaseEmpleados empleado;
    @Getter @Setter
    private OcpProyecto proyectos;
    @Getter @Setter
    private OcpParametros desProyecto;

//    @Getter @Setter
//    private GenericResponse response;

}
