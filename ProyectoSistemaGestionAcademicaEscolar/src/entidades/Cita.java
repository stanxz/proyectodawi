package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codcita;

	private String correopersonal;

	private String estado;

    @Temporal( TemporalType.DATE)
	private Date fecharegistro;

	private String tlfcelular;

	private String tlffijo;

	//bi-directional many-to-one association to Certificadoa
	@OneToMany(mappedBy="cita")
	private Set<Certificadoa> certificadoas;

	//bi-directional many-to-one association to Alumno
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Horario
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODASISTENTASOCIAL", referencedColumnName="CODASISTENTASOCIAL"),
		@JoinColumn(name="CODDISPONIBILIDADAS", referencedColumnName="CODDISPONIBILIDADAS")
		})
	private Horario horario;

	//bi-directional many-to-one association to Tiposervicioa
    @ManyToOne
	@JoinColumn(name="CODTIPOSERVICIO")
	private Tiposervicioa tiposervicioa;

    public Cita() {
    }

	public int getCodcita() {
		return this.codcita;
	}

	public void setCodcita(int codcita) {
		this.codcita = codcita;
	}

	public String getCorreopersonal() {
		return this.correopersonal;
	}

	public void setCorreopersonal(String correopersonal) {
		this.correopersonal = correopersonal;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getTlfcelular() {
		return this.tlfcelular;
	}

	public void setTlfcelular(String tlfcelular) {
		this.tlfcelular = tlfcelular;
	}

	public String getTlffijo() {
		return this.tlffijo;
	}

	public void setTlffijo(String tlffijo) {
		this.tlffijo = tlffijo;
	}

	public Set<Certificadoa> getCertificadoas() {
		return this.certificadoas;
	}

	public void setCertificadoas(Set<Certificadoa> certificadoas) {
		this.certificadoas = certificadoas;
	}
	
	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	public Tiposervicioa getTiposervicioa() {
		return this.tiposervicioa;
	}

	public void setTiposervicioa(Tiposervicioa tiposervicioa) {
		this.tiposervicioa = tiposervicioa;
	}
	
}