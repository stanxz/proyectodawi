package jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean 
public class CitaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String includedPage;
	private int intCodigoAlumno;

	public CitaBean(){
		System.out.println("Creando CitaBean...");
		intCodigoAlumno = 0;
	}
	
	public String redericcionaCita(){
		
		System.out.println("---------------Redireccionando------------------------");
		//System.out.println(intCodigoAlumno);
		
		/*HttpServletRequest request =
				(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
				String source = request.getParameter("source");
				System.out.println("Valor de source: "+source);
				 includedPage= (source);*/
		return "/citas/listadoCitas.xhtml";
	}

	public int getIntCodigoAlumno() {
		return intCodigoAlumno;
	}

	public void setIntCodigoAlumno(int intCodigoAlumno) {
		this.intCodigoAlumno = intCodigoAlumno;
	}

	public String getIncludedPage() {
		return includedPage;
	}

	public void setIncludedPage(String includedPage) {
		this.includedPage = includedPage;
	}
	
}
