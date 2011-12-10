package entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the calendarioacademico database table.
 * 
 */
@Entity
@Table(name="calendarioacademico")
public class Calendarioacademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codcalendario")
	private String strCodcalendario;
	
	@OneToMany(targetEntity=Matricula.class,mappedBy="calendarioacademico")
	private Collection<Matricula> tbMatriculas;
	

	public String getStrCodcalendario() {
		return strCodcalendario;
	}

	public void setStrCodcalendario(String strCodcalendario) {
		this.strCodcalendario = strCodcalendario;
	}

	public Collection<Matricula> getTbMatriculas() {
		return tbMatriculas;
	}

	public void setTbMatriculas(Collection<Matricula> tbMatriculas) {
		this.tbMatriculas = tbMatriculas;
	}

}