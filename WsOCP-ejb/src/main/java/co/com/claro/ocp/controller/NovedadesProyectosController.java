package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.NovedadesEmpleadosDao;
import co.com.claro.ocp.dao.NovedadesProyectosDao;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.NovedadesProyectos;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class NovedadesProyectosController {
    @PersistenceContext (unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    NovedadesProyectosDao novedadesProyectosDao;

    public void create(NovedadesProyectos novedadesp ) {
        try {
            this.novedadesProyectosDao .setEntityManager(this.entityManager);
            this.novedadesProyectosDao .create(novedadesp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void edit(NovedadesProyectos novedadesp ) {
        try {
            this.novedadesProyectosDao.setEntityManager(this.entityManager);
            this.novedadesProyectosDao.edit(novedadesp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(NovedadesProyectos novedadesp ) {
        try {
            this.novedadesProyectosDao.setEntityManager(this.entityManager);
            this.novedadesProyectosDao.remove(novedadesp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<NovedadesProyectos> allNovedadesP() {
        List novedadesp = new ArrayList<>();
        try {
            novedadesp = this.entityManager
                    .createNamedQuery("NovedadesProyectos.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return novedadesp;
    }
}
