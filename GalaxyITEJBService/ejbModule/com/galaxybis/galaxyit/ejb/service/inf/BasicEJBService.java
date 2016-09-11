package com.galaxybis.galaxyit.ejb.service.inf;

import java.io.Serializable;
import java.util.List;

import com.galaxybis.galaxyit.ejb.service.exception.EJBServiceException;

public interface BasicEJBService<T extends Serializable> {

	public boolean insertar(T prmObject) throws EJBServiceException;
	
	public boolean actualizar(T prmObject) throws EJBServiceException;
	
	public boolean eliminar(T prmObject) throws EJBServiceException;
	
	public List<T> lista() throws EJBServiceException;
	
}
