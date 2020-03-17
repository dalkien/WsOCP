package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.OcpBaseEmpleados;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class EmpleadosOcpResponse {

    @Getter @Setter
    private GenericResponse response;

    @Getter @Setter
    private List<OcpBaseEmpleados> empleados;

    public EmpleadosOcpResponse() {
    }

    public EmpleadosOcpResponse(GenericResponse response, List<OcpBaseEmpleados> empleados) {
        this.response = response;
        this.empleados = empleados;
    }
}
