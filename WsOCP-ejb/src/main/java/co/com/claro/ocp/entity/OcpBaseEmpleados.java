/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.ocp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


/**
 * @author omarMad
 */
@Entity
@Table(name = "OCP_BASE_EMPLEADOS")
@NamedQueries({
        @NamedQuery(name = "OcpBaseEmpleados.findAll", query = "SELECT q FROM OcpBaseEmpleados q")
        , @NamedQuery(name = "OcpBaseEmpleados.findByCodEmpleado", query = "SELECT q FROM OcpBaseEmpleados q " +
        "where q.codEmpleado = :codEmpleado")
        , @NamedQuery(name = "OcpBaseEmpleados.findListByProject", query = "SELECT q FROM OcpBaseEmpleados q " +
        "WHERE q.codEmpleado in (:valores)")
})
public class OcpBaseEmpleados {

    @Id
    @Column(name = "COD_EMPLEADO", nullable = false)
    @Getter
    @Setter
    private Long codEmpleado;

    @Column(name = "CEDULA", nullable = false)
    @Getter
    @Setter
    private Long cedula;

    @Column(name = "NOMBRES", nullable = false)
    @Getter
    @Setter
    private String nombres;

    @Column(name = "FECHA_INGRERO", nullable = false)
    @Getter
    @Setter
    private Date fehcaIngrero;

    @Column(name = "ING_RET", nullable = false)
    @Getter
    @Setter
    private String ingRet;

    @Column(name = "TIPO_CONTRATO", nullable = false)
    @Getter
    @Setter
    private String tipoContrato;

    @Column(name = "ROL", nullable = false)
    @Getter
    @Setter
    private String rol;

    @Column(name = "TIPO_SALARIO", nullable = false)
    @Getter
    @Setter
    private String tipoSalario;

    @Column(name = "SALARIO", nullable = false)
    @Getter
    @Setter
    private Long salario;

    @Column(name = "BENEFICIO", nullable = false)
    @Getter
    @Setter
    private Long beneficio;

    @Column(name = "EQUIPO", nullable = false)
    @Getter
    @Setter
    private Long equipo;

    @Column(name = "DESCUENTO", nullable = false)
    @Getter
    @Setter
    private String descuento;

    @Column(name = "SALARIO_TOTAL", nullable = false)
    @Getter
    @Setter
    private Long salarioTotal;

    @Column(name = "COSTO_EST_MES", nullable = false)
    @Getter
    @Setter
    private Long costoEstMes;

    @Column(name = "OBSERVACIONES", nullable = false)
    @Getter
    @Setter
    private String observaciones;

    @Column(name = "FEC_CARGUE", nullable = false)
    @Getter
    @Setter
    private Date fecCargue;

    @Column(name = "USUARIO", nullable = false)
    @Getter
    @Setter
    private String usuario;

    public OcpBaseEmpleados() {
    }

    public OcpBaseEmpleados(Long codEmpleado, Long cedula, String nombres,
                            Date fehcaIngrero, String ingRet, String tipoContrato,
                            String rol, String tipoSalario, Long salario, Long beneficio,
                            Long equipo, String descuento, Long salarioTotal,
                            Long costoEstMes, String observaciones, Date fecCargue, String usuario) {
        this.codEmpleado = codEmpleado;
        this.cedula = cedula;
        this.nombres = nombres;
        this.fehcaIngrero = fehcaIngrero;
        this.ingRet = ingRet;
        this.tipoContrato = tipoContrato;
        this.rol = rol;
        this.tipoSalario = tipoSalario;
        this.salario = salario;
        this.beneficio = beneficio;
        this.equipo = equipo;
        this.descuento = descuento;
        this.salarioTotal = salarioTotal;
        this.costoEstMes = costoEstMes;
        this.observaciones = observaciones;
        this.fecCargue = fecCargue;
        this.usuario = usuario;
    }
}
