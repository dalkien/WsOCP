package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpParametrosRelacion;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpParametrosRelacionIFacade {

    public void creaRelaParam(OcpParametrosRelacion relacion);

    public void editaRelaParam(OcpParametrosRelacion relacion);

    public List<OcpParametrosRelacion> allRelaParam();
}