package sermeden.java.bean;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class CitaDTO extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4371069024427426690L;
	private int idCita;
	private int idFicha;
	private transient Date fechaCita;
	private double HoraCita;
	private int NroConsultorio;
	private int idMedico;
	
	
	
	public Date getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public int getIdFicha() {
		return idFicha;
	}
	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}

	
	public double getHoraCita() {
		return HoraCita;
	}
	public void setHoraCita(double horaCita) {
		HoraCita = horaCita;
	}
	public int getNroConsultorio() {
		return NroConsultorio;
	}
	public void setNroConsultorio(int nroConsultorio) {
		NroConsultorio = nroConsultorio;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	
	
}
