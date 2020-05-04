package co.com.claro.ocp.facade;

import co.com.claro.ocp.controller.OcpNovBheController;
import co.com.claro.ocp.controller.OcpNovIncLinController;
import co.com.claro.ocp.controller.OcpNovOtrosController;
import co.com.claro.ocp.entity.OcpNovBhe;
import co.com.claro.ocp.entity.OcpNovIncLin;
import co.com.claro.ocp.entity.OcpNovOtros;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OcpNovedadesFacade implements OcpNovedadesIFacade {

    private static final long serialVersionUID = 1L;

    @EJB
    OcpNovBheController bheController;

    @EJB
    OcpNovOtrosController otrosController;

    @EJB
    OcpNovIncLinController incLinController;

    @Override
    public void creaBhe(OcpNovBhe bhe) {
        try{
            bheController.create(bhe);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void creaOtros(OcpNovOtros otros) {
        try{
            otrosController.create(otros);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void creaIncLin(OcpNovIncLin incLin) {
        try{
            incLinController.create(incLin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editBhe(OcpNovBhe bhe) {
        try{
            bheController.edit(bhe);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editOtros(OcpNovOtros otros) {
        try{
            otrosController.edit(otros);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editIncLin(OcpNovIncLin incLin) {
        try{
            incLinController.edit(incLin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OcpNovBhe> allNovEmpBhe(Long emp) {
        return null;
    }

    @Override
    public List<OcpNovBhe> allNovProBhe(Long proy) {
        return null;
    }

    @Override
    public List<OcpNovOtros> allNovEmpOtros(Long emp) {
        return null;
    }

    @Override
    public List<OcpNovIncLin> allNovIncLin(Long emp) {
        return null;
    }

    @Override
    public List<OcpNovBhe> mesNovProBhe(Long anio, Long mes) {
        List<OcpNovBhe> data = new ArrayList<>();
        try {
            data =  bheController.mes( anio,  mes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OcpNovOtros> mesNovEmpOtros(Long anio, Long mes) {
        List<OcpNovOtros> data = new ArrayList<>();
        try {
            data =  otrosController.mes(anio,  mes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<OcpNovIncLin> mesNovIncLin(Long anio, Long mes) {
        List<OcpNovIncLin> data = new ArrayList<>();
        try {
            data =  incLinController.mes(anio,  mes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
