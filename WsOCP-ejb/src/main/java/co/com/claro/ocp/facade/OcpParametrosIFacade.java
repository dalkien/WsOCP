package co.com.claro.ocp.facade;


import co.com.claro.ocp.entity.OcpParametros;
import co.com.claro.ocp.util.InformacionParametros;
import co.com.claro.ocp.util.ListasParametros;

import javax.ejb.Local;
import java.lang.reflect.Parameter;
import java.util.List;

@Local
public interface OcpParametrosIFacade {

    public List<OcpParametros> allParameter();

    public OcpParametros parameter(Long id);

    public List<OcpParametros> listParameter(List<Long> ids);

    public List<ListasParametros> listasParametros();

    public List<InformacionParametros> infParameters(Long valor);

    public OcpParametros crearParametro(OcpParametros param);
}
