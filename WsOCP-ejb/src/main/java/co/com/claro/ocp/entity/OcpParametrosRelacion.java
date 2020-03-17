package co.com.claro.ocp.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCP_PARAMETROS_RELACION")
@NamedQueries({
        @NamedQuery(name = "OcpParametrosRelacion.findAll", query = "SELECT q FROM OcpParametrosRelacion q")
        ,@NamedQuery(name = "OcpParametrosRelacion.findByidParametro", query = "SELECT q FROM OcpParametrosRelacion q " +
        "where q.idParametro = :idParametro")
})
public class OcpParametrosRelacion {
    @Id
    @Column(name = "ID_RELACION", nullable = false)
    @Getter @Setter
    private Long idRelacion;

    @Column(name = "ID_PARAMETRO", nullable = false)
    @Getter @Setter
    private Long idParametro;

    @Column(name = "ID_SUB_PARAMETRO", nullable = false)
    @Getter @Setter
    private Long idSubParametro;

    @Column(name = "ESTADO_RELACION", nullable = false)
    @Getter @Setter
    private Long estadoRelacion;

    @Column(name = "COMENTARIO", nullable = false)
    @Getter @Setter
    private String comentario;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Getter @Setter
    private Date fechaCreacion;

    @Column(name = "USUARIO", nullable = false)
    @Getter @Setter
    private String usuario;

}
