package co.com.claro.ocp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCP_NOV_OTROS")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "OcpNovOtros.findAll", query = "SELECT q FROM OcpNovOtros q")
        , @NamedQuery(name = "OcpNovOtros.findEmpl", query = "SELECT q FROM OcpNovOtros q " +
        "where q.codEmpleado = :codEmpleado")
        , @NamedQuery(name = "OcpNovOtros.findRang", query = "SELECT q FROM OcpNovOtros q " +
        "where q.anio =:anio and q.mes =:mes")
})
public class OcpNovOtros {
    @Id
    @Column(name = "COD_EMPLEADO")
    @Getter
    @Setter
    private Long codEmpleado;

    @Id
    @Column(name = "TIPO")
    @Getter
    @Setter
    private Long tipo;

    @Column(name = "VALOR")
    @Getter
    @Setter
    private Long valor;

    @Id
    @Column(name = "ANIO")
    @Getter
    @Setter
    private Long anio;

    @Id
    @Column(name = "MES")
    @Getter
    @Setter
    private Long mes;

    @Column(name = "COMENTARIOS")
    @Getter
    @Setter
    private String comentarios;

    @Column(name = "FEC_CARGUE")
    @Getter
    @Setter
    private Date fecCargue;

    @Column(name = "USUARIO")
    @Getter
    @Setter
    private String usuario;

}
