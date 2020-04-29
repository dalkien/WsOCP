package co.com.claro.ocp.ws;

import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.dto.ProyectosOcpResponse;
import co.com.claro.ocp.entity.OcpProyecto;
import co.com.claro.ocp.facade.OcpProyectoIFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("OCPProyectos")
@Stateless
@TransactionManagement
public class OCPProyectosRest {

    @EJB
    OcpProyectoIFacade proyectoIFacade;

    public OCPProyectosRest() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAllProyects")
    public ProyectosOcpResponse getAllProyects(){
        ProyectosOcpResponse respuesta = new ProyectosOcpResponse();
        GenericResponse response = new GenericResponse("OK", "OK","00");
        List<OcpProyecto> proyectos = new ArrayList<>();
        try {
            proyectos = proyectoIFacade.allProjects();
        }catch (Exception e){
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok","99");
        }
        respuesta.setProyectos(proyectos);
        respuesta.setResponse(response);
        return respuesta ;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("createProyect")
    public GenericResponse createProyect(OcpProyecto proyecto){
        GenericResponse response = new GenericResponse("OK", "OK","00");
        try {
            proyectoIFacade.createProject(proyecto);
        }catch (Exception e){
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok","99");
        }
        return response ;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("editProyect")
    public GenericResponse editProyect(OcpProyecto proyecto){
        GenericResponse response = new GenericResponse("OK", "OK","00");
        try {
            proyectoIFacade.editProject(proyecto);
        }catch (Exception e){
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok","99");
        }
        return response ;
    }
}
