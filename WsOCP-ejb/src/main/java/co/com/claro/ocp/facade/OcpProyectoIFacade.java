package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpProyecto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpProyectoIFacade {

    public void createProject(OcpProyecto proyecto);

    public void editProject(OcpProyecto proyecto);

    public void  deleteProject(OcpProyecto proyecto);

    public List<OcpProyecto> allProjects();

    public OcpProyecto projectById(Long id);

}
