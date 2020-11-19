package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.NovedadesEmpleadosDao;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.OcpBaseEmpleados;
import co.com.claro.ocp.entity.OcpNovBhe;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless

public class NovedadesEmpleadosController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    NovedadesEmpleadosDao novedadesEmpleadosDao;

    public void create(NovedadesEmpleados novedades) {
        try {
            this.novedadesEmpleadosDao .setEntityManager(this.entityManager);
            this.novedadesEmpleadosDao .create(novedades);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(NovedadesEmpleados empleados ) {
        try {
            this.novedadesEmpleadosDao.setEntityManager(this.entityManager);
            this.novedadesEmpleadosDao.edit(empleados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(NovedadesEmpleados empleados ) {
        try {
            this.novedadesEmpleadosDao.setEntityManager(this.entityManager);
            this.novedadesEmpleadosDao.remove(empleados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<NovedadesEmpleados> empleados() {
        List<NovedadesEmpleados> empleados = new ArrayList<>();
        try {
            empleados = this.entityManager
                    .createNamedQuery("NovedadesEmpleados.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
