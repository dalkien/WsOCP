package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpParametrosDao;
import co.com.claro.ocp.entity.OcpParametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpParametrosController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpParametrosDao parametrosDao;

    public void create(OcpParametros parametro) {
        try {
            this.parametrosDao.setEntityManager(this.entityManager);
            this.parametrosDao.create(parametro);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpParametros parametro) {
        try {
            this.parametrosDao.setEntityManager(this.entityManager);
            this.parametrosDao.edit(parametro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(OcpParametros parametro) {
        try {
            this.parametrosDao.setEntityManager(this.entityManager);
            this.parametrosDao.remove(parametro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OcpParametros> allParameters() {
        List<OcpParametros> parametros = new ArrayList<>();
        try {
            parametros = this.entityManager
                    .createNamedQuery("OcpParametros.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parametros;
    }

    public OcpParametros parameterById(Long id) {
        OcpParametros parametro = new OcpParametros();
        try {
            parametro = this.entityManager
                    .createNamedQuery("OcpParametros.findByidParametro", OcpParametros.class)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parametro;
    }

    public List<OcpParametros> listParameters(List<Long> subParam) {
        List<OcpParametros> listParametros = new ArrayList<>();
        try {
            listParametros = this.entityManager
                    .createNamedQuery("OcpParametros.findByRange")
                    .setParameter("valores", subParam)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listParametros;
    }

    public OcpParametros findParam(String param) {
        OcpParametros parametros = new OcpParametros();
        try {
            parametros = (OcpParametros) this.entityManager
                    .createNamedQuery("OcpParametros.findByName")
                    .setParameter("nombreParametro", param)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parametros;
    }

}
