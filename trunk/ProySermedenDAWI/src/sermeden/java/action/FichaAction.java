package sermeden.java.action;

import sermeden.java.bean.FichaDTO;
import sermeden.java.bean.UsuarioDTO;
import sermeden.java.service.FichaService_I;
import sermeden.java.service.PaqueteBusinessDelegate;
import sermeden.java.service.UsuarioService_I;

import com.opensymphony.xwork2.ActionSupport;

public class FichaAction extends ActionSupport {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private FichaDTO ficha;
	private UsuarioDTO paciente;
	private String mensaje;
	private String dniBuscado;
	private String observaciones;
	
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDniBuscado() {
		return dniBuscado;
	}

	public void setDniBuscado(String dniBuscado) {
		this.dniBuscado = dniBuscado;
	}

	public FichaDTO getFicha() {
		return ficha;
	}

	public void setFicha(FichaDTO ficha) {
		this.ficha = ficha;
	}

	public UsuarioDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(UsuarioDTO paciente) {
		this.paciente = paciente;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	FichaService_I fichaService = 
			PaqueteBusinessDelegate.getFichaService();
	
	UsuarioService_I pacienteService=PaqueteBusinessDelegate.getUsuarioService();
	
	public String registrarFicha(){
		int idnuevaficha=-1;
		int resultupdate=-1;
		String vista = "exito";
		System.out.println("Dentro del metodo registrar Paciente- Struts 2 ");
		System.out.println("dniBuscado: " +dniBuscado);
		System.out.println("observaciones: "+observaciones);
		
		//Invocamos al servicio requerido para registrar cliente
		
		try {
			paciente=(UsuarioDTO) pacienteService.pacienteXDNI(dniBuscado);
			if(paciente!=null){
				
				System.out.println("paciente se encuentra en la BD: "+paciente.getNombre()+" "+paciente.getApepat());
				System.out.println("aaaa "+paciente.getIdPersona());
				
				ficha=new FichaDTO();
				
				ficha.setFechaRegistro(new java.sql.Date(new java.util.Date().getTime()));
				//System.out.println(ficha.getFechaRegistro());
				ficha.setEstado(1);
				//System.out.println(ficha.getEstado());
				if(observaciones!=null)
					ficha.setObservaciones(observaciones);
				else
					ficha.setObservaciones("");
				//System.out.println(ficha.getObservaciones());
				ficha.setIdPersona(paciente.getIdPersona());
				//System.out.println(""+paciente.getDni());
				
				System.out.println("actualizando ficha antigua ... ");
				resultupdate=fichaService.cambiarEstadoFichaActual(paciente.getIdPersona());
				System.out.println("registrando ficha ... :"+resultupdate);
				idnuevaficha=fichaService.registrarFicha(ficha);
				
				
				if(idnuevaficha>0){
					System.out.println(" idnuevaficha: "+idnuevaficha+" registrado en la BD");
					mensaje="La ficha del paciente con DNI "+paciente .getDni()+" se registró con exito ! (id Ficha: "+ficha.getIdFicha()+")";
					vista = "exito";
				}
				else{
					mensaje="No se registró la Ficha";
					vista = "error";
				}
			}
			else{
				System.out.println("El paciente con DNI "+dniBuscado+" no se encuentra registrado en el Sistema !");
				mensaje="El paciente con DNI "+dniBuscado+" no se encuentra registrado en el Sistema !";
				vista = "error";
			}
		} catch (Exception e) {
			vista = "error";
			mensaje="Errores al procesar: "+e.getMessage();
			e.printStackTrace();
		}
		return vista;
	}
	
}
