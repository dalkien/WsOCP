
package co.com.claro.ocp.ws;


import javax.ejb.EJB;
import javax.ws.rs.*;

import co.com.claro.ocp.dto.CancelUpdate;
import co.com.claro.ocp.dto.EmpleadosOcpResponse;
import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.entity.OcpBaseEmpleados;


import co.com.claro.ocp.entity.OcpProyecto;
import co.com.claro.ocp.facade.OcpBaseEmpleadosIFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
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
        try {
            Gson gson = new Gson();
            String jsons = gson.toJson(empleado);
            System.out.println(jsons);
            ocpBaseEmpleadosIFacade.creaEmpleado(empleado);
            response = genericRta("00", "Ok", "Ok");
        } catch (Exception e) {
            response = genericRta("99", "error al crear empleado", e.getMessage());
        }
        return response;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("editEmpleado")
    public GenericResponse editar(OcpBaseEmpleados empleado) throws JsonProcessingException {
        GenericResponse response = new GenericResponse();
        try {
            ocpBaseEmpleadosIFacade.actualizaEmpleado(empleado);
            response = genericRta("00", "Ok", "Ok");
        } catch (Exception e) {
            response = genericRta("99", "error al actualizar empleado", e.getMessage());
        }
        return response;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAllEmployed")
    public EmpleadosOcpResponse getAllEmployed() {
        EmpleadosOcpResponse ocpResponse = new EmpleadosOcpResponse();
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        GenericResponse response = new GenericResponse();
        try {
            empleados = ocpBaseEmpleadosIFacade.allEmpleados()
                    .stream().filter(x -> !x.getEstado().equals("INACTIVE"))
                    .collect(Collectors.toList());
            response = genericRta("00", "Ok", "Ok");
        } catch (Exception e) {
            e.printStackTrace();
            response = genericRta("99", "No se pudo recuperar empleado", e.getMessage());
        }
        ocpResponse.setEmpleados(empleados);
        ocpResponse.setResponse(response);
        return ocpResponse;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getEmployed/{id}")
    public EmpleadosOcpResponse getEmployed(@QueryParam("id") Long codEmpleado) {
        EmpleadosOcpResponse ocpResponse = new EmpleadosOcpResponse();
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        OcpBaseEmpleados empleado = new OcpBaseEmpleados();
        GenericResponse response = new GenericResponse();
        try {
            empleado = ocpBaseEmpleadosIFacade.getEmpleado(codEmpleado);
            response = genericRta("00", "Ok", "Ok");
        } catch (Exception e) {
            e.printStackTrace();
            response = genericRta("99", "No se pudo recuperar empleado", e.getMessage());
        }
        empleados.add(empleado);
        ocpResponse.setEmpleados(empleados);
        ocpResponse.setResponse(response);
        return ocpResponse;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getEmployedByProject/{ids}")
    public EmpleadosOcpResponse getEmployed(@QueryParam("id") List<Long> codEmpleado) {
        EmpleadosOcpResponse ocpResponse = new EmpleadosOcpResponse();
        List<OcpBaseEmpleados> empleados = new ArrayList<>();
        List<OcpBaseEmpleados> empleado = new ArrayList<>();
        GenericResponse response = new GenericResponse();
        try {
            empleado = ocpBaseEmpleadosIFacade.allEmpleadosByProject(codEmpleado);
            response = genericRta("00", "Ok", "Ok");
        } catch (Exception e) {
            e.printStackTrace();
            response = genericRta("99", "No se pudo recuperar empleado", e.getMessage());
        }
        empleados.addAll(empleado);
        ocpResponse.setEmpleados(empleados);
        ocpResponse.setResponse(response);
        return ocpResponse;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("editStateEmployed")
    public GenericResponse editEstadotProyect(CancelUpdate cancel  ) {
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            OcpBaseEmpleados empleado = this.ocpBaseEmpleadosIFacade.getEmpleado(cancel.getIdMod());
            empleado.setUsuario(cancel.getUser());
            empleado.setEstado(cancel.getState().equals("I") ? "INACTIVE": "ACTIVE");
            this.ocpBaseEmpleadosIFacade.actualizaEmpleado (empleado);
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok", "99");
        }
        return response;
    }

    public GenericResponse genericRta(String code, String descripcion, String message) {
        GenericResponse response = new GenericResponse();
        response.setMessageCode(message);
        response.setDescripcion(descripcion);
        response.setReturnCode(code);
        return response;
    }

}
