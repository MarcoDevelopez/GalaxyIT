package com.galaxybis.galaxyit.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.galaxybis.galaxyit.ejb.dao.exception.EJBDAOException;
import com.galaxybis.galaxyit.ejb.dao.inf.EmpleadoEJBDAOLocal;
import com.galaxybis.galaxyit.ejb.service.exception.EJBServiceException;
import com.galaxybis.galaxyit.ejb.service.inf.EmpleadoEJBServiceLocal;
import com.galaxybis.galaxyit.model.Empleado;

@Stateless
public class EmpleadoEJBServiceImpl extends BasicEJBServiceImpl<Empleado> implements EmpleadoEJBServiceLocal {
	
	@EJB(lookup = "java:global/GalaxyITEAR/GalaxyITEJBDAO/EmpleadoEJBDAOImpl!com.galaxybis.galaxyit.ejb.dao.inf.EmpleadoEJBDAOLocal")
	private EmpleadoEJBDAOLocal empleadoEJBDAOLocal;

	@Override
	public boolean insertar(Empleado prmEmpleado) throws EJBServiceException {
		try {
			return this.getEmpleadoEJBDAOLocal().insertar(prmEmpleado);
		} catch (EJBDAOException e) {
			throw new EJBServiceException(e);
		}
	}

	@Override
	public boolean actualizar(Empleado prmEmpleado) throws EJBServiceException {
		try {
			return this.getEmpleadoEJBDAOLocal().actualizar(prmEmpleado);
		} catch (EJBDAOException e) {
			throw new EJBServiceException(e);
		}
	}

	@Override
	public boolean eliminar(Empleado prmEmpleado) throws EJBServiceException {
		try {
			return this.getEmpleadoEJBDAOLocal().eliminar(prmEmpleado);
		} catch (EJBDAOException e) {
			throw new EJBServiceException(e);
		}
	}

	@Override
	public List<Empleado> lista() throws EJBServiceException {
		try {
			return this.getEmpleadoEJBDAOLocal().lista();
		} catch (EJBDAOException e) {
			throw new EJBServiceException(e);
		}
	}

	public EmpleadoEJBDAOLocal getEmpleadoEJBDAOLocal() {
		return empleadoEJBDAOLocal;
	}

	public void setEmpleadoEJBDAOLocal(EmpleadoEJBDAOLocal empleadoEJBDAOLocal) {
		this.empleadoEJBDAOLocal = empleadoEJBDAOLocal;
	}

}
