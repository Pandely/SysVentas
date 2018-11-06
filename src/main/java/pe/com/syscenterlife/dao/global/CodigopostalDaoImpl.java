/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloCodigopostal;

/**
 *
 * @author pc
 */
@Repository
public class CodigopostalDaoImpl extends SysDataAccess<Integer, GloCodigopostal> implements CodigopostalDaoI
{
  @SuppressWarnings("unchecked")
  @Override
    public List<GloCodigopostal> listarEntidad(){return getListAll();}

}
