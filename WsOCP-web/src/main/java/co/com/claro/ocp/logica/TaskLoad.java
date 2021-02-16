package co.com.claro.ocp.logica;

import co.com.claro.ocp.dto.ArchiveRequest;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.NovedadesProyectos;
import co.com.claro.ocp.facade.NovedadesEmpleadosIFacade;
import co.com.claro.ocp.facade.NovedadesProyectosIFacade;
import lombok.*;

import javax.ejb.EJB;
import javax.ejb.TransactionManagement;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@TransactionManagement
public class TaskLoad implements Runnable{

    @EJB
    NovedadesEmpleadosIFacade empleadosIFacade;

    @EJB
    NovedadesProyectosIFacade proyectosIFacade;

    @Getter
    @Setter
    private ArchiveRequest archivo;

    @Override

    public void run() {
        System.out.println("task ok");
        try{
            byte[] data = Base64.getDecoder().decode(archivo.getArchivo().getBytes(StandardCharsets.UTF_8));
            File file = new File("./" + archivo.getNombre() + "."+ archivo.getTipo());
            OutputStream stream = new FileOutputStream(file);
            stream.write(data);
            stream.close();
            //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader(file);
            //Leemos el fichero y lo mostramos por pantalla
            BufferedReader bf = new BufferedReader(fr);
            String valor = "";
            while((valor = bf.readLine()) != null){
                NovedadesProyectos proyectos = new NovedadesProyectos();
                NovedadesEmpleados empleados = new NovedadesEmpleados();
                System.out.print("datp");
                String[] valor3 = valor.split("\\;");
                if (archivo.getNovedad().equals("proyecto")){
                    //proyectos.setId(Long.parseLong(valor3[0]));
                    proyectos.setProyecto(valor3[1]);
                    proyectos.setEstadoDeproyecto(valor3[2]);
                    proyectos.setGerenteSquad(valor3[3]);
                    proyectos.setDireccion(valor3[4]);
                    proyectos.setDatacenter(Long.parseLong(valor3[5]));
                    proyectos.setEquipos(Long.parseLong(valor3[6]));
                    proyectos.setTaxis(Long.parseLong(valor3[7]));
                    proyectos.setCajaMenor(Long.parseLong(valor3[8]));
                    proyectos.setCelulares(Long.parseLong(valor3[9]));
                    proyectos.setExamenMedico(Long.parseLong(valor3[10]));
                    proyectos.setBonosGtes(Long.parseLong(valor3[11]));
                    proyectos.setLicencias365Usd(Long.parseLong(valor3[12]));
                    proyectos.setColumnasAlternativas(valor3[13]);
                    SimpleDateFormat sdf= new SimpleDateFormat ("dd/MM/yy");
                    Date date1  = (Date) sdf.parse(valor3[14]);
                    proyectos.setFechaCreacion(date1);
                    proyectos.setLicencias365Cops(Long.parseLong(valor3[15]));
                }else if (archivo.getNovedad().equals("empleado")){
                    System.out.print("datp");
                    //empleados.setId(Long.parseLong(valor3[0]));
                    empleados.setCodigo(valor3[1]);
                    empleados.setCedula(Long.parseLong(valor3[2]));
                    empleados.setEmpleado(valor3[3]);
                    empleados.setIdProyecto(Long.parseLong(valor3[4]));
                    empleados.setProyecto(valor3[5]);
                    empleados.setEstadoProyecto(valor3[6]);
                    empleados.setGerenteSquad(valor3[7]);
                    empleados.setDireccion(valor3[8]);
                    empleados.setVacaciones(Long.parseLong(valor3[9]));
                    empleados.setAusencias(Long.parseLong(valor3[10]));
                    empleados.setObservaciones(valor3[11]);
                    empleados.setBonos(Long.parseLong(valor3[12]));
                    empleados.setHorasExtras(Long.parseLong(valor3[13]));
                    empleados.setOtrosCostos(Long.parseLong(valor3[14]));
                    empleados.setHorasMes(Long.parseLong(valor3[15]));
                    empleados.setCostoRRHH(Long.parseLong(valor3[16]));
                    empleados.setIncapacidadDias(Long.parseLong(valor3[17]));
                    empleados.setObservacionesNomina(valor3[18]);
                    empleados.setColumnasAlternativas(valor3[19]);

                }else{
                    System.out.println("novedad no asignada en archivo");
                }
                try {
                    if (archivo.getNovedad().equals("proyecto")){
                        this.proyectosIFacade.creaNovedadProyecto(proyectos);
                    }else if (archivo.getNovedad().equals("empleado")){
                        this.empleadosIFacade.crearNovedadEmp(empleados);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    continue;
                }
            }
            //Cerramos el stream;
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
