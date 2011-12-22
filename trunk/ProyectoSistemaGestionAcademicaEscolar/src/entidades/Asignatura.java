package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="asignatura")
public class Asignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codasignatura")
	private int intCodigoAsignatura;
	
	@Column(name="nombre")
	private String strNombreAsignatura;
	
	@Column(name="estado")
	private String strEstado;
	
	@Column(name="grado")
	private int intGrado;
	
	@Transient
	private String strNivel;
	
	/*
	@ManyToMany
	@JoinTable(name="detalleasignatura",
			joinColumns={@JoinColumn(name="codasignatura")},
			inverseJoinColumns={@JoinColumn(name="codalumno")}
	)
	private Collection<Alumno> tbAlumnos;
    */
	
	public int getIntCodigoAsignatura() {
		return intCodigoAsignatura;
	}

	public void setIntCodigoAsignatura(int intCodigoAsignatura) {
		this.intCodigoAsignatura = intCodigoAsignatura;
	}

	public String getStrNombreAsignatura() {
		return strNombreAsignatura;
	}

	public void setStrNombreAsignatura(String strNombreAsignatura) {
		this.strNombreAsignatura = strNombreAsignatura;
	}
	/*
	public Collection<Alumno> getTbAlumnos() {
		return tbAlumnos;
	}

	public void setTbAlumnos(Collection<Alumno> tbAlumnos) {
		this.tbAlumnos = tbAlumnos;
	}
	*/
	public String getStrEstado() {
		return strEstado;
	}
	
	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public int getIntGrado() {
		return intGrado;
	}

	public void setIntGrado(int intGrado) {
		this.intGrado = intGrado;
	}

	public String getStrNivel() {
		return strNivel;
	}

	public void setStrNivel(String strNivel) {
		this.strNivel = strNivel;
	}
}
