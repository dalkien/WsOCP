package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.OcpNovBhe;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Stateless
public class NovedadesEmpleadosDao  extends AbstractDao<NovedadesEmpleados>
        implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;

    public NovedadesEmpleadosDao( EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public NovedadesEmpleadosDao(){}

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
    private String codigo;

    @Getter @Setter
    private Long cedula;


    @Getter @Setter
    private String empleado;

    @Getter @Setter
    private  Long idProyecto;

    @Getter @Setter
    private String proyecto;

    @Getter @Setter
    private String estadoProyecto;

    @Getter @Setter
    private String gerenteSquad;

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    private Long vacaciones;

    @Getter @Setter
    private Long ausencias;

    @Getter @Setter
    private String observaciones;

    @Getter @Setter
    private Long bonos;

    @Getter @Setter
    private Long horasExtras;

    @Getter @Setter
    private Long otrosCostos;




}
