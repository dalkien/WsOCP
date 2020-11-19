package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.NovedadesProyectos;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NovedadesProyectosIFacade {

    List<NovedadesProyectos> allNovedadesP();

    void creaNovedadProyecto(NovedadesProyectos novedad);

    void actuaizaNovedadProyecto(NovedadesProyectos novedad);
}
