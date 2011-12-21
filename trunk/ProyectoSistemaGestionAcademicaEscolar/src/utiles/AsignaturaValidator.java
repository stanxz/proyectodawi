package utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import entidades.Asignatura;

import servicios.ApplicationBusinessDelegate;
import servicios.AsignaturaService;

public class AsignaturaValidator implements Validator {
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AsignaturaService asignaturaService = abd.getAsignaturaService();


    public void validate(FacesContext context, UIComponent component, Object value)
        throws ValidatorException
    {
        
        Integer grado = (Integer) value;
        
        String nombreAsignatura = (String) component.getAttributes().get("valor");
        
        Asignatura tmpAsignatura = new Asignatura();
        tmpAsignatura.setIntGrado(grado);
        tmpAsignatura.setStrNombreAsignatura(nombreAsignatura);
        
        Asignatura asignatura = null;
        
		try {
			asignatura = asignaturaService.consultarAsignatura(tmpAsignatura);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		if(asignatura!=null){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR:Registro Asignatura ","Ya existe asignatura"));
		}
        
        System.out.println(grado);
        
        System.out.println(nombreAsignatura);

        if (!grado.equals(nombreAsignatura)) {
            
        }

    }

}
