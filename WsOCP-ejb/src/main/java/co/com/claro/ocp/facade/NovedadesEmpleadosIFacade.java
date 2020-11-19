package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.NovedadesEmpleados;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NovedadesEmpleadosIFacade {

    List<NovedadesEmpleados> allNovedadEmpleados();

    void crearNovedadEmp(NovedadesEmpleados novedad);

    void actualizaNovedadEmp(NovedadesEmpleados novedad);
}
