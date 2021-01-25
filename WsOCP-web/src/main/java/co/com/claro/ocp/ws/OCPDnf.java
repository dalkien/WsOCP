package co.com.claro.ocp.ws;

import co.com.claro.ocp.dto.EmpleadosOcpResponse;
import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.entity.OcpBaseEmpleados;
import co.com.claro.ocp.entity.OcpDnfHistorial;
import co.com.claro.ocp.facade.OcpDnfHistorialIFacade;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.*;
import java.util.List;

@Path("OCPDnf")
@Stateless
@TransactionManagement
public class OCPDnf {

    @EJB
    OcpDnfHistorialIFacade facade;

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAllDNF")
    public List<OcpDnfHistorial> getAllDNF() {
        return this.facade.getAllDnf();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("editDNF")
    public GenericResponse editDNF(OcpDnfHistorial dnf )  {
        GenericResponse response = genericRta("00","Ok","Update Ok");
        try {
            this.facade.editDnf(dnf);
        }catch (Exception e){
            e.printStackTrace();
            response =genericRta("99","NOK","Update NOk " + e.getCause().getMessage());
        }
        return response;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("insertDNF")
    public GenericResponse insertDNF( OcpDnfHistorial dnf) {
        GenericResponse response = genericRta("00","Ok","Insert Ok");
        try {
            this.facade.createDnf(dnf);
        }catch (Exception e){
            e.printStackTrace();
            response =genericRta("99","NOK","Insert NOk " + e.getCause().getMessage());
        }
        return response;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getDNF/{id}")
    public OcpDnfHistorial getDNF(@QueryParam("id") Long codDNF) {
        return this.facade.getDnfById(codDNF);
    }

    public GenericResponse genericRta(String code, String descripcion, String message) {
        GenericResponse response = new GenericResponse();
        response.setMessageCode(message);
        response.setDescripcion(descripcion);
        response.setReturnCode(code);
        return response;
    }
}
