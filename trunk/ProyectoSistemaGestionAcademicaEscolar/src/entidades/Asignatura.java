package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="asignatura")
public class Asignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codasignatura")
	private String strCodigoAsignatura;
	
	@Column(name="nombre")
	private String strNombreAsignatura;
	
	@ManyToMany
	@JoinTable(name="detalleasignatura",
			joinColumns={@JoinColumn(name="codasignatura")},
			inverseJoinColumns={@JoinColumn(name="codalumno")}
	)
	private Collection<Alumno> tbAlumnos;

	public String getStrCodigoAsignatura() {
		return strCodigoAsignatura;
	}

	public void setStrCodigoAsignatura(String strCodigoAsignatura) {
		this.strCodigoAsignatura = strCodigoAsignatura;
	}

	public String getStrNombreAsignatura() {
		return strNombreAsignatura;
	}

	public void setStrNombreAsignatura(String strNombreAsignatura) {
		this.strNombreAsignatura = strNombreAsignatura;
	}

	public Collection<Alumno> getTbAlumnos() {
		return tbAlumnos;
	}

	public void setTbAlumnos(Collection<Alumno> tbAlumnos) {
		this.tbAlumnos = tbAlumnos;
	}
	
}
