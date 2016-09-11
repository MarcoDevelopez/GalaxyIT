package com.galaxybis.galaxyit.ejb.dao.inf;

import java.io.Serializable;
import java.util.List;

import com.galaxybis.galaxyit.ejb.dao.exception.EJBDAOException;

public interface BasicEJBDAO<T extends Serializable> {

	public boolean insertar(T prmObject) throws EJBDAOException;
	
	public boolean actualizar(T prmObject) throws EJBDAOException;
	
	public boolean eliminar(T prmObject) throws EJBDAOException;
	
	public List<T> lista() throws EJBDAOException;
	
}
