package co.com.claro.ocp.ws;

import co.com.claro.ocp.controller.*;
import co.com.claro.ocp.dto.GenericResponse;
import co.com.claro.ocp.dto.OcpNovedadesResponse;
import co.com.claro.ocp.entity.*;
import co.com.claro.ocp.facade.OcpBaseEmpleadosIFacade;
import co.com.claro.ocp.facade.OcpNovedadesIFacade;

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

    public OCPNovedadesRest() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("cargarLista")
    public GenericResponse getAllListParam(String file) {
        return null;
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
}
