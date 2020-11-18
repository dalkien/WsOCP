package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpBaseEmpleados;
import co.com.claro.ocp.entity.OcpParametros;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@Stateless
public class OcpParametrosDao extends AbstractDao<OcpParametros>
        implements Serializable {

    @Getter
    @Setter
    private Long idParametro;

    @Getter
    @Setter
    private String nombreParametro;

    @Getter
    @Setter
    private Long estadoParametro;

    @Getter
    @Setter
    private Date fecCreacion;

    @Getter
    @Setter
    private String comentarios;

    @Getter
    @Setter
    private Long tipoParametro;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private Long valor1;

    @Getter
    @Setter
    private String valor2;

    @PersistenceContext
    private EntityManager entityManager;

    public OcpParametrosDao() {
    }

    public OcpParametrosDao(EntityManager entityManager) {
        super(OcpParametros.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
