package jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("serial")
@SessionScoped
@ManagedBean 
public class EditarDatosUsuarioBean implements Serializable{
	
	private boolean value;
	private boolean deshabilitar;
	
	
	public EditarDatosUsuarioBean(){
		System.out.println("Creando EditarDatosUsuario...");
	}


	public boolean isValue() {
		return value;
	}


	public void setValue(boolean value) {
		this.value = value;
	}
	
	

	public boolean isDeshabilitar() {
		return deshabilitar;
	}


	public void setDeshabilitar(boolean deshabilitar) {
		this.deshabilitar = deshabilitar;
	}

	public void addMessage() {  
        String valor = value ? "Checked" : "Unchecked"; 
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(valor));  
        if(valor.equals("Checked")){
        	deshabilitar = false;
        }else if (valor.equals("Unchecked")) {
        	deshabilitar = true;
		}
  
        
    }  
	


}
