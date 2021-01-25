package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpDnfHistorialDao;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.OcpDnfHistorial;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpDnfHistorialController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpDnfHistorialDao historialDao;


    public void create(OcpDnfHistorial dnf) {
        try {
            this.historialDao .setEntityManager(this.entityManager);
            this.historialDao .create(dnf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpDnfHistorial dnf ) {
        try {
            this.historialDao.setEntityManager(this.entityManager);
            this.historialDao.edit(dnf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(OcpDnfHistorial dnf ) {
        try {
            this.historialDao.setEntityManager(this.entityManager);
            this.historialDao.remove(dnf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OcpDnfHistorial> dnfHistorials() {
        List<OcpDnfHistorial> ocpDnfHistorialList = new ArrayList<>();
        try {
            ocpDnfHistorialList = this.entityManager
                    .createNamedQuery("OcpDnf_Historial.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ocpDnfHistorialList;
    }

    public OcpDnfHistorial dnfHistorialByid(Long id){
        OcpDnfHistorial dnfHistorial = new OcpDnfHistorial();
        try {
            dnfHistorial = this.entityManager
                    .createNamedQuery("OcpDnf_Historial.findById", OcpDnfHistorial.class)
                    .setParameter("id",id)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dnfHistorial;
    }
}
