package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpBaseEmpleadosDao;
import co.com.claro.ocp.entity.OcpBaseEmpleados;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Stateless
public class OcpBaseEmpleadosController {

    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpBaseEmpleadosDao baseEmpleadosDao;

    public void create(OcpBaseEmpleados empleado) {
        try {
            this.baseEmpleadosDao.setEntityManager(this.entityManager);
            this.baseEmpleadosDao.create(empleado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpBaseEmpleados empleado) {
        try{
            this.baseEmpleadosDao.setEntityManager(this.entityManager);
            this.baseEmpleadosDao.edit(empleado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(OcpBaseEmpleados empleado) {
        try{
            this.baseEmpleadosDao.setEntityManager(this.entityManager);
            this.baseEmpleadosDao.remove(empleado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<OcpBaseEmpleados> allEmpleados(){
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        try{
            empleados = this.entityManager
                    .createNamedQuery("OcpBaseEmpleados.findAll")
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
    }
        return empleados;
    }

    public OcpBaseEmpleados empleadoByCodEmpleado(Long codEmpleado){
        OcpBaseEmpleados empleado = new OcpBaseEmpleados();
        try{
            empleado =  this.entityManager
                    .createNamedQuery("OcpBaseEmpleados.findByCodEmpleado",OcpBaseEmpleados.class)
                    .setParameter("codEmpleado",codEmpleado)
                    .getSingleResult();
        }catch (Exception e){ e.printStackTrace();}
        return empleado;
    }

    public List<OcpBaseEmpleados> allEmpleadosByProject(List<Long> ids){
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        try{
            empleados = this.entityManager
                    .createNamedQuery("OcpBaseEmpleados.findListByProject")
                    .setParameter("valores",ids )
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return empleados;
    }
}
