package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpParametrosRelacionController;
import co.com.claro.ocp.entity.OcpParametrosRelacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OcpParametrosRelacionFacade implements OcpParametrosRelacionIFacade {
    private static final long serialVersionUID = 1L;

    @EJB
    OcpParametrosRelacionController relacionController;

    @Override
    public void creaRelaParam(OcpParametrosRelacion relacion) {
        try{
        relacionController.create(relacion);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editaRelaParam(OcpParametrosRelacion relacion) {
        try{
            relacionController.edit(relacion);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OcpParametrosRelacion> allRelaParam() {
        try{
            return relacionController.allParamRelations ();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
