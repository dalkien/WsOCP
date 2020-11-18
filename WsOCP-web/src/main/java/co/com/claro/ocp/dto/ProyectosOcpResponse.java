package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.OcpProyecto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ProyectosOcpResponse {
    @Getter
    @Setter
    private List<OcpProyecto> proyectos;

    @Getter
    @Setter
    private GenericResponse response;

    public ProyectosOcpResponse() {
    }

    public ProyectosOcpResponse(List<OcpProyecto> proyectos, GenericResponse response) {
        this.proyectos = proyectos;
        this.response = response;
    }
}
