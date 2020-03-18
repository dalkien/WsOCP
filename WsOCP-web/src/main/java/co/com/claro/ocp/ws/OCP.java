
package co.com.claro.ocp.ws;


import javax.ejb.EJB;
import javax.ws.rs.*;

import co.com.claro.ocp.dto.EmpleadosOcpResponse;
import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.entity.OcpBaseEmpleados;


import co.com.claro.ocp.facade.OcpBaseEmpleadosIFacade;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omarMad
 */
@Path("OCP")
@Stateless
@TransactionManagement
public class OCP {

    @EJB
    private OcpBaseEmpleadosIFacade ocpBaseEmpleadosIFacade;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("inserEmpleado")
    public GenericResponse insertar(OcpBaseEmpleados empleado)
            throws JsonProcessingException {
        GenericResponse response = new GenericResponse();
        try{
            ocpBaseEmpleadosIFacade.creaEmpleado(empleado);
            response = genericRta("00","Ok", "Ok");
        }catch (Exception e){
            response = genericRta("99","error al crear empleado", e.getMessage());
        }
        return response;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("editEmpleado")
    public GenericResponse editar(OcpBaseEmpleados empleado) throws JsonProcessingException {
        GenericResponse response = new GenericResponse();
        try{
            ocpBaseEmpleadosIFacade.actualizaEmpleado(empleado);
            response = genericRta("00","Ok", "Ok");
        }catch (Exception e){
            response = genericRta("99","error al actualizar empleado", e.getMessage());
        }
        return response;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAllEmployed")
    public EmpleadosOcpResponse getAllEmployed(){
        EmpleadosOcpResponse ocpResponse = new EmpleadosOcpResponse();
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        GenericResponse response = new GenericResponse();
        try{
            empleados = ocpBaseEmpleadosIFacade.allEmpleados();
            response = genericRta("00","Ok", "Ok");
        }catch (Exception e){
            e.printStackTrace();
            response = genericRta("99","No se pudo recuperar empleado", e.getMessage());
        }
        ocpResponse.setEmpleados(empleados);
        ocpResponse.setResponse(response);
        return ocpResponse ;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getEmployed/{id}")
    public EmpleadosOcpResponse getEmployed(@QueryParam("id") Long codEmpleado){
        EmpleadosOcpResponse ocpResponse = new EmpleadosOcpResponse();
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        OcpBaseEmpleados empleado = new OcpBaseEmpleados();
        GenericResponse response = new GenericResponse();
        try{
            empleado = ocpBaseEmpleadosIFacade.getEmpleado(codEmpleado);
            response = genericRta("00","Ok", "Ok");
        }catch (Exception e){
            e.printStackTrace();
            response = genericRta("99","No se pudo recuperar empleado", e.getMessage());
        }
        empleados.add(empleado);
        ocpResponse.setEmpleados(empleados);
        ocpResponse.setResponse(response);
        return ocpResponse ;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getEmployedByProject/{ids}")
    public EmpleadosOcpResponse getEmployed(@QueryParam("id") List<Long>  codEmpleado){
        EmpleadosOcpResponse ocpResponse = new EmpleadosOcpResponse();
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        List<OcpBaseEmpleados> empleado = new ArrayList<>();
        GenericResponse response = new GenericResponse();
        try{
            empleado = ocpBaseEmpleadosIFacade.allEmpleadosByProject(codEmpleado);
            response = genericRta("00","Ok", "Ok");
        }catch (Exception e){
            e.printStackTrace();
            response = genericRta("99","No se pudo recuperar empleado", e.getMessage());
        }
        empleados.addAll(empleado);
        ocpResponse.setEmpleados(empleados);
        ocpResponse.setResponse(response);
        return ocpResponse ;
    }

    public GenericResponse genericRta(String code, String descripcion, String message){
        GenericResponse response = new GenericResponse();
        response.setMessageCode (message);
        response.setDescripcion(descripcion);
        response.setReturnCode(code);
        return response;
    }

}
