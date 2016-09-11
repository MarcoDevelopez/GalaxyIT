package com.galaxybis.galaxyit.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class BasicMB {

FacesMessage message = null;
	
	public BasicMB() {
	}
	
	protected void msgAviso(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", msg);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	protected void msgError(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	protected void msgAlerta(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", msg);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
