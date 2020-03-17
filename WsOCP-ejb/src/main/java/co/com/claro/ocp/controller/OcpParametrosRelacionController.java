package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpParametrosRelacionDao;
import co.com.claro.ocp.entity.OcpParametrosRelacion;
import co.com.claro.ocp.util.ListasParametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpParametrosRelacionController {

    @PersistenceContext(unitName = "OCPConnexion")
    private EntityManager entityManager;

    @EJB
    OcpParametrosRelacionDao parametrosRelacionDao;

    private final String QUERY_DISTINCT = "select distinct(a.id_parametro), "+
                                  "b.nombre_parametro from ocp_parametros_relacion a,  ocp_parametros b  "+
                                  "where a.id_parametro = b.id_parametro  order by  a.id_parametro";

    public void create(OcpParametrosRelacion parametro) {
        try {
            this.parametrosRelacionDao.setEntityManager(this.entityManager);
            this.parametrosRelacionDao.create(parametro);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void edit(OcpParametrosRelacion parametro) {
        try{
            this.parametrosRelacionDao.setEntityManager(this.entityManager);
            this.parametrosRelacionDao.edit(parametro);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(OcpParametrosRelacion parametro) {
        try{
            this.parametrosRelacionDao.setEntityManager(this.entityManager);
            this.parametrosRelacionDao.remove(parametro);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ListasParametros> listSubParameters(){
        List<ListasParametros> subParametetros = new ArrayList<>();
        try{
            subParametetros = this.entityManager
                    .createNativeQuery(QUERY_DISTINCT,ListasParametros.class).getResultList();
        }catch (Exception e){e.printStackTrace();}
        return subParametetros;
    }

    public List<OcpParametrosRelacion> allParamRelations(){
        List<OcpParametrosRelacion> relacions = new ArrayList<>();
        try {
            relacions = this.entityManager
                    .createNamedQuery("OcpParametrosRelacion.findAll")
                    .getResultList();
        }catch (Exception e){e.printStackTrace();}
        return relacions;
    }

    public OcpParametrosRelacion paramRelationsbyId(Long id){
        OcpParametrosRelacion relacions = new OcpParametrosRelacion();
        try {
            relacions = this.entityManager
                    .createNamedQuery("OcpParametrosRelacion.findByidParametro", OcpParametrosRelacion.class)
                    .setParameter("idParametro", id)
                    .getSingleResult();
        }catch (Exception e){e.printStackTrace();}
        return relacions;
    }

}
