package co.com.claro.ocp.dao;
import co.com.claro.ocp.entity.OcpBaseEmpleados;
import co.com.claro.ocp.entity.OcpCamposParametros;
import co.com.claro.ocp.entity.OcpParametros;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.Date;

@Stateless
public class OcpCamposParametrosDao extends AbstractDao<OcpCamposParametros>
        implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Date fechaDeCreacion;

    @Getter
    @Setter
    private String pantalla;

    @Getter
    @Setter
    private String tipoDeDato;

    @Getter
    @Setter
    private String nombreParametro;

    @Getter
    @Setter
    private String longitud;

    @Getter
    @Setter
    private String validacion;

    @Getter
    @Setter
    private String regex;

    @PersistenceContext
    private EntityManager entityManager;

    public OcpCamposParametrosDao() {
    }

    public OcpCamposParametrosDao (EntityManager entityManager) {
        super(OcpCamposParametros.class);
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
