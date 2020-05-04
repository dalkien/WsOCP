package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpNovBhe;
import co.com.claro.ocp.entity.OcpNovIncLin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor

@Stateless
public class OcpNovBheDao extends AbstractDao<OcpNovBhe>
        implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public OcpNovBheDao(EntityManager entityManager){
        super(OcpNovBhe.class);
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
    private Long idProyecto;

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
