package co.com.claro.ocp.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCP_PROYECTO")
@NamedQueries({
        @NamedQuery(name = "OcpProyecto.findAll", query = "SELECT q FROM OcpProyecto q ")
        ,@NamedQuery(name = "OcpProyecto.findByCodProyecto", query = "SELECT q FROM OcpProyecto q " +
                            "WHERE q.codProyecto = :codProyecto")
})
public class OcpProyecto {

    @Id
    @Column( name = "COD_PROYECTO", nullable = false)
    @Getter @Setter
    private Long codProyecto;

    @Column( name = "ID_CLIENTE", nullable = false)
    @Getter @Setter
    private Long idCliente;

    @Column( name = "ALCANCE", nullable = false)
    @Getter @Setter
    private String alcance;

    @Column( name = "FECHA_INICIO", nullable = false)
    @Getter @Setter
    private Date fechaInicio;

    @Column( name = "DURACION", nullable = false)
    @Getter @Setter
    private Long duracion;

    @Column( name = "FECHA_FIN", nullable = false)
    @Getter @Setter
    private Date fechaFin;

    @Column( name = "ID_MONEDA", nullable = false)
    @Getter @Setter
    private Long idMoneda;

    @Column( name = "VALOR_FORMAL_HOST", nullable = false)
    @Getter @Setter
    private Long valorFormalHost;

    @Column( name = "ID_TIPO_TARIFA", nullable = false)
    @Getter @Setter
    private Long idTipoTarifa;

    @Column( name = "VALOR_TARIFA", nullable = false)
    @Getter @Setter
    private Long valorTarifa;

    @Column( name = "VALOR_TARIFA2", nullable = false)
    @Getter @Setter
    private Long valorTarifa2;

    @Column( name = "VALOR_TARIFA3", nullable = false)
    @Getter @Setter
    private Long valorTarifa3;

    @Column( name = "ID_ESTADO_PROYECTO", nullable = false)
    @Getter @Setter
    private Long idEstadoProyecto;

    @Column( name = "ID_CATEGORIA", nullable = false)
    @Getter @Setter
    private Long idCategoria;

    @Column( name = "ID_DIRECCION", nullable = false)
    @Getter @Setter
    private Long idDireccion;

    @Column( name = "ID_LINEA_NEGOCIO", nullable = false)
    @Getter @Setter
    private Long idLineaNegocio;

    @Column( name = "ID_TIPO_PROYECTO", nullable = false)
    @Getter @Setter
    private Long idTipoProyecto;

    @Column( name = "ID_SERVICIO", nullable = false)
    @Getter @Setter
    private Long idServicio;

    @Column( name = "ID_TIPO_SERVICIO", nullable = false)
    @Getter @Setter
    private Long idTipoServicio;

    @Column( name = "ID_DIRECTOR", nullable = false)
    @Getter @Setter
    private Long idDirector;

    @Column( name = "ID_GERENTE", nullable = false)
    @Getter @Setter
    private Long idGerente;

    @Column( name = "ID_TIPO_ALIANZA", nullable = false)
    @Getter @Setter
    private Long idTipoAlianza;

    @Column( name = "ID_CLASIFICACION_VENTA", nullable = false)
    @Getter @Setter
    private Long idClasificacionVenta;

    @Column( name = "COSTO_PLANEADO", nullable = false)
    @Getter @Setter
    private Long costoPlaneado;

    @Column( name = "MARGEN_PLANEADO", nullable = false)
    @Getter @Setter
    private Long margenPlanaedo;

    @Column( name = "FTE_PLANEADO", nullable = false)
    @Getter @Setter
    private Long ftePlaneado;

    @Column( name = "FACTOR_ICA", nullable = false)
    @Getter @Setter
    private Long factorICA;

    @Column( name = "FACTOR_PROV_INDEM", nullable = false)
    @Getter @Setter
    private Long factorProvIndem;

    @Column( name = "COMENTARIOS", nullable = false)
    @Getter @Setter
    private String comentarios;

    @Column( name = "FEC_CARGUE", nullable = false)
    @Getter @Setter
    private Date fecCargue;

    @Column( name = "USUARIO", nullable = false)
    @Getter @Setter
    private String usuario;

    public OcpProyecto() {
    }

    public OcpProyecto(Long codProyecto, Long idCliente, String alcance,
                       Date fechaInicio, Long duracion, Date fechaFin,
                       Long idMoneda, Long valorFormalHost, Long idTipoTarifa,
                       Long valorTarifa, Long valorTarifa2, Long valorTarifa3,
                       Long idEstadoProyecto, Long idCategoria, Long idDireccion,
                       Long idLineaNegocio, Long idTipoProyecto, Long idServicio,
                       Long idTipoServicio, Long idDirector, Long idGerente, Long idTipoAlianza,
                       Long idClasificacionVenta, Long costoPlaneado, Long margenPlanaedo,
                       Long ftePlaneado, Long factorICA, Long factorProvIndem,
                       String comentarios, Date fecCargue, String usuario) {
        this.codProyecto = codProyecto;
        this.idCliente = idCliente;
        this.alcance = alcance;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.fechaFin = fechaFin;
        this.idMoneda = idMoneda;
        this.valorFormalHost = valorFormalHost;
        this.idTipoTarifa = idTipoTarifa;
        this.valorTarifa = valorTarifa;
        this.valorTarifa2 = valorTarifa2;
        this.valorTarifa3 = valorTarifa3;
        this.idEstadoProyecto = idEstadoProyecto;
        this.idCategoria = idCategoria;
        this.idDireccion = idDireccion;
        this.idLineaNegocio = idLineaNegocio;
        this.idTipoProyecto = idTipoProyecto;
        this.idServicio = idServicio;
        this.idTipoServicio = idTipoServicio;
        this.idDirector = idDirector;
        this.idGerente = idGerente;
        this.idTipoAlianza = idTipoAlianza;
        this.idClasificacionVenta = idClasificacionVenta;
        this.costoPlaneado = costoPlaneado;
        this.margenPlanaedo = margenPlanaedo;
        this.ftePlaneado = ftePlaneado;
        this.factorICA = factorICA;
        this.factorProvIndem = factorProvIndem;
        this.comentarios = comentarios;
        this.fecCargue = fecCargue;
        this.usuario = usuario;
    }
}
