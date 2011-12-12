package jsf.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import entidades.Apoderado;
import entidades.Distrito;
import entidades.Perfil;
import entidades.Persona;
import entidades.Usuario;
import servicios.ApplicationBusinessDelegate;
import servicios.DistritoService;
import servicios.PersonaService;
import servicios.UsuarioService;
import utiles.EnviaMail;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class ApoderadoBean implements Serializable{

	 private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	 private static PersonaService apoderadoService=abd.getPersonaService();
	 private static UsuarioService userapoderadoService=abd.getUsuarioService();
	 private static DistritoService distritoService=abd.getDistritoService();
	 private ArrayList<Persona> apoderados;
	 private Persona apoderado,apoderadoSelected,nuevoApoderado;
	 private String mensaje,usuarioapoderado,passapoderado;
	 private Usuario nuevousuario;
	 private ArrayList<Distrito> listadistritos2;
	 private int eldniApoderado, codigoDistrito2;
	 
	public ApoderadoBean() {
		System.out.println("Creado ApoderadoBean...");
		this.mensaje="";
		nuevoApoderado=new Persona();
		CargarDistritos();
	}
	 
	public void buscaApoderado(ActionEvent evento){
		try {
			System.out.println("Buscando apoderado ... ");
			Persona personatempo = new Persona();
			System.out.println("buscado: "+eldniApoderado);
			personatempo.setIntDNI(eldniApoderado);
			apoderado=new Persona();
			apoderado=apoderadoService.consultaApoderado(personatempo);
			System.out.println("consulta hecha ...");
			if(apoderado!=null){
				System.out.println("Apoderado encontrado: "+apoderado.getStrNombre()+" "+apoderado.getStrApellidoPaterno());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado Encontrado: " + apoderado.getStrNombre() + " " + apoderado.getStrApellidoPaterno()));
				apoderados=new ArrayList<Persona>();
				apoderados.add(apoderado);
				this.mensaje="";
			}else{
				System.out.println("No se encontro el apoderado");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se encontró el apoderado","No se encontró el apoderado"));
				apoderados=new ArrayList<Persona>();
				apoderado=new Persona();
				this.mensaje="No se encuentra el apoderado";
			}		
		} catch (Exception e) {
			apoderados=new ArrayList<Persona>();
			apoderado=new Persona();
			e.printStackTrace();
		}
	}
	
	public void seteaApoderado(){
		System.out.println("seteando el apoderado ... ");
		System.out.println("apoderado mandado: "+apoderado.getStrNombre()+" "+apoderado.getStrApellidoPaterno());
	}

	
	public void registraApoderado() {  
		System.out.println("en el registraApoderado");
		Persona auxitemporal = null;
		
		//Llena datos que iran a la tabla usuario
		Perfil p = new Perfil();
		p.setStrCodigoPerfil("pf01");

		
		
		
		try {
			//reflexion: se invocan los emtodos 
			for (Method m : nuevoApoderado.getClass().getMethods()){
				if(m.getName().startsWith("get"))
				System.out.println("nuevo Apoderado - " + m.getName() + " : " +  m.invoke(nuevoApoderado));
			}
			
			/*for (Method m : nuevousuario.getClass().getMethods()){
				if(m.getName().startsWith("get"))
				System.out.println("nuevo Usuario - "+m.getName() + " : " +  m.invoke(nuevousuario));
			}*/
			
			
			
			System.out.println("consultando apoderado con dni: "+nuevoApoderado.getIntDNI());
			
			auxitemporal = apoderadoService.consultaPersona(nuevoApoderado);
			if (auxitemporal!=null){
				System.out.println("despues de consultar apoderado - auxitemporal: "+auxitemporal.getStrCodigoPersona());
			}else
				System.out.println("Auxitemporal es nulo !!!");
			
		} catch (Exception e) {
			System.out.println("error: "+e.getMessage());
		}

		if(auxitemporal!=null){
			System.out.println("Apoderado "+auxitemporal.getStrCodigoPersona()+"("+auxitemporal.getStrNombre()+" "+auxitemporal.getStrApellidoPaterno()+") ya existe !!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado ya se encuentra registrado: " + auxitemporal.getStrNombre() + " " + auxitemporal.getStrApellidoPaterno()));
		}else{
			System.out.println("se va a insertar el apoderado y su usuario");
			try {
				Distrito tempodis=new Distrito();
				tempodis.setIntIdDistrito(codigoDistrito2);
				System.out.println("1111");
				nuevoApoderado.setDistritos(tempodis);
				System.out.println("insertando apoderado y su usuario ... ");
				apoderadoService.registrarPersona(nuevoApoderado);
				
				nuevousuario = new Usuario();
				//nuevousuario.setPersonas(nuevoApoderado);
				nuevousuario.setStrContrasena(""+nuevoApoderado.getIntDNI());
				nuevousuario.setPerfiles(p);
				
				System.out.println("idlogin de usuario: "+nuevousuario.getIntIdLogin());
				//System.out.println("codpersona de usuario: "+nuevousuario.getPersonas().getStrCodigoPersona());
				System.out.println("contrasena de usuario: "+nuevousuario.getStrContrasena());
				System.out.println("perfil de usuario: "+nuevousuario.getPerfiles().getStrCodigoPerfil());
				
				System.out.println("registro a la persona .... ahora registrara el usuario ");//+nuevousuario.getPersonas().getStrCodigoPersona()+" ...");
				userapoderadoService.registrarUsuario(nuevousuario);
				System.out.println("enviando correo ... ");
				EnviaMail enviador=new EnviaMail();
				enviador.enviarCorreoRegisroApo(nuevoApoderado);
				Apoderado apotempo = new Apoderado();
				apotempo.setPersonas(nuevoApoderado);
				apoderadoService.guardaApoderado(apotempo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado Insertado correctamente: " + nuevoApoderado.getStrNombre() + " " + nuevoApoderado.getStrApellidoPaterno()));
				//nuevousuario =  new Usuario();
				//nuevoApoderado = new Persona();
				System.out.println("insertados correctamente ... ");
			} catch (Exception e) {
				System.out.println("Hubo un error insertando ...");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: No se insertó al apoderado","No se insertó el apoderado"));
				nuevousuario =  new Usuario();
				nuevoApoderado = new Persona();
				e.printStackTrace();
			}
		}
    }
	
	public void CargarDistritos(){
		try {
			this.listadistritos2=distritoService.obtenerTodosDistritos();
			System.out.println("Cantidad distritos cargados: " + listadistritos2.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Persona getApoderado() {
		return apoderado;
	}

	public void setApoderado(Persona apoderado) {
		this.apoderado = apoderado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ArrayList<Persona> getApoderados() {
		return apoderados;
	}

	public void setApoderados(ArrayList<Persona> apoderados) {
		this.apoderados = apoderados;
	}

	public Persona getApoderadoSelected() {
		return apoderadoSelected;
	}

	public void setApoderadoSelected(Persona apoderadoSelected) {
		this.apoderadoSelected = apoderadoSelected;
	}

	public Persona getNuevoApoderado() {
		return nuevoApoderado;
	}

	public void setNuevoApoderado(Persona nuevoApoderado) {
		this.nuevoApoderado = nuevoApoderado;
	}

	public Usuario getNuevousuario() {
		return nuevousuario;
	}

	public void setNuevousuario(Usuario nuevousuario) {
		this.nuevousuario = nuevousuario;
	}

	public String getUsuarioapoderado() {
		return usuarioapoderado;
	}

	public void setUsuarioapoderado(String usuarioapoderado) {
		this.usuarioapoderado = usuarioapoderado;
	}

	public String getPassapoderado() {
		return passapoderado;
	}

	public void setPassapoderado(String passapoderado) {
		this.passapoderado = passapoderado;
	}

	public int getEldniApoderado() {
		return eldniApoderado;
	}

	public void setEldniApoderado(int eldniApoderado) {
		this.eldniApoderado = eldniApoderado;
	}

	public int getCodigoDistrito2() {
		return codigoDistrito2;
	}

	public void setCodigoDistrito2(int codigoDistrito2) {
		this.codigoDistrito2 = codigoDistrito2;
	}

	public ArrayList<Distrito> getListadistritos2() {
		return listadistritos2;
	}

	public void setListadistritos2(ArrayList<Distrito> listadistritos2) {
		this.listadistritos2 = listadistritos2;
	}
	
	
	 
}
