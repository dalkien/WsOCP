package co.com.claro.ocp.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "EclipseLink-2.5.2.v20140319-rNA", date = "2020-07-13T21:42:04")
@StaticMetamodel(OcpParametrosRelacion.class)
public class OcpParametrosRelacion_ {

    public static volatile SingularAttribute<OcpParametrosRelacion, Long> idParametro;
    public static volatile SingularAttribute<OcpParametrosRelacion, Long> estadoRelacion;
    public static volatile SingularAttribute<OcpParametrosRelacion, Long> idSubParametro;
    public static volatile SingularAttribute<OcpParametrosRelacion, Long> idRelacion;
    public static volatile SingularAttribute<OcpParametrosRelacion, Date> fechaCreacion;
    public static volatile SingularAttribute<OcpParametrosRelacion, String> usuario;
    public static volatile SingularAttribute<OcpParametrosRelacion, String> comentario;

}