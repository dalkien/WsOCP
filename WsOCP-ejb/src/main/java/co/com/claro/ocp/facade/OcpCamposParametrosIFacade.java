package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpCamposParametros;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpCamposParametrosIFacade {

    List<OcpCamposParametros> findAllCamposParam();

    OcpCamposParametros findCampoParamById(Long id);

    void createCampoParam(OcpCamposParametros parametros);

    void updateCampoParam(OcpCamposParametros parametros);
}
