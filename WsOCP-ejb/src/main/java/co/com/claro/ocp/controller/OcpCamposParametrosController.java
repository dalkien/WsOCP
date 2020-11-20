package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpCamposParametrosDao;
import co.com.claro.ocp.entity.OcpBaseEmpleados;
import co.com.claro.ocp.entity.OcpCamposParametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpCamposParametrosController {
    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpCamposParametrosDao campos;

    public void create(OcpCamposParametros parametros) {
        try {
            this.campos.setEntityManager(this.entityManager);
            this.campos.create(parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpCamposParametros parametros) {
        try {
            this.campos.setEntityManager(this.entityManager);
            this.campos.edit(parametros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(OcpCamposParametros parametros) {
        try {
            this.campos.setEntityManager(this.entityManager);
            this.campos.remove(parametros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OcpCamposParametros> allCamposParam() {
        List<OcpCamposParametros> param = new ArrayList<>();
        try {
            param = this.entityManager
                    .createNamedQuery("OcpCamposParametros.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }

    public OcpCamposParametros camposParametrosById(Long id){
        OcpCamposParametros param = new OcpCamposParametros();
        try {
            param = this.entityManager
                    .createNamedQuery("OcpCamposParametros.findById",OcpCamposParametros.class)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return param;
    }
}
