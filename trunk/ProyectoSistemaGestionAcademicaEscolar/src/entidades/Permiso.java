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
	private String codpermiso;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Perfil
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
	private Set<Perfil> perfils;

    public Permiso() {
    }

	public String getCodpermiso() {
		return this.codpermiso;
	}

	public void setCodpermiso(String codpermiso) {
		this.codpermiso = codpermiso;
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

	public Set<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(Set<Perfil> perfils) {
		this.perfils = perfils;
	}
	
}