package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the seccionprogramada database table.
 * 
 */
@Entity
public class Seccionprogramada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idseccionprogramada;

	private int grado;

	private String nivel;

	private String seccion;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="seccionprogramada")
	private Set<Matricula> matriculas;

    public Seccionprogramada() {
    }

	public int getIdseccionprogramada() {
		return this.idseccionprogramada;
	}

	public void setIdseccionprogramada(int idseccionprogramada) {
		this.idseccionprogramada = idseccionprogramada;
	}

	public int getGrado() {
		return this.grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getSeccion() {
		return this.seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Set<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}