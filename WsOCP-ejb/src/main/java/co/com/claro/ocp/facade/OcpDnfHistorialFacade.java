package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpDnfHistorialController;
import co.com.claro.ocp.entity.OcpDnfHistorial;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OcpDnfHistorialFacade implements OcpDnfHistorialIFacade{

    @EJB
    OcpDnfHistorialController historialController;

    @Override
    public List<OcpDnfHistorial> getAllDnf() {
        return this.historialController.dnfHistorials();
    }

    @Override
    public OcpDnfHistorial getDnfById(Long id) {
        return this.historialController.dnfHistorialByid(id);
    }

    @Override
    public void editDnf(OcpDnfHistorial dnf) {
        this.historialController.edit(dnf);
    }

    @Override
    public void createDnf(OcpDnfHistorial dnf) {
        this.historialController.create(dnf);
    }
}
