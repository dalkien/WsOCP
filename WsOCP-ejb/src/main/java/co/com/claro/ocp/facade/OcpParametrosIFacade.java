package co.com.claro.ocp.facade;


import co.com.claro.ocp.entity.OcpParametros;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpParametrosIFacade {

    public List<OcpParametros> allParameter();

    public OcpParametros parameter(Long id);

    public List<OcpParametros> listParameter(List<Long> ids);

}
