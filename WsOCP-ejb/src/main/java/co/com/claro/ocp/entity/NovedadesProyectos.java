package co.com.claro.ocp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NOVEDADES_DE_PROYECTOS")
@Data
@NamedQueries({
        @NamedQuery(name = "NovedadesProyectos.findAll", query = "SELECT q FROM   NovedadesProyectos q")
        , @NamedQuery(name = "NovedadesProyectos.findId", query = "SELECT q FROM NovedadesProyectos q " +
        "where q.id =:id")

})
public class NovedadesProyectos{
    @Id
    @Column(name = "ID", nullable = false)
    @Getter @Setter
    private Long id;

    @Column(name = "PROYECTO", nullable = false)
    @Getter @Setter
    private String proyecto;

    @Column(name="ESTADO_DEL_PROYECTO", nullable = false )
    @Getter @Setter
    private String estadoDeproyecto;

    @Column ( name="GERENTE_SQUAD", nullable = false )
    @Getter @Setter
    private String gerenteSquad;

    @Column (name="DIRECCIÓN",nullable = false)
    @Getter @Setter
    private String direccion;

    @Column (name="DATACENTER", nullable = true)
    @Getter @Setter
    private Long datacenter;

    @Column (name="EQUIPOS",nullable = true )
    @Getter @Setter
    private Long equipos;

    @Column (name="TAXIS",nullable = true)
    @Getter @Setter
    private Long taxis;

    @Column (name = "CAJA_MENOR",nullable = true)
    @Getter @Setter
    private Long cajaMenor;

    @Column(name = "CELULARES",nullable = true)
    @Getter @Setter
    private Long celulares;

    @Column (name = "EXAMEN_MEDICO",nullable = true)
    @Getter @Setter
    private Long examenMedico;

    @Column(name = "BONOS_GTES",nullable = true)
    @Getter @Setter
    private Long bonosGtes;

    @Column (name = "LICENCIAS_365_USD",nullable = true)
    @Getter @Setter
    private Long licencias365Usd;

    @Column (name = "COLUMNAS_ALTERNATIVAS",nullable = true )
    @Getter @Setter
    private String columnasAlternativas;

    @Column (name = "FECHA_CREACION",nullable = true)
    @Getter @Setter
    private Date fechaCreacion;

    @Column (name = "LICENCIAS_365_COPS",nullable = true)
    @Getter @Setter
    private Long licencias365Cops;

    @Column (name = "TIPO_CAMBIO",nullable = true)
    @Getter @Setter
    private Long tipoCambio;


}

