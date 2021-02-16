package co.com.claro.ocp.ws;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("OCPAuth")
@Stateless
@TransactionManagement
public class OCPAuth {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("createAuth")
    public void createAuth(String st){
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("updateAuth")
    public void updateAuth(String st){
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAuth")
    public void getAuth(String st){
    }

}
