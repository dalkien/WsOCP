package co.com.claro.ocp.ws;

import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.dto.InfoParamOcpResponse;
import co.com.claro.ocp.dto.ListParamOcpResponse;
import co.com.claro.ocp.facade.OcpParametrosIFacade;
import co.com.claro.ocp.util.InformacionParametros;
import co.com.claro.ocp.util.ListasParametros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("OCPParametros")
@Stateless
@TransactionManagement
public class OCPParametrosRest {

    @EJB
    OcpParametrosIFacade parametrosIFacade;

    public OCPParametrosRest() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("getAllListParam")
    public ListParamOcpResponse getAllListParam() {
        ListParamOcpResponse respuesta = new ListParamOcpResponse();
        List<ListasParametros> param = new ArrayList<>();
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            param = parametrosIFacade.listasParametros();
            if (param.size() <= 0) {
                response = new GenericResponse("Por favor validar selección", "Nok", "99");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok", "99");
        }
        respuesta.setParametos(param);
        respuesta.setResponse(response);
        return respuesta;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("paramDesc")
    public InfoParamOcpResponse getAllListParamDesc(@QueryParam("id") Long id) {
        InfoParamOcpResponse respuesta = new InfoParamOcpResponse();
        List<InformacionParametros> param = new ArrayList<>();
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            param = parametrosIFacade.infParameters(id);
            if (param.size() <= 0) {
                response = new GenericResponse("Por favor validar selección", "Nok", "99");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse(e.getMessage(), "Nok", "99");
        }
        respuesta.setParaDesc(param);
        respuesta.setResponse(response);
        return respuesta;
    }
}
