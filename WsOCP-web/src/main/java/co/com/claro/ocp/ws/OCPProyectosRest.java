package co.com.claro.ocp.ws;

import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.dto.ProyectoCreate;
import co.com.claro.ocp.dto.ProyectosOcpResponse;
import co.com.claro.ocp.entity.OcpParametros;
import co.com.claro.ocp.entity.OcpParametrosRelacion;
import co.com.claro.ocp.entity.OcpProyecto;
import co.com.claro.ocp.facade.OcpParametrosIFacade;
import co.com.claro.ocp.facade.OcpParametrosRelacionIFacade;
import co.com.claro.ocp.facade.OcpProyectoIFacade;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("OCPProyectos")
@Stateless
@TransactionManagement
public class OCPProyectosRest {

    @EJB
    OcpProyectoIFacade proyectoIFacade;
    @EJB
    OcpParametrosIFacade parametrosIFacade;
    @EJB
    OcpParametrosRelacionIFacade relacionIFacade;

    public OCPProyectosRest() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAllProyects")
    public ProyectosOcpResponse getAllProyects() {
        ProyectosOcpResponse respuesta = new ProyectosOcpResponse();
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        List<OcpProyecto> proyectos = new ArrayList<>();
        try {
            proyectos = proyectoIFacade.allProjects();
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok", "99");
        }
        respuesta.setProyectos(proyectos);
        respuesta.setResponse(response);
        return respuesta;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("createProyect")
    public GenericResponse createProyect(ProyectoCreate proyecto) {
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            OcpParametros parametros = new OcpParametros();
            OcpParametrosRelacion relacion = new OcpParametrosRelacion();
            parametros.setComentarios(proyecto.getDescripcion());
            parametros.setEstadoParametro(1L);
            parametros.setFecCreacion(new Date());
            parametros.setNombreParametro(proyecto.getProyecto().getCodProyecto().toString());
            parametros.setTipoParametro(0L);
            parametros.setUsuario(proyecto.getProyecto().getUsuario());
            parametros.setValor1(0L);
            parametros.setValor2("N/A");
            OcpParametros parametros2 = new OcpParametros();
            parametros2 = parametrosIFacade.crearParametro(parametros);

            relacion.setIdSubParametro(parametros2.getIdParametro());
            relacion.setIdParametro(198L);
            relacion.setComentario("LISTADO DE PROYECTOS");
            relacion.setEstadoRelacion(1L);
            relacion.setUsuario(proyecto.getProyecto().getUsuario());
            relacion.setFechaCreacion(new Date());
            relacionIFacade.creaRelaParam(relacion);
            proyectoIFacade.createProject(proyecto.getProyecto());
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok", "99");
        }
        return response;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("editProyect")
    public GenericResponse editProyect(OcpProyecto proyecto) {
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            proyectoIFacade.editProject(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok", "99");
        }
        return response;
    }
}
