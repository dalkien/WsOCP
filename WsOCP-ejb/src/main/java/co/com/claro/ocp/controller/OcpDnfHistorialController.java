package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpDnfHistorialDao;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.OcpDnfHistorial;
import com.google.gson.Gson;

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
            Object obj =  this.entityManager
                    .createNamedQuery("OcpDnf_Historial.findById")
                    .setParameter("id",id)
                    .getSingleResult();
            Gson gson = new Gson();
            String objCad = gson.toJson(obj);
            dnfHistorial = gson.fromJson(objCad,OcpDnfHistorial.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dnfHistorial;
    }
}
