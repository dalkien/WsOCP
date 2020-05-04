package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpBaseEmpleados;
import co.com.claro.ocp.entity.OcpNovOtros;
import lombok.AllArgsConstructor;
import lombok.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Stateless
public class OcpNovOtrosDao extends AbstractDao<OcpNovOtros> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public OcpNovOtrosDao(EntityManager entityManager){
        super(OcpNovOtros.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Getter @Setter
    private Long codEmpleado;

    @Getter @Setter
    private Long tipo;

    @Getter @Setter
    private Long valor;

    @Getter @Setter
    private Long anio;

    @Getter @Setter
    private Long mes;

    @Getter @Setter
    private String comentarios;

    @Getter @Setter
    private Date fecCargue;

    @Getter @Setter
    private String usuario;

}
