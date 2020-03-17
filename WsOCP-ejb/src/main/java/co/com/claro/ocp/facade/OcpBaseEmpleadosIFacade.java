package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpBaseEmpleados;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpBaseEmpleadosIFacade  {


    public List<OcpBaseEmpleados> allEmpleados();

    public void creaEmpleado(OcpBaseEmpleados empleado);

    public void actualizaEmpleado(OcpBaseEmpleados empleado);

    public OcpBaseEmpleados getEmpleado(Long codEmpleado);
}
