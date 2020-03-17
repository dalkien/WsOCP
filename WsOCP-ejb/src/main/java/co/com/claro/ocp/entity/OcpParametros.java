package co.com.claro.ocp.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "OCP_PARAMETROS")
@NamedQueries({
        @NamedQuery(name = "OcpParametros.findAll", query = "SELECT q FROM OcpParametros q")
        ,@NamedQuery(name = "OcpParametros.findByidParametro", query = "SELECT q FROM OcpParametros q " +
        "where q.idParametro = :idParametro")
        ,@NamedQuery(name = "OcpParametros.findByRange", query = "SELECT q FROM OcpParametros q " +
        "where q.idParametro in ( :valores)")
})
public class OcpParametros {
    @Id
    @Column(name = "ID_PARAMETRO", nullable = false)
    @Getter @Setter
    private Long idParametro;

    @Column(name = "NOMBRE_PARAMETRO", nullable = false)
    @Getter @Setter
    private String nombreParametro;

    @Column(name = "ESTADO_PARAMETRO", nullable = false)
    @Getter @Setter
    private Long estadoParametro;

    @Column(name = "FEC_CREACION", nullable = false)
    @Getter @Setter
    private Date fecCreacion;

    @Column(name = "COMENTARIOS", nullable = false)
    @Getter @Setter
    private String comentarios;

    @Column(name = "TIPO_PARAMETRO", nullable = false)
    @Getter @Setter
    private Long tipoParametro;

    @Column(name = "USUARIO", nullable = false)
    @Getter @Setter
    private String usuario;

    @Column(name = "VALOR1", nullable = false)
    @Getter @Setter
    private Long valor1;

    @Column(name = "VALOR2", nullable = false)
    @Getter @Setter
    private String valor2;

    public OcpParametros() {
    }

    public OcpParametros(Long idParametro, String nombreParametro,
                         Long estadoParametro, Date fecCreacion,
                         String comentarios, Long tipoParametro,
                         String usuario, Long valor1, String valor2) {
        this.idParametro = idParametro;
        this.nombreParametro = nombreParametro;
        this.estadoParametro = estadoParametro;
        this.fecCreacion = fecCreacion;
        this.comentarios = comentarios;
        this.tipoParametro = tipoParametro;
        this.usuario = usuario;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
}
