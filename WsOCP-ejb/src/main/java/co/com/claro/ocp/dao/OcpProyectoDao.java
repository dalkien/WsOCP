package co.com.claro.ocp.dao;

import co.com.claro.ocp.entity.OcpProyecto;
import lombok.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@Stateless
public class OcpProyectoDao extends AbstractDao<OcpProyecto> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;
    public OcpProyectoDao(){}

    public OcpProyectoDao(EntityManager entityManager){
        super(OcpProyecto.class);
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
    private Long codProyecto;

    @Getter @Setter
    private Long idCliente;

    @Getter @Setter
    private String alcance;

    @Getter @Setter
    private Date fechaInicio;

    @Getter @Setter
    private Long duracion;

    @Getter @Setter
    private Date fechaFin;

    @Getter @Setter
    private Long idMoneda;

    @Getter @Setter
    private Long valorFormalHost;

    @Getter @Setter
    private Long idTipoTarifa;

    @Getter @Setter
    private Long valorTarifa;

    @Getter @Setter
    private Long valorTarifa2;

    @Getter @Setter
    private Long valorTarifa3;

    @Getter @Setter
    private Long idEstadoProyecto;

    @Getter @Setter
    private Long idCategoria;

    @Getter @Setter
    private Long idDireccion;

    @Getter @Setter
    private Long idLineaNegocio;

    @Getter @Setter
    private Long idTipoProyecto;

    @Getter @Setter
    private Long idServicio;

    @Getter @Setter
    private Long idTipoServicio;

    @Getter @Setter
    private Long idDirector;

    @Getter @Setter
    private Long idGerente;

    @Getter @Setter
    private Long idTipoAlianza;

    @Getter @Setter
    private Long idClasificacionVenta;

    @Getter @Setter
    private Long costoPlaneado;

    @Getter @Setter
    private Long margenPlanaedo;

    @Getter @Setter
    private Long ftePlaneado;

    @Getter @Setter
    private Long factorICA;

    @Getter @Setter
    private Long factorProvIndem;

    @Getter @Setter
    private String comentarios;

    @Getter @Setter
    private Date fecCargue;

    @Getter @Setter
    private String usuario;
}
