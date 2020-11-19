package co.com.claro.ocp.dao;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.NovedadesProyectos;
import co.com.claro.ocp.entity.OcpNovBhe;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.Date;

@Stateless
public class NovedadesProyectosDao  extends AbstractDao<NovedadesProyectos>
        implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public NovedadesProyectosDao( EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public NovedadesProyectosDao(){}

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
    private String proyecto;

    @Getter @Setter
    private String estadoDeproyecto;

    @Getter @Setter
    private String gerenteSquad;

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    private Long datacenter;

    @Getter @Setter
    private Long equipos;

    @Getter @Setter
    private Long taxis;

    @Getter @Setter
    private Long cajaMenor;

    @Getter @Setter
    private Long celulares;

    @Getter @Setter
    private Long examenMedico;

    @Getter @Setter
    private Long bonosGtes;

    @Getter @Setter
    private Long licencias365Usd;

    @Getter @Setter
    private String columnasAlternativas;

    @Getter @Setter
    private Date fechaCreacion;

    @Getter @Setter
    private Long licencias365Cops;

}
