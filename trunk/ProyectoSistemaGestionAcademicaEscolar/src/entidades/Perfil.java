package entidades;

import java.io.Serializable;
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
    
    
	
	
}