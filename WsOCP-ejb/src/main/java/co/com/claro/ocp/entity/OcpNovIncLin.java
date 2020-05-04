package co.com.claro.ocp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCP_NOV_INC_LIN")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "OcpNovIncLin.findAll", query = "SELECT q FROM OcpNovIncLin q")
        ,@NamedQuery(name = "OcpNovIncLin.findEmp", query = "SELECT q FROM OcpNovIncLin q " +
        "where q.codEmpleado =:codEmpleado")
        ,@NamedQuery(name = "OcpNovIncLin.findRang", query = "SELECT q FROM OcpNovIncLin q " +
        "where q.mes =:mes and q.anio =:anio")
})
public class OcpNovIncLin {
    @Id
    @Column(name = "COD_EMPLEADO")
    @Getter @Setter
    private Long codEmpleado;

    @Column(name = "VALOR")
    @Getter @Setter
    private Long valor;

    @Id
    @Column(name = "ANIO")
    @Getter @Setter
    private Long anio;

    @Id
    @Column(name = "MES")
    @Getter @Setter
    private Long mes;

    @Column(name = "FEC_CARGUE")
    @Getter @Setter
    private Date fecCargue;

    @Column(name = "EGM")
    @Getter @Setter
    private Long egm;

    @Column(name = "LM")
    @Getter @Setter
    private Long lm;

    @Column(name = "ATEP")
    @Getter @Setter
    private Long atep;

    @Column(name = "LR")
    @Getter @Setter
    private Long lr;

    @Column(name = "LNR")
    @Getter @Setter
    private Long lnr;

    @Column(name = "LUTO")
    @Getter @Setter
    private Long luto;

    @Column(name = "PATERNIDAD")
    @Getter @Setter
    private Long paternidad;

    @Column(name = "SANCIONES")
    @Getter @Setter
    private Long sanciones;

    @Column(name = "USUARIO")
    @Getter @Setter
    private String usuario;

}
