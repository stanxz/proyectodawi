package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;


/**
 * The persistent class for the seccionprogramada database table.
 * 
 */
@Entity
public class Seccionprogramada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idseccionprogramada")
	private int intIdSeccionProgramada;

	@Column(name="grado")
	private int intGrado;

	@Column(name="nivel")
	private String strNivel;

	@Column(name="seccion")
	private String strSeccion;

	@OneToMany(targetEntity=Matricula.class,mappedBy="seccionprogramada")
	private Collection<Matricula> tbMatriculas;

    public Seccionprogramada() {
    }

	public int getIntIdSeccionProgramada() {
		return intIdSeccionProgramada;
	}

	public void setIntIdSeccionProgramada(int intIdSeccionProgramada) {
		this.intIdSeccionProgramada = intIdSeccionProgramada;
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

	public String getStrSeccion() {
		return strSeccion;
	}

	public void setStrSeccion(String strSeccion) {
		this.strSeccion = strSeccion;
	}

	public Collection<Matricula> getTbMatriculas() {
		return tbMatriculas;
	}

	public void setTbMatriculas(Collection<Matricula> tbMatriculas) {
		this.tbMatriculas = tbMatriculas;
	}

}