package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpParametrosRelacion;
import lombok.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@Stateless
public class OcpParametrosRelacionDao extends AbstractDao<OcpParametrosRelacion>
        implements Serializable {

    @Getter
    @Setter
    private Long idRelacion;

    @Getter
    @Setter
    private Long idParametro;

    @Getter
    @Setter
    private Long idSubParametro;

    @Getter
    @Setter
    private Long estadoRelacion;

    @Getter
    @Setter
    private String comentario;

    @Getter
    @Setter
    private Date fechaCreacion;

    @Getter
    @Setter
    private String usuario;

    @PersistenceContext
    private EntityManager entityManager;

    public OcpParametrosRelacionDao(EntityManager entityManager) {
        super(OcpParametrosRelacion.class);
        this.entityManager = entityManager;
    }

    public OcpParametrosRelacionDao() {
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
