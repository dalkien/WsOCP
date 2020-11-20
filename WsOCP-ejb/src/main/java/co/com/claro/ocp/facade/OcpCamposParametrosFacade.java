package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpCamposParametrosController;
import co.com.claro.ocp.entity.OcpCamposParametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OcpCamposParametrosFacade implements OcpCamposParametrosIFacade {

    @EJB
    OcpCamposParametrosController parametrosController;

    @Override
    public List<OcpCamposParametros> findAllCamposParam() {
        return this.parametrosController.allCamposParam();
    }

    @Override
    public OcpCamposParametros findCampoParamById(Long id) {
        return this.parametrosController.camposParametrosById(id);
    }

    @Override
    public void createCampoParam(OcpCamposParametros parametros) {
        this.parametrosController.create(parametros);
    }

    @Override
    public void updateCampoParam(OcpCamposParametros parametros) {
        this.parametrosController.edit(parametros);
    }
}
