package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;


/**
 * The persistent class for the permiso database table.
 * 
 */
@Entity
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codpermiso")
	private String strCodigoPermiso;
	
	@Column(name="descripcion")
	private String strDescripcion;
	
	@Column(name="nombre")
	private String strNombre;
	
	@Column(name="enlace")
	private String strEnlace;
	
	@ManyToMany
	@JoinTable(name="detalleperfil",
			joinColumns={@JoinColumn(name="codpermiso")},
			inverseJoinColumns={@JoinColumn(name="codperfil")}
	)
	private Collection<Perfil> tbPerfiles;

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

	public String getStrEnlace() {
		return strEnlace;
	}

	public void setStrEnlace(String strEnlace) {
		this.strEnlace = strEnlace;
	}

	public Collection<Perfil> getTbPerfiles() {
		return tbPerfiles;
	}

	public void setTbPerfiles(Collection<Perfil> tbPerfiles) {
		this.tbPerfiles = tbPerfiles;
	}
	
	
}