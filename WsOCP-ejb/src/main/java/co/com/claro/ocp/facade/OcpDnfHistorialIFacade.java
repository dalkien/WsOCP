package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpDnfHistorial;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpDnfHistorialIFacade {

    public List<OcpDnfHistorial> getAllDnf();
    public OcpDnfHistorial getDnfById(Long id);
    public void editDnf(OcpDnfHistorial dnf);
    public void createDnf(OcpDnfHistorial dnf);
}
