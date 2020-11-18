package co.com.claro.ocp.controller;


import co.com.claro.ocp.dao.OcpProyectoDao;
import co.com.claro.ocp.entity.OcpProyecto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpProyectoController {

    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpProyectoDao proyectoDao;

    public void create(OcpProyecto proyecto) {
        try {
            this.proyectoDao.setEntityManager(this.entityManager);
            this.proyectoDao.create(proyecto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpProyecto proyecto) {
        try {
            this.proyectoDao.setEntityManager(this.entityManager);
            this.proyectoDao.edit(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(OcpProyecto proyecto) {
        try {
            this.proyectoDao.setEntityManager(this.entityManager);
            this.proyectoDao.remove(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OcpProyecto> allProyectos() {
        List<OcpProyecto> proyectos = new ArrayList<>();
        try {
            proyectos = this.entityManager
                    .createNamedQuery("OcpProyecto.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proyectos;
    }

    public OcpProyecto proyectoById(Long id) {
        OcpProyecto proyecto = new OcpProyecto();
        try {
            proyecto = this.entityManager
                    .createNamedQuery("OcpProyecto.findByCodProyecto", OcpProyecto.class)
                    .setParameter("codProyecto", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proyecto;
    }

}
