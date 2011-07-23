package sermeden.java.bean;

import java.io.Serializable;

public class DMPacienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPersona;
	private int Cefalea;
	private int Asma;
	private int Alergia;
	private int Otros;
	private String Especificacion;
	private String Peso;
	private String Talla;
	private String PresionArterial;
	private String GrupoSanguineo;
	private String Observaciones;
	private int idDMPaciente;
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getCefalea() {
		return Cefalea;
	}
	public void setCefalea(int cefalea) {
		Cefalea = cefalea;
	}
	public int getAsma() {
		return Asma;
	}
	public void setAsma(int asma) {
		Asma = asma;
	}
	public int getAlergia() {
		return Alergia;
	}
	public void setAlergia(int alergia) {
		Alergia = alergia;
	}
	public int getOtros() {
		return Otros;
	}
	public void setOtros(int otros) {
		Otros = otros;
	}
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
