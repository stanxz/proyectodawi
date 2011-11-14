package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the motivo database table.
 * 
 */
@Entity
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codmotivo;

	private String nombre;

	//bi-directional many-to-one association to Detallemotivo
	@OneToMany(mappedBy="motivo")
	private Set<Detallemotivo> detallemotivos;

    public Motivo() {
    }

	public int getCodmotivo() {
		return this.codmotivo;
	}

	public void setCodmotivo(int codmotivo) {
		this.codmotivo = codmotivo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Detallemotivo> getDetallemotivos() {
		return this.detallemotivos;
	}

	public void setDetallemotivos(Set<Detallemotivo> detallemotivos) {
		this.detallemotivos = detallemotivos;
	}
	
}