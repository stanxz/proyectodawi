package utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import entidades.Alumno;
import entidades.SolicitudRetiro;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudRetiroService;

public class RetiroValidator implements Validator{
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static SolicitudRetiroService retiroService=abd.getRetiroService();
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String valor = (String) value;
        
        System.out.println("valor que llega al validator: " + valor);
		Alumno tmpAlumno = new Alumno();
        tmpAlumno.setStrCodigoAlumno(valor);
        
		SolicitudRetiro tmpSR = null;
		try {
			tmpSR = retiroService.verificarExistenciaSR(tmpAlumno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(tmpSR!=null){
			if(tmpSR.getStrEstado().equalsIgnoreCase("APROBADA")){
				throw new ValidatorException(new FacesMessage("El alumno ya fue retirado del ciclo académico escolar. NO PUEDE EFECTUAR ESTE TRÁMITE"));   
			}else if(tmpSR.getStrEstado().equalsIgnoreCase("PENDIENTE")){
				throw new ValidatorException(new FacesMessage("El alumno tiene una solictud de RETIRO 'PENDIENTE'. NO PUEDE EFECTUAR ESTE TRÁMITE"));   
			}
		}
	}
}
