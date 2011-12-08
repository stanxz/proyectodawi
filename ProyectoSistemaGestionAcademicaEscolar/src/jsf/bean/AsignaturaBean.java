package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Asignatura;

import servicios.ApplicationBusinessDelegate;
import servicios.AsignaturaService;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean 
public class AsignaturaBean implements Serializable{
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	private static AsignaturaService asignaturaService = abd.getAsignaturaService();
	
	private Asignatura asignatura,selectedAsignatura;
	private ArrayList<Asignatura> asignaturas;
	private boolean editMode;
	
	
	//Para niveles y grados
	
	private String nivel;
	
	private ArrayList<String> gradosPrimario = new ArrayList<String>();
	private ArrayList<String> gradosSecundario = new ArrayList<String>();
	private ArrayList<String> gradosListados = new ArrayList<String>();
	
	/*
	private String grado;
	
	private Map<String, String> niveles =  new HashMap<String, String>();
	
	private Map<String,Map<String,String>> nivelesData = new HashMap<String, Map<String,String>>();  
	
	private Map<String,String> grados = new HashMap<String, String>();  
	*/
	
	
	private Asignatura nuevaAsignatura=new Asignatura();
	
	public AsignaturaBean(){
		System.out.println("Creando AsignaturaBean...");
		CargaCombos();
	}
	
	public void actualizaAsignatura(){
		
		try {
			asignaturaService.actualizarAsignatura(selectedAsignatura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registraAsignatura(){
		try {
			asignaturaService.insertarAsignatura(nuevaAsignatura);
			nuevaAsignatura = new Asignatura();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inhabilitaAsignatura(){
		try {
			asignaturaService.inhabilitarAsignatura(selectedAsignatura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Asignatura getSelectedAsignatura() {
		return selectedAsignatura;
	}

	public void setSelectedAsignatura(Asignatura selectedAsignatura) {
		this.selectedAsignatura = selectedAsignatura;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		try {
			asignaturas = asignaturaService.obtenerTodosAsignaturas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Asignatura getNuevaAsignatura() {
		return nuevaAsignatura;
	}

	public void setNuevaAsignatura(Asignatura nuevaAsignatura) {
		this.nuevaAsignatura = nuevaAsignatura;
	}
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public ArrayList<String> getGradosPrimario() {
		return gradosPrimario;
	}

	public void setGradosPrimario(ArrayList<String> gradosPrimario) {
		this.gradosPrimario = gradosPrimario;
	}

	public ArrayList<String> getGradosSecundario() {
		return gradosSecundario;
	}

	public void setGradosSecundario(ArrayList<String> gradosSecundario) {
		this.gradosSecundario = gradosSecundario;
	}
	
	public ArrayList<String> getGradosListados() {
		return gradosListados;
	}

	public void setGradosListados(ArrayList<String> gradosListados) {
		this.gradosListados = gradosListados;
	}

	public void CargaCombos(){
		//niveles.put("Primario", "Primario");
		//niveles.put("Secundario", "Secundario");
		
		gradosPrimario = new ArrayList<String>();
		gradosPrimario.add("1");
		gradosPrimario.add("2");
		gradosPrimario.add("3");
		gradosPrimario.add("4");
		gradosPrimario.add("5");
		gradosPrimario.add("6");
		
		gradosSecundario = new ArrayList<String>();
		gradosSecundario.add("7");
		gradosSecundario.add("8");
		gradosSecundario.add("9");
		gradosSecundario.add("10");
		gradosSecundario.add("11");
	
		
		/* Map<String,String> gradosPrimario = new HashMap<String, String>();  
		 gradosPrimario.put("1", "1º");  
		 gradosPrimario.put("2", "2º");  
		 gradosPrimario.put("3", "3º");  
		 gradosPrimario.put("4", "4º");  
		 gradosPrimario.put("5", "5º");  
		 gradosPrimario.put("6", "6º");
	          
	     Map<String,String> gradosSecudario = new HashMap<String, String>();  
	     gradosSecudario.put("7", "7º");  
	     gradosSecudario.put("8", "9º");  
	     gradosSecudario.put("9", "9º"); 
	     gradosSecudario.put("10", "10º");  
	     gradosSecudario.put("11", "11º");
	     
	     nivelesData.put("Primario", gradosPrimario);
	     nivelesData.put("Secundario", gradosSecudario);
	     */
	}
	
	public void handleCityChange() {
		nivel = selectedAsignatura.getStrNivel();
		
		if(nivel !=null && !nivel.equals("")){
			if(nivel.equals("Primario")){
				gradosListados = gradosPrimario;
			}else{
				gradosListados = gradosSecundario;
			}
		}
		
		/*
        if(nivel !=null && !nivel.equals("")){
        	grados = nivelesData.get(nivel);  
        } else {
        	System.out.println("---------------------------------->");
        	grados = new HashMap<String, String>();  
        }
        */	
    }

}
