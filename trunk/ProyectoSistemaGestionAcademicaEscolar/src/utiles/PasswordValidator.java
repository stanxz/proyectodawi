package utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator implements Validator {


    public void validate(FacesContext context, UIComponent component, Object value)
        throws ValidatorException
    {
        String password = (String) component.getAttributes().get("password");

        String confirm = (String) value;
        
        System.out.println(password);
        
        System.out.println(confirm);

        if (!password.equals(confirm)) {
            throw new ValidatorException(new FacesMessage("Contraseñas no son iguales"));
        }

    }

}
