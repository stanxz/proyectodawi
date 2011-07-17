package sermeden.java.bean;

import java.io.Serializable;

public class MenuDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String idFuncionalidad;
	private String descripcion;
    private String enlace;
	public String getIdFuncionalidad() {
		return idFuncionalidad;
	}
	public void setIdFuncionalidad(String idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
    
    
    
	
}
