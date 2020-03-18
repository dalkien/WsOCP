package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpProyectoController;
import co.com.claro.ocp.entity.OcpProyecto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpProyectoFacade implements OcpProyectoIFacade {
    private static final long serialVersionUID = 1L;

    @EJB
    OcpProyectoController proyectoController;

    @Override
    public void createProject(OcpProyecto proyecto){
        try{
            proyectoController.create(proyecto);
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void editProject(OcpProyecto proyecto){
        try{
            proyectoController.edit(proyecto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void  deleteProject(OcpProyecto proyecto){
        try {
            proyectoController.delete(proyecto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OcpProyecto> allProjects(){
        List<OcpProyecto> proyectos = new ArrayList<>();
        try {
            proyectos = proyectoController.allProyectos();
        }catch (Exception e){
            e.printStackTrace();
        }
        return proyectos;
    }

    public OcpProyecto projectById(Long id){
        OcpProyecto proyecto = new OcpProyecto();
        try{
            proyecto = proyectoController.proyectoById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proyecto;
    }
}
