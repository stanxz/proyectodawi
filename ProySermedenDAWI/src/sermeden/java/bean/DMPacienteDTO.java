package sermeden.java.bean;

import java.io.Serializable;

public class DMPacienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPersona;
	/*private String Cefalea;
	private String Asma;
	private String Alergia;
	private String Otros;*/
	private boolean Cefalea;
	private boolean Asma;
	private boolean Alergia;
	private boolean Otros;
	private String Especificacion;
	private String Peso;
	private String Talla;
	private String PresionArterial;
	private String GrupoSanguineo;
	private String Observaciones;
	private int idDMPaciente;
	private String dni;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	
	
	public boolean isCefalea() {
		return Cefalea;
	}
	public void setCefalea(boolean cefalea) {
		Cefalea = cefalea;
	}
	public boolean isAsma() {
		return Asma;
	}
	public void setAsma(boolean asma) {
		Asma = asma;
	}
	public boolean isAlergia() {
		return Alergia;
	}
	public void setAlergia(boolean alergia) {
		Alergia = alergia;
	}
	public boolean isOtros() {
		return Otros;
	}
	public void setOtros(boolean otros) {
		Otros = otros;
	}
	/*public String getCefalea() {
		return Cefalea;
	}
	public void setCefalea(String cefalea) {
		Cefalea = cefalea;
	}
	public String getAsma() {
		return Asma;
	}
	public void setAsma(String asma) {
		Asma = asma;
	}
	public String getAlergia() {
		return Alergia;
	}
	public void setAlergia(String alergia) {
		Alergia = alergia;
	}
	public String getOtros() {
		return Otros;
	}
	public void setOtros(String otros) {
		Otros = otros;
	}*/
	public String getEspecificacion() {
		return Especificacion;
	}
	public void setEspecificacion(String especificacion) {
		Especificacion = especificacion;
	}
	public String getPeso() {
		return Peso;
	}
	public void setPeso(String peso) {
		Peso = peso;
	}
	public String getTalla() {
		return Talla;
	}
	public void setTalla(String talla) {
		Talla = talla;
	}
	public String getPresionArterial() {
		return PresionArterial;
	}
	public void setPresionArterial(String presionArterial) {
		PresionArterial = presionArterial;
	}
	public String getGrupoSanguineo() {
		return GrupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		GrupoSanguineo = grupoSanguineo;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public int getIdDMPaciente() {
		return idDMPaciente;
	}
	public void setIdDMPaciente(int idDMPaciente) {
		this.idDMPaciente = idDMPaciente;
	}
	
	
}
