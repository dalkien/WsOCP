package co.com.claro.ocp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCP_NOV_BHE")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "OcpNovBhe.findAll", query = "SELECT q FROM OcpNovBhe q")
        , @NamedQuery(name = "OcpNovBhe.findEmp", query = "SELECT q FROM OcpNovBhe q " +
        "where q.codEmpleado =  :codEmpleado")
        , @NamedQuery(name = "OcpNovBhe.findProy", query = "SELECT q FROM OcpNovBhe q where q.idProyecto = :idProyecto")
        , @NamedQuery(name = "OcpNovBhe.findRang", query = "SELECT q FROM OcpNovBhe q where q.anio =:anio and q.mes =:mes")
})
public class OcpNovBhe {
    @Id
    @Column(name = "ID_PROYECTO")
    @Getter
    @Setter
    private Long idProyecto;

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
