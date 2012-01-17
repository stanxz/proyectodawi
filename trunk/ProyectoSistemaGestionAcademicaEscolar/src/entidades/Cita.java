package entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cita")

public class Cita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codcita")
	private int intcodcita;
	
	//@Column(name="codalumno")
	//private String strCodigoAlumno;
	
	@Column(name="codtiposervicio")
	private int intcodtiposervicio;
	
	@Column(name="codasistentasocial")
	private String strcodasistentasocial;
	
	@Column(name="correopersonal")
	private String strMail;
	
	@Column(name="tlffijo")
	private String strtlffijo;
	
	@Column(name="tlfcelular")
	private String tlfcelular;
	
	@Column(name="fecharegistro")
	private Timestamp dtfecharegistro;
	
	@Column(name="estado")
	private String strestado;
	
	@Column(name="coddisponibilidadas")
	private String strcoddisponibilidadas;
	
    @ManyToOne
	@JoinColumn(name="CODALUMNO")
    private Alumno alumno=new Alumno();

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getIntcodcita() {
		return intcodcita;
	}

	public void setIntcodcita(int intcodcita) {
		this.intcodcita = intcodcita;
	}

	/*public String getStrCodigoAlumno() {
		return strCodigoAlumno;
	}

	public void setStrCodigoAlumno(String strCodigoAlumno) {
		this.strCodigoAlumno = strCodigoAlumno;
	}*/

	public int getIntcodtiposervicio() {
		return intcodtiposervicio;
	}

	public void setIntcodtiposervicio(int intcodtiposervicio) {
		this.intcodtiposervicio = intcodtiposervicio;
	}

	public String getStrcodasistentasocial() {
		return strcodasistentasocial;
	}

	public void setStrcodasistentasocial(String strcodasistentasocial) {
		this.strcodasistentasocial = strcodasistentasocial;
	}

	public String getStrMail() {
		return strMail;
	}

	public void setStrMail(String strMail) {
		this.strMail = strMail;
	}

	public String getStrtlffijo() {
		return strtlffijo;
	}

	public void setStrtlffijo(String strtlffijo) {
		this.strtlffijo = strtlffijo;
	}

	public String getTlfcelular() {
		return tlfcelular;
	}

	public void setTlfcelular(String tlfcelular) {
		this.tlfcelular = tlfcelular;
	}

	public Timestamp getDtfecharegistro() {
		return dtfecharegistro;
	}

	public void setDtfecharegistro(Timestamp timestamp) {
		this.dtfecharegistro = timestamp;
	}

	public String getStrestado() {
		return strestado;
	}

	public void setStrestado(String strestado) {
		this.strestado = strestado;
	}

	public String getStrcoddisponibilidadas() {
		return strcoddisponibilidadas;
	}

	public void setStrcoddisponibilidadas(String strcoddisponibilidadas) {
		this.strcoddisponibilidadas = strcoddisponibilidadas;
	}
	
	
	
	

}
