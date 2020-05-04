package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpNovBheDao;
import co.com.claro.ocp.dao.OcpParametrosDao;
import co.com.claro.ocp.entity.OcpNovBhe;
import co.com.claro.ocp.entity.OcpNovIncLin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpNovBheController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpNovBheDao ocpNovBheDao;

    public void create(OcpNovBhe ocpNovBhe) {
        try {
            this.ocpNovBheDao.setEntityManager(this.entityManager);
            this.ocpNovBheDao.create(ocpNovBhe);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpNovBhe ocpNovBhe) {
        try{
            this.ocpNovBheDao.setEntityManager(this.entityManager);
            this.ocpNovBheDao.edit(ocpNovBhe);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(OcpNovBhe ocpNovBhe) {
        try{
            this.ocpNovBheDao.setEntityManager(this.entityManager);
            this.ocpNovBheDao.remove(ocpNovBhe);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<OcpNovBhe> mes(Long anio, Long mes ){
        List<OcpNovBhe> bhes = new ArrayList<>();
        try {
            bhes = entityManager.createNamedQuery("OcpNovBhe.findRang")
                    .setParameter("anio",anio)
                    .setParameter("mes",mes)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bhes;
    }
}
