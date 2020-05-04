package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpNovOtrosDao;
import co.com.claro.ocp.dao.OcpParametrosDao;
import co.com.claro.ocp.entity.OcpNovOtros;
import co.com.claro.ocp.entity.OcpProyecto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpNovOtrosController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpNovOtrosDao ocpNovOtrosDao;

    public void create(OcpNovOtros ocpNovOtros) {
        try {
            this.ocpNovOtrosDao.setEntityManager(this.entityManager);
            this.ocpNovOtrosDao.create(ocpNovOtros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpNovOtros ocpNovOtros) {
        try{
            this.ocpNovOtrosDao.setEntityManager(this.entityManager);
            this.ocpNovOtrosDao.edit(ocpNovOtros);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(OcpNovOtros ocpNovOtros) {
        try{
            this.ocpNovOtrosDao.setEntityManager(this.entityManager);
            this.ocpNovOtrosDao.remove(ocpNovOtros);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<OcpNovOtros> mes(Long anio, Long mes ){
        List<OcpNovOtros> otros = new ArrayList<>();
        try {
            otros = entityManager.createNamedQuery("OcpNovOtros.findRang")
                    .setParameter("anio", anio)
                    .setParameter("mes", mes)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return otros;
    }
}
