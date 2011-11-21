package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity 
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codperfil;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Permiso
	@ManyToMany(mappedBy="perfils")
	private Set<Permiso> permisos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfil")
	private Set<Usuario> usuarios;

    public Perfil() {
    }

	public String getCodperfil() {
		return this.codperfil;
	}

	public void setCodperfil(String codperfil) {
		this.codperfil = codperfil;
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

	public Set<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}