package co.com.claro.ocp.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-19T11:53:16")
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