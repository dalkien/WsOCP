package co.com.claro.ocp.ws;

import co.com.claro.ocp.controller.*;
import co.com.claro.ocp.dto.*;
import co.com.claro.ocp.entity.*;
import co.com.claro.ocp.facade.NovedadesEmpleadosIFacade;
import co.com.claro.ocp.facade.NovedadesProyectosIFacade;
import co.com.claro.ocp.facade.OcpBaseEmpleadosIFacade;
import co.com.claro.ocp.facade.OcpNovedadesIFacade;
import co.com.claro.ocp.logica.TaskLoad;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ws.rs.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Path("OCPNovedades")
@Stateless
@TransactionManagement
public class OCPNovedadesRest {

    @EJB
    OcpNovedadesIFacade novedadesIFacade;

    @EJB
    OcpBaseEmpleadosIFacade empleadosIFacade;

    @EJB
    OcpProyectoController proyectoController;
    @EJB
    OcpParametrosController parametrosController;

    @EJB
    NovedadesEmpleadosIFacade novedadesEmpleadosIFacade;

    @EJB
    NovedadesProyectosIFacade novedadesProyectosIFacade;

    public OCPNovedadesRest() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("cargarLista")
    public GenericResponse getAllListParam(ArchiveRequest file) {
        TaskLoad task = new TaskLoad();
        task.setEmpleadosIFacade(novedadesEmpleadosIFacade);
        task.setProyectosIFacade(novedadesProyectosIFacade);
        GenericResponse generic = new GenericResponse("Ok","Ok","00");
        try {
            task.setArchivo(file);
            task.run();
        }catch (Exception e){
            e.printStackTrace();
            generic.setReturnCode("99");
            generic.setDescripcion(e.getCause().getCause().toString());
            generic.setMessageCode("falla en tarea programada. ");
        }
        return generic;

    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("allNovedadesMes")
    public List<OcpNovedadesResponse> allNovedades(@QueryParam("anio") Long anio, @QueryParam("mes") Long mes) {
        Date date = new Date();
        LocalDate fecha = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = fecha.getMonthValue();
        //System.out.println(fecha);
        anio = anio != null ? anio : new Long(2019);
        mes = mes != null ? mes : new Long(10);
        List<OcpNovedadesResponse> respuesta = new ArrayList<>();
        try {
            List<OcpNovBhe> bhes = novedadesIFacade.mesNovProBhe(anio, mes);
            List<OcpNovIncLin> incLins = novedadesIFacade.mesNovIncLin(anio, mes);
            List<OcpNovOtros> otros = novedadesIFacade.mesNovEmpOtros(anio, mes);
            List<Long> emple = new ArrayList<>();
            List<Long> proy = new ArrayList<>();
            GenericResponse rpnse = new GenericResponse("OK", "OK", "00");
            bhes.stream().forEach((x) -> proy.add(x.getIdProyecto()));
            bhes.stream().forEach((x) -> emple.add(x.getCodEmpleado()));
            otros.stream().forEach((x) -> emple.add(x.getCodEmpleado()));
            incLins.stream().forEach((x) -> emple.add(x.getCodEmpleado()));
            Set<Long> proys = new HashSet<Long>(proy);
            Set<Long> emples = new HashSet<Long>(emple);
            for (Long em : emples) {
                OcpBaseEmpleados emplado = empleadosIFacade.getEmpleado(em);
                OcpNovedadesResponse dato = new OcpNovedadesResponse();
                List<OcpNovBhe> bhes1 = bhes.stream()
                        .filter((x) -> em.equals(x.getCodEmpleado()))
                        .collect(Collectors.toList());
                List<OcpNovIncLin> incLins1 = incLins.stream()
                        .filter((y) -> em.equals(y.getCodEmpleado()))
                        .collect(Collectors.toList());
                List<OcpNovOtros> otros1 = otros.stream()
                        .filter((z) -> em.equals(z.getCodEmpleado()))
                        .collect(Collectors.toList());
                dato.setCodigo(em);
                dato.setTipo("empleado");
                dato.setNovBhes(bhes1);
                dato.setNovIncLins(incLins1);
                dato.setNovOtros(otros1);
                dato.setEmpleado(emplado);
                dato.setDesProyecto(new OcpParametros());
                dato.setProyectos(new OcpProyecto());
                respuesta.add(dato);
            }
            for (Long py : proys) {
                OcpParametros desproy = parametrosController.findParam(py.toString());
                OcpProyecto proyecto = proyectoController.proyectoById(py);
                List<OcpNovIncLin> incLins1 = new ArrayList<>();
                List<OcpNovOtros> otros1 = new ArrayList<>();
                OcpNovedadesResponse dato = new OcpNovedadesResponse();
                List<OcpNovBhe> bhes1 = bhes.stream()
                        .filter((x) -> py.equals(x.getIdProyecto()))
                        .collect(Collectors.toList());
                dato.setCodigo(py);
                dato.setTipo("proyecto");
                dato.setNovBhes(bhes1);
                dato.setNovIncLins(incLins1);
                dato.setNovOtros(otros1);
                dato.setProyectos(proyecto);
                dato.setDesProyecto(desproy);
                dato.setEmpleado(new OcpBaseEmpleados());
                respuesta.add(dato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @GET
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("novedadesEmpleados")
    public NovedadesEmpleadosResponse allNovedadesEmpleado(){
        NovedadesEmpleadosResponse response = new NovedadesEmpleadosResponse();
        GenericResponse generic = new GenericResponse("OK", "OK", "00");
        List<NovedadesEmpleados> emp = new ArrayList<>();
        try {
            emp= this.novedadesEmpleadosIFacade.allNovedadEmpleados();
            response.setNovedadesEmpleados(emp);
            response.setResponse(generic);
        }catch (Exception e){
            e.printStackTrace();
            generic.setReturnCode("99");
            generic.setDescripcion(e.getCause().getCause().toString());
            generic.setMessageCode("Operación no se ");
            response.setResponse(generic);
        }
        return response;
    }

    @GET
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("novedadesProyectos")
    public NovedadesProyectosResponse allNovedadesProyecto(){
        NovedadesProyectosResponse response = new NovedadesProyectosResponse();
        GenericResponse generic = new GenericResponse("OK", "OK", "00");
        List<NovedadesProyectos> proy = new ArrayList<>();
        try {
            proy= this.novedadesProyectosIFacade.allNovedadesP();
            response.setNovedadesProyectos(proy);
            response.setResponse(generic);
        }catch (Exception e){
            e.printStackTrace();
            generic.setReturnCode("99");
            generic.setDescripcion(e.getCause().getCause().toString());
            generic.setMessageCode("Operación no se ");
            response.setResponse(generic);
        }
        return response;
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("actualizaNovedadEmpleados")
    public GenericResponse actualizaEmpleado( NovedadesEmpleados emp ){
        GenericResponse response= new GenericResponse("OK", "OK", "00");
        try {
            this.novedadesEmpleadosIFacade.actualizaNovedadEmp(emp);
        }catch (Exception e){
            e.printStackTrace();
            response.setReturnCode("99");
            response.setDescripcion(e.getCause().getCause().toString());
            response.setMessageCode("Operación no se ");
        }
        return response;
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("actualizaNovedadProyectos")
    public GenericResponse actualizaProyecto( NovedadesProyectos proy ){
        GenericResponse response= new GenericResponse("OK", "OK", "00");
        try {
            this.novedadesProyectosIFacade.actuaizaNovedadProyecto(proy);
        }catch (Exception e){
            e.printStackTrace();
            response.setReturnCode("99");
            response.setDescripcion(e.getCause().getCause().toString());
            response.setMessageCode("Operación no se ");
        }
        return response;
    }


    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("creaNovedadProyectos")
    public GenericResponse creaProyecto( NovedadesProyectos proy ){
        GenericResponse response= new GenericResponse("OK", "OK", "00");
        try {
            this.novedadesProyectosIFacade.creaNovedadProyecto(proy);
        }catch (Exception e){
            e.printStackTrace();
            response.setReturnCode("99");
            response.setDescripcion(e.getCause().getCause().toString());
            response.setMessageCode("Operación no se ");
        }
        return response;
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("creaNovedadEmpleados")
    public GenericResponse creaEmpleado( NovedadesEmpleados emp ){
        GenericResponse response= new GenericResponse("OK", "OK", "00");
        try {
            this.novedadesEmpleadosIFacade.crearNovedadEmp(emp);
        }catch (Exception e){
            e.printStackTrace();
            response.setReturnCode("99");
            response.setDescripcion(e.getCause().getCause().toString());
            response.setMessageCode("Operación no se ");
        }
        return response;
    }
}
