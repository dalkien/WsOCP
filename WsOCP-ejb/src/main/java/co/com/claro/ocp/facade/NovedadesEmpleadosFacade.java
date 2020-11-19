package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.NovedadesEmpleadosController;
import co.com.claro.ocp.entity.NovedadesEmpleados;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class NovedadesEmpleadosFacade implements NovedadesEmpleadosIFacade{

    @EJB
    NovedadesEmpleadosController novedades;

    @Override
    public List<NovedadesEmpleados> allNovedadEmpleados() {
        return this.novedades.empleados();
    }

    @Override
    public void crearNovedadEmp(NovedadesEmpleados novedad) {
        this.novedades.create(novedad);
    }

    @Override
    public void actualizaNovedadEmp(NovedadesEmpleados novedad) {
        this.novedades.edit(novedad);
    }
}
