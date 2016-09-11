package com.galaxybis.galaxyit.model;

public class Empleado extends BasicObject {

	private static final long serialVersionUID = 1L;
	
	private String	nombres;
	private String	apellidos;
	private String	direccion;
	private String	pais;
	private String	situacion;
	
	public Empleado() {
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	@Override
	public String toString() {
		return "Empleado [nombres=" + nombres + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", pais=" + pais + ", situacion="
				+ situacion + "]";
	}
	
}
