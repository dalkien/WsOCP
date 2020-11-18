package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpNovIncLinDao;
import co.com.claro.ocp.dao.OcpParametrosDao;
import co.com.claro.ocp.entity.OcpNovIncLin;
import co.com.claro.ocp.entity.OcpNovOtros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpNovIncLinController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpNovIncLinDao ocpNovIncLinDao;

    public void create(OcpNovIncLin ocpNovIncLin) {
        try {
            this.ocpNovIncLinDao.setEntityManager(this.entityManager);
            this.ocpNovIncLinDao.create(ocpNovIncLin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpNovIncLin ocpNovIncLin) {
        try {
            this.ocpNovIncLinDao.setEntityManager(this.entityManager);
            this.ocpNovIncLinDao.edit(ocpNovIncLin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(OcpNovIncLin ocpNovIncLin) {
        try {
            this.ocpNovIncLinDao.setEntityManager(this.entityManager);
            this.ocpNovIncLinDao.remove(ocpNovIncLin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OcpNovIncLin> mes(Long anio, Long mes) {
        List<OcpNovIncLin> incLins = new ArrayList<>();
        try {
            incLins = entityManager.createNamedQuery("OcpNovIncLin.findRang")
                    .setParameter("anio", anio)
                    .setParameter("mes", mes)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incLins;
    }
}
