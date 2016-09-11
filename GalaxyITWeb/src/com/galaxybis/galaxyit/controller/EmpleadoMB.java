package com.galaxybis.galaxyit.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.galaxybis.galaxyit.ejb.service.exception.EJBServiceException;
import com.galaxybis.galaxyit.ejb.service.inf.EmpleadoEJBServiceLocal;
import com.galaxybis.galaxyit.model.Empleado;

@ManagedBean
@SessionScoped
public class EmpleadoMB extends BasicMB {

	@EJB(lookup = "java:global/GalaxyITEAR/GalaxyITEJBService/EmpleadoEJBServiceImpl!com.galaxybis.galaxyit.ejb.service.inf.EmpleadoEJBServiceLocal")
	private EmpleadoEJBServiceLocal	empleadoEJBServiceLocal;
	private List<Empleado>					empleados;
	private Empleado								empleado;
	
	@PostConstruct
	public void init() {
		this.buscar();
	}
	
	public String nuevo() {
		this.setEmpleado(new Empleado());
		return "empleado";
	}
	
	public String modificar(Empleado prmEmpleado) {
		this.setEmpleado(prmEmpleado);
		return "empleado";
	}
	
	public String guardar() {
		String pagina = "empleado";
		boolean sw;
		try {
			if (this.getEmpleado().getId() > 0) {
				sw = empleadoEJBServiceLocal.actualizar(this.getEmpleado());
				if (sw) {
					super.msgAviso("Empleado actualizado con exito.");
					this.setEmpleado(new Empleado());
					pagina = "empleados";
				} else {
					super.msgError("Error al registrar.");
				}
				
			} else {
				boolean ret = empleadoEJBServiceLocal.insertar(this.getEmpleado());
				System.out.println(ret);
				if (ret) {
					super.msgAviso("Empleado registrado con exito.");
					pagina = "empleados";
				} else {
					super.msgError("Error al registrar.");
				}
			}
			
		} catch (EJBServiceException e) {
			e.printStackTrace();
		}
		return pagina;
	}
	
	public void eliminar(Empleado prmEmpleado) {
		try {
			boolean b = empleadoEJBServiceLocal.eliminar(prmEmpleado);
			if (b) {
				super.msgAviso("Empleado eliminado");
				buscar();
			} else {
				super.msgAviso("Error al eliminar");
			}
		} catch (EJBServiceException e) {
			e.printStackTrace();
		}
	}
	
	public void buscar() {
		try {
			empleados = empleadoEJBServiceLocal.lista();
		} catch (EJBServiceException e) {
			e.printStackTrace();
		}
	}

	public EmpleadoEJBServiceLocal getEmpleadoEJBServiceLocal() {
		return empleadoEJBServiceLocal;
	}

	public void setEmpleadoEJBServiceLocal(EmpleadoEJBServiceLocal empleadoEJBServiceLocal) {
		this.empleadoEJBServiceLocal = empleadoEJBServiceLocal;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
