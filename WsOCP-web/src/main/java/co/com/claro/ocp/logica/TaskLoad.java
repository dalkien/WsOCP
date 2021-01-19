package co.com.claro.ocp.logica;

import co.com.claro.ocp.dto.ArchiveRequest;
import co.com.claro.ocp.entity.NovedadesEmpleados;
import co.com.claro.ocp.entity.NovedadesProyectos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;

@NoArgsConstructor
public class TaskLoad implements Runnable{

    @Getter
    @Setter
    private ArchiveRequest archivo;

    @Override

    public void run() {
        System.out.println("task ok");
        try{
            File file = new File("./" + archivo.getNombre() + "."+ archivo.getTipo());
            archivo.setArchivo("MzttYXVyaWNpbzsyODtnYXk=");
            byte[] decoder = Base64.getDecoder().decode(archivo.getArchivo());
            FileOutputStream fileOut = new FileOutputStream(file);
            fileOut.write(decoder);
            fileOut.close();
            //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("./" + archivo.getNombre() + "."+ archivo.getTipo());
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                NovedadesProyectos proyectos = new NovedadesProyectos();
                NovedadesEmpleados empleados = new NovedadesEmpleados();
                System.out.print("datp");
                String valor2 =String.valueOf((char) valor);
                String[] valor3 = valor2.split("\\;");
                if (archivo.getNovedad().equals("proyecto")){
                    proyectos.setId(Long.parseLong(valor3[0]));
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
                    empleados.setId(Long.parseLong(valor3[0]));
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
                }else{
                    System.out.println("novedad no asignada en archivo");
                }
            }
            //Cerramos el stream;
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
