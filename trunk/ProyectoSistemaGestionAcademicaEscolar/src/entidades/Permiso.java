package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the permiso database table.
 * 
 */
@Entity
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codpermisol")
	private String strCodigoPermiso;
	
	@Column(name="descripcion")
	private String strDescripcion;
	
	@Column(name="nombre")
	private String strNombre;
	
	/*
    @ManyToMany
	@JoinTable(
		name="detalleperfil"
		, joinColumns={
			@JoinColumn(name="CODPERMISO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CODPERFIL")
			}
		)
	*/

	public String getStrCodigoPermiso() {
		return strCodigoPermiso;
	}

	public void setStrCodigoPermiso(String strCodigoPermiso) {
		this.strCodigoPermiso = strCodigoPermiso;
	}

	public String getStrDescripcion() {
		return strDescripcion;
	}

	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}


	
}