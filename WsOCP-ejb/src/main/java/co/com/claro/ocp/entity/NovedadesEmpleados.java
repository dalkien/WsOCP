package co.com.claro.ocp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NOVEDADES_EMPLEADOS")
@Data
@NamedQueries({
        @NamedQuery(name = "NovedadesEmpleados.findAll", query = "SELECT q FROM NovedadesEmpleados q")
        , @NamedQuery(name = "NovedadesEmpleados.findEmp", query = "SELECT q FROM NovedadesEmpleados q " +
        "where q.cedula =:cedula")
})
public class NovedadesEmpleados {

    @Id
    @Column(name = "ID", nullable = false)
    @NotNull
    @SequenceGenerator(name = "NOVEDADES_EMPLEADOS_SEQ",
            sequenceName = "NOVEDADES_EMPLEADOS_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "NOVEDADES_EMPLEADOS_SEQ")
    @Getter @Setter
    private Long id;

    @Column(name = "CODIGO",nullable = false )
    @Getter @Setter
    private String codigo;

    @Column(name = "CEDULA",nullable = false)
    @Getter @Setter
    private Long cedula;

    @Column(name = "EMPLEADO",nullable = false)
    @Getter @Setter
    private String empleado;

    @Column(name = "ID_PROYECTO",nullable = true)
    @Getter @Setter
    private  Long idProyecto;

    @Column(name = "PROYECTO",nullable = false)
    @Getter @Setter
    private String proyecto;

    @Column(name = "ESTADO_PROYECTO",nullable = false)
    @Getter @Setter
    private String estadoProyecto;

    @Column(name = "GERENTE_SQUAD",nullable = false)
    @Getter @Setter
    private String gerenteSquad;

    @Column(name = "DIRECCIÓN",nullable = false)
    @Getter @Setter
    private String direccion;

    @Column(name = "VACACIONES",nullable = true)
    @Getter @Setter
    private Long vacaciones;

    @Column (name = "AUSENCIAS", nullable = true)
    @Getter @Setter
    private Long ausencias;

    @Column(name = "OBSERVACIONES",nullable = true)
    @Getter @Setter
    private String observaciones;

    @Column(name = "BONOS",nullable = true)
    @Getter @Setter
    private Long bonos;

    @Column(name = "HORAS_EXTRAS",nullable = true)
    @Getter @Setter
    private Long horasExtras;

    @Column (name = "OTROS_COSTOS",nullable = true)
    @Getter @Setter
    private Long otrosCostos;

    @Column (name = "HORAS_MES", nullable = true)
    @Getter @Setter
    private Long HorasMes;

    @Column (name = "COSTO_RRHH", nullable = true)
    @Getter @Setter
    private Long costoRRHH;

    @Column (name = "INCAP_DIAS", nullable = true)
    @Getter @Setter
    private Long incapacidadDias;

    @Column (name = "OBSERV_NOMINA", nullable = true)
    @Getter @Setter
    private String observacionesNomina;

    @Column(name = "COLUMNAS_ALTERNATIVAS", nullable = true)
    @Getter @Setter
    private String columnasAlternativas;

}
