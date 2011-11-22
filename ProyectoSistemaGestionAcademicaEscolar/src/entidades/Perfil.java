package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;



/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity 
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codperfil")
	private String strCodigoPerfil;
	
	@Column(name="descripcion")
	private String strDescripcion;
	
	@Column(name="nombre")
	private String strNombre;
	
/*	@OneToMany(targetEntity=Usuario.class,mappedBy="perfiles")
	private Collection<Usuario> tbUsuarios;
	
	@ManyToMany
	@JoinTable(name="detalleperfil",
			joinColumns={@JoinColumn(name="codperfil")},
			inverseJoinColumns={@JoinColumn(name="codpermiso")}
	)
	private Collection<Permiso> tbPermisos;

*/
    public Perfil() {
    }


	public String getStrCodigoPerfil() {
		return strCodigoPerfil;
	}


	public void setStrCodigoPerfil(String strCodigoPerfil) {
		this.strCodigoPerfil = strCodigoPerfil;
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


	/*public Collection<Usuario> getTbUsuarios() {
		return tbUsuarios;
	}


	public void setTbUsuarios(Collection<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}*/

/*
	public Collection<Permiso> getTbPermisos() {
		return tbPermisos;
	}


	public void setTbPermisos(Collection<Permiso> tbPermisos) {
		this.tbPermisos = tbPermisos;
	}
    */
    
	
	
}