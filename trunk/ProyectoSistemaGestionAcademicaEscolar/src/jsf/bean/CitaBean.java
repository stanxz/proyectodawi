package jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean 
public class CitaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int intCodigoAlumno;

	public CitaBean(){
		System.out.println("Creando CitaBean...");
		intCodigoAlumno = 0;
	}
	
	public String redericcionaCita(){
		
		System.out.println("---------------Redireccionando------------------------");
		System.out.println(intCodigoAlumno);
		
		return "/faces/mantenimientos/listadoAsignaturas";
	}

	public int getIntCodigoAlumno() {
		return intCodigoAlumno;
	}

	public void setIntCodigoAlumno(int intCodigoAlumno) {
		this.intCodigoAlumno = intCodigoAlumno;
	}
	
	
}
