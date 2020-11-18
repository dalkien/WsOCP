package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpNovIncLin;
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
public class OcpNovIncLinDao extends AbstractDao<OcpNovIncLin>
        implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public OcpNovIncLinDao(EntityManager entityManager) {
        super(OcpNovIncLin.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Getter
    @Setter
    private Long codEmpleado;

    @Getter
    @Setter
    private Long valor;

    @Getter
    @Setter
    private Long anio;

    @Getter
    @Setter
    private Long mes;

    @Getter
    @Setter
    private Date fecCargue;

    @Getter
    @Setter
    private Long egm;

    @Getter
    @Setter
    private Long lm;

    @Getter
    @Setter
    private Long atep;

    @Getter
    @Setter
    private Long lr;

    @Getter
    @Setter
    private Long lnr;

    @Getter
    @Setter
    private Long luto;

    @Getter
    @Setter
    private Long paternidad;

    @Getter
    @Setter
    private Long sanciones;

    @Getter
    @Setter
    private String usuario;

}
