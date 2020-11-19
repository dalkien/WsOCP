package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.NovedadesProyectosController;
import co.com.claro.ocp.entity.NovedadesProyectos;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class NovedadesProyectosFacade implements NovedadesProyectosIFacade {
    private static final long serialVersionUID = 1L;

    @EJB
    NovedadesProyectosController novedades;

    @Override
    public List<NovedadesProyectos> allNovedadesP() {
        return this.novedades.allNovedadesP();
    }

    @Override
    public void creaNovedadProyecto(NovedadesProyectos novedad) {
        this.novedades.create(novedad);
    }

    @Override
    public void actuaizaNovedadProyecto(NovedadesProyectos novedad) {
        this.novedades.edit(novedad);
    }
}
