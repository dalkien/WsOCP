package co.com.claro.ocp.ws;

import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.dto.InfoParamOcpResponse;
import co.com.claro.ocp.dto.ListParamOcpResponse;
import co.com.claro.ocp.dto.OcpCamposParamResponse;
import co.com.claro.ocp.entity.OcpCamposParametros;
import co.com.claro.ocp.facade.OcpCamposParametrosIFacade;
import co.com.claro.ocp.facade.OcpParametrosIFacade;
import co.com.claro.ocp.util.InformacionParametros;
import co.com.claro.ocp.util.ListasParametros;
import org.springframework.web.bind.annotation.PathVariable;

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

    @EJB
    OcpCamposParametrosIFacade camposParametrosIFacade;

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

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("creaCampoParam")
    public GenericResponse createCampoParam(OcpCamposParametros param){
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            this.camposParametrosIFacade.createCampoParam(param);
        }catch (Exception e){
            e.printStackTrace();
            response.setReturnCode("99");
            response.setDescripcion(e.getCause().getCause().toString());
            response.setMessageCode("Operación no se ");
        }
        return response;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("actualizaCampoParam")
    public GenericResponse updateCampoParam(OcpCamposParametros param){
        GenericResponse response = new GenericResponse("OK", "OK", "00");
        try {
            OcpCamposParametros campBf = new OcpCamposParametros();
            campBf = this.camposParametrosIFacade.findCampoParamById(param.getId());

            if ( campBf.getFijo()== null || campBf.getFijo().equals("0") ){
                this.camposParametrosIFacade.updateCampoParam(param);
            }else if(campBf.getFijo().equals("0") && campBf.getAutorizado().equals(param.getAutorizado())){
                this.camposParametrosIFacade.updateCampoParam(param);
            }else {
                response.setReturnCode("99");
                response.setDescripcion("Autorizado no corresponde a actualizacion");
                response.setMessageCode("Operacion no permitida");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setReturnCode("99");
            response.setDescripcion(e.getCause().getCause().toString());
            response.setMessageCode("Operación no se ");
        }
        return response;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("allCampoParam")
    public OcpCamposParamResponse getAllCampoParam(OcpCamposParametros param){
        OcpCamposParamResponse response = new OcpCamposParamResponse();
        List<OcpCamposParametros> campos = new ArrayList<>();
        GenericResponse respon = new GenericResponse("OK", "OK", "00");
        try {
            campos= this.camposParametrosIFacade.findAllCamposParam();
            response.setParametros(campos);
            response.setResponse(respon);
        }catch (Exception e){
            e.printStackTrace();
            respon.setReturnCode("99");
            respon.setDescripcion(e.getCause().getCause().toString());
            respon.setMessageCode("Operación no se ");
            response.setResponse(respon);
        }
        return response;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("campoById/{id}")
    public OcpCamposParamResponse campoParam(@PathParam("id") Long idCampo){
        System.out.println("id => " + idCampo );
        OcpCamposParamResponse response = new OcpCamposParamResponse();
        List<OcpCamposParametros> campos = new ArrayList<>();
        GenericResponse respon = new GenericResponse("OK", "OK", "00");
        OcpCamposParametros param = new OcpCamposParametros();
        try {
            param = this.camposParametrosIFacade.findCampoParamById(idCampo);
            campos.add(param);
            response.setParametros(campos);
            response.setResponse(respon);
        }catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
            respon.setReturnCode("99");
            respon.setDescripcion(e.getCause().getCause().toString());
            respon.setMessageCode("Operación no se ");
            response.setResponse(respon);
        }
        return response;
    }
}
