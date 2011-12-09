package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the calendarioacademico database table.
 * 
 */
@Entity
@Table(name="calendarioacademico")
public class Calendarioacademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codcalendario")
	private String strCodcalendario;
	
	/*@OneToMany(targetEntity=Alumno.class,mappedBy="calendarioacademico")
	private Collection<Alumno> tbAlumnos;*/
	

	public String getStrCodcalendario() {
		return strCodcalendario;
	}

	public void setStrCodcalendario(String strCodcalendario) {
		this.strCodcalendario = strCodcalendario;
	}

	/*public Collection<Alumno> getTbAlumnos() {
		return tbAlumnos;
	}

	public void setTbAlumnos(Collection<Alumno> tbAlumnos) {
		this.tbAlumnos = tbAlumnos;
	}*/

	//bi-directional many-to-one association to Actividad
	/*@OneToMany(mappedBy="calendarioacademico")
	private Set<Actividad> actividads;*/

	
	


	/*public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}*/
	
	
}