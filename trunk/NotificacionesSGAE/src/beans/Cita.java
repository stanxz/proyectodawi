package beans;

import java.sql.Timestamp;

public class Cita {

	private int intCodCita;
	private String strCodAlumno;
	private int intCodTipoServicio;
	private String strCorreoPersonal;
	private String strTelfFijo;
	private String strTelfCelular;
	private Timestamp tsFechaRegistro;
	private String strEstado;
	private String strCodDisponibilidadas;
	private String strCodAsistenciaSocial;
	public int getIntCodCita() {
		return intCodCita;
	}
	public void setIntCodCita(int intCodCita) {
		this.intCodCita = intCodCita;
	}
	public String getStrCodAlumno() {
		return strCodAlumno;
	}
	public void setStrCodAlumno(String strCodAlumno) {
		this.strCodAlumno = strCodAlumno;
	}
	public int getIntCodTipoServicio() {
		return intCodTipoServicio;
	}
	public void setIntCodTipoServicio(int intCodTipoServicio) {
		this.intCodTipoServicio = intCodTipoServicio;
	}
	public String getStrCorreoPersonal() {
		return strCorreoPersonal;
	}
	public void setStrCorreoPersonal(String strCorreoPersonal) {
		this.strCorreoPersonal = strCorreoPersonal;
	}
	public String getStrTelfFijo() {
		return strTelfFijo;
	}
	public void setStrTelfFijo(String strTelfFijo) {
		this.strTelfFijo = strTelfFijo;
	}
	public String getStrTelfCelular() {
		return strTelfCelular;
	}
	public void setStrTelfCelular(String strTelfCelular) {
		this.strTelfCelular = strTelfCelular;
	}
	public Timestamp getTsFechaRegistro() {
		return tsFechaRegistro;
	}
	public void setTsFechaRegistro(Timestamp tsFechaRegistro) {
		this.tsFechaRegistro = tsFechaRegistro;
	}
	public String getStrEstado() {
		return strEstado;
	}
	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}
	public String getStrCodDisponibilidadas() {
		return strCodDisponibilidadas;
	}
	public void setStrCodDisponibilidadas(String strCodDisponibilidadas) {
		this.strCodDisponibilidadas = strCodDisponibilidadas;
	}
	public String getStrCodAsistenciaSocial() {
		return strCodAsistenciaSocial;
	}
	public void setStrCodAsistenciaSocial(String strCodAsistenciaSocial) {
		this.strCodAsistenciaSocial = strCodAsistenciaSocial;
	}
	
	
}
