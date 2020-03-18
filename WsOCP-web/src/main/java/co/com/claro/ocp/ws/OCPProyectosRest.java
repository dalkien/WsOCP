package co.com.claro.ocp.ws;

import co.com.claro.ocp.entity.OcpProyecto;
import co.com.claro.ocp.facade.OcpProyectoIFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    @Path("getAllEmployed")
    public List<OcpProyecto> allEmployed(){
        List<OcpProyecto> proyectos = new ArrayList<>();
        try {
            proyectos = proyectoIFacade.allProjects();
        }catch (Exception e){
            e.printStackTrace();
        }
        return proyectos ;
    }

}
