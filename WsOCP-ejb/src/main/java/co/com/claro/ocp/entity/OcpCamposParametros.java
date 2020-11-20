package co.com.claro.ocp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "OCP_CAMPOS_PARAMETROS")
@Data
@NamedQueries({
        @NamedQuery(name = "OcpCamposParametros.findAll", query = "SELECT q FROM OcpCamposParametros q")
        , @NamedQuery(name = "OcpCamposParametros.findById", query = "SELECT q FROM OcpCamposParametros q " +
        "where q.id =:id")
})
public class OcpCamposParametros {
    @Id
    @Column(name = "ID", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Column(name = "FECHA_DE_CREACION", nullable = false)
    @Getter
    @Setter
    private Date fechaDeCreacion;

    @Column(name = "PANTALLA", nullable = true)
    @Getter
    @Setter
    private String pantalla;

    @Column(name = "TIPO_DE_DATO", nullable = true)
    @Getter
    @Setter
    private String tipoDeDato;

    @Column(name = "NOMBRE_PARAMETRO", nullable = true)
    @Getter
    @Setter
    private String nombreParametro;

    @Column(name = "LONGITUD", nullable = true)
    @Getter
    @Setter
    private String longitud;

    @Column(name = "VALIDACION", nullable = false)
    @Getter
    @Setter
    private String validacion;

    @Column(name = "REGEX", nullable = false)
    @Getter
    @Setter
    private String regex;

}