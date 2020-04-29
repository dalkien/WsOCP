package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpParametrosController;
import co.com.claro.ocp.controller.OcpParametrosRelacionController;
import co.com.claro.ocp.entity.OcpParametros;
import co.com.claro.ocp.util.InformacionParametros;
import co.com.claro.ocp.util.ListasParametros;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpParametrosFacade implements OcpParametrosIFacade {
    private static final long serialVersionUID = 1L;

    @EJB
    OcpParametrosController parametrosController;

    @EJB
    OcpParametrosRelacionController relacionController;

    @Override
    public List<InformacionParametros>  infParameters(Long valor){
        List<InformacionParametros> informacion =  new ArrayList<>();
        try{
            informacion = relacionController.infParameters(valor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return informacion;
    }

    @Override
    public List<ListasParametros> listasParametros(){
        List<ListasParametros> parametros = new ArrayList<>();
        try {
            parametros = relacionController.listSubParameters();
        }catch (Exception e){
            e.printStackTrace();
        }
        return parametros;
    }

    @Override
    public List<OcpParametros> allParameter(){
        List<OcpParametros> parametros = new ArrayList<>();
        try{
            parametros = parametrosController.allParameters();
        }catch (Exception e){e.printStackTrace();}
        return parametros;
    }

    @Override
    public OcpParametros parameter(Long id){
        OcpParametros parametro = new OcpParametros();
        try{
            parametro = parametrosController.parameterById(id);
        }catch (Exception e){e.printStackTrace();}
        return parametro;
    }

    @Override
    public List<OcpParametros> listParameter(List<Long> ids){
        List<OcpParametros> parametros = new ArrayList<>();
        try{
            parametros = parametrosController.listParameters(ids);
        }catch (Exception e){e.printStackTrace();}
        return parametros;
    }

}
