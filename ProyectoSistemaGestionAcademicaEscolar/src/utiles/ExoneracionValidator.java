package utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudExoneracionService;

public class ExoneracionValidator implements Validator {

	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();

    public void validate(FacesContext context, UIComponent component, Object value)
    throws ValidatorException
    {
        String valor = (String) value;
        
        System.out.println("--->" + valor);

        boolean condicion = false;
		try {
			condicion = exoneracionService.CumpleCalendarioExoneracion(2011);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        	
				if (!condicion) {
				    throw new ValidatorException(new FacesMessage("Contraseñas no son iguales"));
				}

			

    }

}
