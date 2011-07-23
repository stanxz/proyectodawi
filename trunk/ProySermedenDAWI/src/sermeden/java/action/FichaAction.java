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
		String vista = "exito";
		System.out.println("Dentro del metodo registrar Paciente- Struts 2 ");
		System.out.println("dniBuscado: " +dniBuscado);
		System.out.println("observaciones: "+observaciones);
		
		//Invocamos al servicio requerido para registrar cliente
		
		try {
			if(pacienteService.pacienteXDNI(dniBuscado)!=null){
				paciente=(UsuarioDTO) pacienteService.pacienteXDNI(dniBuscado);
				System.out.println("paciente registrado en la BD: "+paciente.getNombre()+" "+paciente.getApepat());
				
				ficha.setIdPersona(paciente.getIdPersona());
				ficha.setFechaRegistro(new java.sql.Date(new java.util.Date().getTime()));
				ficha.setEstado(1);
				ficha.setObservaciones(observaciones);
				
				idnuevaficha=fichaService.registrarFicha(ficha);
				
				if(idnuevaficha>0){
					System.out.println(" idnuevaficha: "+idnuevaficha+" registrado en la BD");
					mensaje="La ficha con id ["+ficha.getIdFicha()+"] se registró con exito !";
				}
				else{
					mensaje="No se registró la Ficha porque el usuario no es valido";
				}
			}
			else{
				System.out.println("La ficha con id ["+ficha.getIdFicha()+"] ya existe en la BD !");
				mensaje="La ficha con id ["+ficha.getIdFicha()+"] ya existe en la BD !";
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return vista;
	}
	
}
