package com.galaxybis.galaxyit.model;
import java.io.Serializable;
import java.sql.Timestamp;


public class BasicObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long			id;
	private String		estado;
	private long			usuarioCreacion;
	private Timestamp	fechaCreacion;
	private long			usuarioModificacion;
	private Timestamp	fechaModificacion;
	private boolean		sw;
	
	public BasicObject() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(long usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(long usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isSw() {
		return sw;
	}

	public void setSw(boolean sw) {
		this.sw = sw;
	}

	@Override
	public String toString() {
		return "BasicObject [id=" + id + ", estado=" + estado
				+ ", usuarioCreacion=" + usuarioCreacion + ", fechaCreacion="
				+ fechaCreacion + ", usuarioModificacion=" + usuarioModificacion
				+ ", fechaModificacion=" + fechaModificacion + ", sw=" + sw + "]";
	}
	
}
