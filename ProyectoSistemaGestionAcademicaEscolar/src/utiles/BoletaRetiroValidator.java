package utiles;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import entidades.Apoderado;
import entidades.Boleta;
import entidades.Persona;
import entidades.Usuario;

import servicios.ApplicationBusinessDelegate;
import servicios.BoletaService;

public class BoletaRetiroValidator implements Validator{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static BoletaService boletaService = abd.getBoletaService();
	private Map<String, Object> misesion;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		// TODO Auto-generated method stub
        String valor = (String) value;
        System.out.println("valor en el validador: " + valor);

        Boleta temporal=new Boleta();
        temporal.setStrCodigoBoleta(valor);
        Apoderado apotempo=new Apoderado();
		Persona persotempo=new Persona();
        misesion=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        int numero=((Usuario)misesion.get("b_usuario")).getPersonas().getIntDNI();
		System.out.println("numerooooo de DNI del apoderado: "+numero);
		persotempo.setIntDNI(numero);
		apotempo.setPersonas(persotempo);
		temporal.setApoderados(apotempo);
		
        boolean condicionBoletaRetiro = false;
		try {
			Boleta	miboleta=boletaService.obtenerBoleta(temporal);
			if(miboleta!=null){
				System.out.println("boleta leida: "+miboleta.getStrCodigoBoleta());
				condicionBoletaRetiro=true;
			}else{
				System.out.println("No existe boleta ... ");
				condicionBoletaRetiro=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (condicionBoletaRetiro==false) {
		    throw new ValidatorException(new FacesMessage("No existe boleta de pago, No le pertenece al Apoderado, o ya fue utilizada en otro trámite"));    
		}
		
    
	}

}
