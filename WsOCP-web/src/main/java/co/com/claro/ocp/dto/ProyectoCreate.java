package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.OcpProyecto;
import lombok.Getter;
import lombok.Setter;

public class ProyectoCreate {
    @Getter
    @Setter
    private OcpProyecto proyecto;

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Setter
    private String ocContrato;

    @Getter
    @Setter
    private String ocNumContrato;

    public ProyectoCreate() {
    }

    public ProyectoCreate(OcpProyecto proyecto, String descripcion, String ocContrato, String ocNumContrato) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.ocContrato = ocContrato;
        this.ocNumContrato = ocNumContrato;
    }

}
