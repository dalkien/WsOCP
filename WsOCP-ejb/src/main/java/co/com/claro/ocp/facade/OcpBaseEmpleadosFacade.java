package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpBaseEmpleadosController;
import co.com.claro.ocp.entity.OcpBaseEmpleados;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpBaseEmpleadosFacade implements OcpBaseEmpleadosIFacade {

    private static final long serialVersionUID = 1L;

    @EJB
    OcpBaseEmpleadosController baseEmpleadosController;

    @Override
    public List<OcpBaseEmpleados> allEmpleados() {
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        empleados = baseEmpleadosController.allEmpleados();
        return empleados ;
    }

    @Override
    public void creaEmpleado(OcpBaseEmpleados empleado){
        try{
            baseEmpleadosController.create(empleado);
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void actualizaEmpleado(OcpBaseEmpleados empleado){
        try{
            baseEmpleadosController.edit(empleado);
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public OcpBaseEmpleados getEmpleado(Long codEmpleado){
        OcpBaseEmpleados empleado = new OcpBaseEmpleados();
        try{
            empleado = baseEmpleadosController.empleadoByCodEmpleado(codEmpleado) ;
        }catch (Exception e){e.printStackTrace();}
        return  empleado;
    }

}
