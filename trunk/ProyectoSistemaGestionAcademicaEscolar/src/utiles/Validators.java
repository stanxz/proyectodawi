package utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import servicios.ApplicationBusinessDelegate;
import servicios.UsuarioService;

import entidades.Persona;
import entidades.Usuario;

@ManagedBean
public class Validators{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static UsuarioService usuarioService = abd.getUsuarioService();

	public void validateEmail(FacesContext context, UIComponent validate, Object value){
        String email = (String)value;
        Pattern p = Pattern.compile("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();

        if(!matchFound){
            ((UIInput)validate).setValid(false);
            FacesMessage msg = new FacesMessage("EMail Inválido");
            context.addMessage(validate.getClientId(context), msg);
        }
    
	}
	
	public void validaContrasenaAntigua(FacesContext context, UIComponent validate, Object value){
		 String contrasena = (String)value;
		 
		 HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			
		 Usuario sessionUsuario = (Usuario)session.getAttribute("b_usuario");
		 
		 Persona tmpPersona = new Persona();
		 tmpPersona.setStrCodigoPersona(sessionUsuario.getPersonas().getStrCodigoPersona());
		 
		 try {
			Usuario tmpUsuario = usuarioService.consultaPass(tmpPersona);
			
			if(!contrasena.equals(tmpUsuario.getStrContrasena())){
				((UIInput)validate).setValid(false);
	            FacesMessage msg = new FacesMessage("Debe ingresar su contraseña anterior");
	            context.addMessage(validate.getClientId(context), msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	

}
