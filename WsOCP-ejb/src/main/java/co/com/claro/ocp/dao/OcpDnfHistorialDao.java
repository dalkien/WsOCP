package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpDnfHistorial;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@Stateless
public class OcpDnfHistorialDao extends AbstractDao<OcpDnfHistorial> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public OcpDnfHistorialDao(Class<OcpDnfHistorial> entityClass, EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public OcpDnfHistorialDao(){}

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String objDnf;

    @Getter @Setter
    private Date fechaCreacion;

    @Getter @Setter
    private String usuarioCreacion;

    @Getter @Setter
    private Date FechaUltMod;

    @Getter @Setter
    private String usuarioUltMod;

    @Getter @Setter
    private String obsevaciones;

}
