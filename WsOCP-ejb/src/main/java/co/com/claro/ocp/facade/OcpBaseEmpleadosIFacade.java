package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpBaseEmpleados;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpBaseEmpleadosIFacade {


    List<OcpBaseEmpleados> allEmpleados();

    void creaEmpleado(OcpBaseEmpleados empleado);

    void actualizaEmpleado(OcpBaseEmpleados empleado);

    OcpBaseEmpleados getEmpleado(Long codEmpleado);

    List<OcpBaseEmpleados> allEmpleadosByProject(List<Long> ids);
}
