package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the restriccion database table.
 * 
 */
@Entity
public class Restriccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codrestriccion;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Detallerestriccion
	@OneToMany(mappedBy="restriccion")
	private Set<Detallerestriccion> detallerestriccions;

    public Restriccion() {
    }

	public int getCodrestriccion() {
		return this.codrestriccion;
	}

	public void setCodrestriccion(int codrestriccion) {
		this.codrestriccion = codrestriccion;
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

	public Set<Detallerestriccion> getDetallerestriccions() {
		return this.detallerestriccions;
	}

	public void setDetallerestriccions(Set<Detallerestriccion> detallerestriccions) {
		this.detallerestriccions = detallerestriccions;
	}
	
}