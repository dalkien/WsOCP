package co.com.claro.ocp.controller;

import co.com.claro.ocp.dao.OcpParametrosRelacionDao;
import co.com.claro.ocp.entity.OcpParametrosRelacion;
import co.com.claro.ocp.util.InformacionParametros;
import co.com.claro.ocp.util.ListasParametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
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

    private final String QUERY_PARAMETROS = "select a.ID_PARAMETRO parametro, a.ID_SUB_PARAMETRO subparametro , " +
            "(select OCP_PARAMETROS.NOMBRE_PARAMETRO from OCP_PARAMETROS where a.ID_SUB_PARAMETRO = OCP_PARAMETROS.ID_PARAMETRO ) nombre  , " +
            "(select OCP_PARAMETROS.COMENTARIOS from OCP_PARAMETROS where a.ID_SUB_PARAMETRO = OCP_PARAMETROS.ID_PARAMETRO ) comentario " +
            "from OCP_PARAMETROS_RELACION a,  OCP_PARAMETROS b  " +
            "where b.ID_PARAMETRO = a.ID_RELACION ";
//            "where b.ID_PARAMETRO = a.ID_RELACION and a.ID_PARAMETRO = ?";

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
//            subParametetros = this.entityManager
            List<Object[]> subParam = this.entityManager
                    .createNativeQuery(QUERY_DISTINCT).getResultList();
            for (Object[] result : subParam) {
                BigDecimal val1 = (BigDecimal) result[0];
                Long val2 = val1.longValue();
                ListasParametros subparame =  new ListasParametros(val2 , (String) result[1]);
                subParametetros.add(subparame);
            }

        }catch (Exception e){e.printStackTrace();}
        return subParametetros;
    }

    public List<InformacionParametros> infParameters(Long valor){
        List<InformacionParametros> subParametetros = new ArrayList<>();
        try{
            List<Object[]> subPara = this.entityManager
                    .createNativeQuery(QUERY_PARAMETROS)
//                    .setParameter(1,valor)
                    .getResultList();
            for ( Object[] result : subPara) {
                BigDecimal val1 = (BigDecimal) result[0] ;
                BigDecimal val2 = (BigDecimal) result[1] ;
                InformacionParametros subParame = new InformacionParametros(val1.longValue(),val2.longValue(),
                        (String) result[2], (String) result[3]);
                subParametetros.add(subParame);
            }
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
