package utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudExoneracionService;

public class ExoneracionValidatorParte1 implements Validator {

	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();

    public void validate(FacesContext context, UIComponent component, Object value)
    throws ValidatorException
    {
        String valor = (String) value;
        
        System.out.println("--->" + valor);
        
        
        boolean condicionExoneracion = false;
		try {
			condicionExoneracion = exoneracionService.CumpleCalendarioExoneracion(2011);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!condicionExoneracion) {
		    throw new ValidatorException(new FacesMessage("Ud. está fuera del perido de exoneración"));    
		}
		
    }

}
