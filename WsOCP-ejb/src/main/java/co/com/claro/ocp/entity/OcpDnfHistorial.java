package co.com.claro.ocp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OCPDNF_HISTORIAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "OcpDnf_Historial.findAll", query = "SELECT q FROM OcpDnfHistorial q")
        , @NamedQuery(name = "OcpDnf_Historial.findById", query = "SELECT q FROM OcpDnfHistorial q " +
        "where q.id =:id")
})
public class OcpDnfHistorial {

    @Id
    @Column(name = "ID", nullable = false)
    @Getter @Setter
    private Long id;

    @Column(name = "OBJ_DNF")
    @Getter @Setter
    private String objDnf;

    @Column(name = "FECHA_CREACION")
    @Getter @Setter
    private Date fechaCreacion;

    @Column(name = "USUARIO_CREACION")
    @Getter @Setter
    private String usuarioCreacion;

    @Column(name = "FECHA_ULT_MOD")
    @Getter @Setter
    private Date FechaUltMod;

    @Column(name = "USUARIO_ULT_MOD")
    @Getter @Setter
    private String usuarioUltMod;

    @Column(name = "OBSERVACIONES")
    @Getter @Setter
    private String obsevaciones;
}
