package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calendarioacademico database table.
 * 
 */
@Entity
public class Calendarioacademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codcalendario")
	private String strCodcalendario;

	public String getStrCodcalendario() {
		return strCodcalendario;
	}

	public void setStrCodcalendario(String strCodcalendario) {
		this.strCodcalendario = strCodcalendario;
	}

	//bi-directional many-to-one association to Actividad
	/*@OneToMany(mappedBy="calendarioacademico")
	private Set<Actividad> actividads;*/

	//bi-directional many-to-one association to Alumno
	/*@OneToMany(mappedBy="calendarioacademico")
	private Set<Alumno> alumnos;*/



	/*public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}
	
	public Set<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}*/
	
}