package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tiposervicioas database table.
 * 
 */
@Entity
@Table(name="tiposervicioas")
public class Tiposervicioa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codtiposervicio;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="tiposervicioa")
	private Set<Cita> citas;

    public Tiposervicioa() {
    }

	public int getCodtiposervicio() {
		return this.codtiposervicio;
	}

	public void setCodtiposervicio(int codtiposervicio) {
		this.codtiposervicio = codtiposervicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
	
}