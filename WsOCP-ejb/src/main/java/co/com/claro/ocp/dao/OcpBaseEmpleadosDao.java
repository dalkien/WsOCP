package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpBaseEmpleados;
import lombok.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@Stateless
public class OcpBaseEmpleadosDao extends AbstractDao<OcpBaseEmpleados>
        implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;
    public OcpBaseEmpleadosDao(){}

    public OcpBaseEmpleadosDao(EntityManager entityManager){
        super(OcpBaseEmpleados.class);
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
    private Long cedula;

    @Getter @Setter
    private String nombres;

    @Getter @Setter
    private Date fehcaIngrero;

    @Getter @Setter
    private String ingRet;

    @Getter @Setter
    private String tipoContrato;

    @Getter @Setter
    private String rol;

    @Getter @Setter
    private String tipoSalario;

    @Getter @Setter
    private Long salario;

    @Getter @Setter
    private Long beneficio;

    @Getter @Setter
    private Long equipo;

    @Getter @Setter
    private String descuento;

    @Getter @Setter
    private Long salarioTotal;

    @Getter @Setter
    private Long costoEstMes;

    @Getter @Setter
    private String observaciones;

    @Getter @Setter
    private Date fecCargue;

    @Getter @Setter
    private String usuario;

}
