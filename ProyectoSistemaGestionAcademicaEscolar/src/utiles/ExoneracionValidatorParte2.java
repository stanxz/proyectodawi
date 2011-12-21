package utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import entidades.Apoderado;
import entidades.Asignatura;
import entidades.Boleta;
import entidades.Persona;
import entidades.SolicitudExoneracion;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudExoneracionService;

public class ExoneracionValidatorParte2 implements Validator {

	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static SolicitudExoneracionService exoneracionService = abd.getExoneracionService();

    public void validate(FacesContext context, UIComponent component, Object value)
    throws ValidatorException
    {
        Integer valor = (Integer) value;
        
        System.out.println("--->" + valor);
        
        Asignatura tmpAsignatura = new Asignatura();
        tmpAsignatura.setIntCodigoAsignatura(valor);
        
        
        SolicitudExoneracion tmpExoneracion = new SolicitudExoneracion();
        tmpExoneracion.setAsignaturas(tmpAsignatura);
        
        SolicitudExoneracion condicion = null;
		try {
			condicion = exoneracionService.buscarSolicitudXAsignatura(tmpExoneracion);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (condicion != null) {
			if(condicion.getStrEstado().equalsIgnoreCase("Pendiente")){
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO,"Solicitud PENDIENTE","Existe una solicitud PENDIENTE para este curso."));
			}else if (condicion.getStrEstado().equalsIgnoreCase("Aprobada")) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO,"Solicitud APROBADA","Su solicitud para este curso " +
                "ya fue APROBADA. No puede generar otra solicitud para este curso"));
			}
     
		}else {
			boolean condicionBoleta = false;
			
			try {
				Persona persona = new Persona();
				persona.setStrCodigoPersona("PE-18181818");
				
				Apoderado apoderado = new Apoderado();
				apoderado.setPersonas(persona);
				
				Boleta boleta = new Boleta();
				boleta.setApoderados(apoderado);
				
				condicionBoleta = exoneracionService.NoExisteDeudas(boleta);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(!condicionBoleta){
				throw new ValidatorException(new FacesMessage("Ud. tiene una deuda con la institución"));    
			}
		}
    }

}
