package co.com.claro.ocp.facade;

import co.com.claro.ocp.entity.OcpNovBhe;
import co.com.claro.ocp.entity.OcpNovIncLin;
import co.com.claro.ocp.entity.OcpNovOtros;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OcpNovedadesIFacade {

    public void creaBhe(OcpNovBhe bhe);
    public void creaOtros(OcpNovOtros otros);
    public void creaIncLin(OcpNovIncLin incLin);

    public void editBhe(OcpNovBhe bhe);
    public void editOtros(OcpNovOtros otros);
    public void editIncLin(OcpNovIncLin incLin);

    public List<OcpNovBhe> allNovEmpBhe(Long emp);
    public List<OcpNovBhe> allNovProBhe(Long proy);
    public List<OcpNovOtros> allNovEmpOtros(Long emp);
    public List<OcpNovIncLin> allNovIncLin(Long emp);

    public List<OcpNovBhe> mesNovProBhe(Long anio, Long mes);
    public List<OcpNovOtros> mesNovEmpOtros(Long anio, Long mes);
    public List<OcpNovIncLin> mesNovIncLin(Long anio, Long mes);
}
