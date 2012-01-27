package jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.UnselectEvent;

import servicios.ApplicationBusinessDelegate;
import servicios.SolicitudRetiroService;
import entidades.Certificadoa;

@SessionScoped
@ManagedBean
public class EnviaCertificadosBean  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static SolicitudRetiroService retiroService = abd.getRetiroService();
	
	private boolean editMode;
	private String elfiltro;
	private ArrayList<Certificadoa> listaCertificados;  
	  
    private Certificadoa selectedCerti;  
  
    private Certificadoa[] selectedCertificados;  
   
   // private CarDataModel mediumCarsModel;
	
	public EnviaCertificadosBean() {
		System.out.println("creando EnviaCertificadosBean ... ");
		
	}

	    public void onRowUnselect(UnselectEvent event)
	    {
	    	Certificadoa c =(Certificadoa) event.getObject();
	        System.err.println("onRowUnselect car " + c.getIntCodcertificado() + " " + c.getIntCodcita()+ "/" + c.getCodmotivo());    
	    }

		public Certificadoa[] getSelectedCertificados() {
	        System.out.println(">> getCars");       
	        if (this.selectedCertificados != null)        
	            for (int i = 0; i < selectedCertificados.length; i++)        
	                System.out.println("   car " + i + ",id=" + this.selectedCertificados[i].getIntCodcertificado() + " " + this.selectedCertificados[i].getIntCodcita() + "/" + this.selectedCertificados[i].getCodmotivo());                   
	        return this.selectedCertificados;
	    }

		public void cargaCertificados() {
			try {
				System.out.println("elfiltro: "+elfiltro);
				
				listaCertificados = retiroService.obtenerCertificadosXAlumno(elfiltro);
				System.out.println("listaCertificados cargada - tamaño: "+listaCertificados.size());
			}catch (NullPointerException ne){
				ne.printStackTrace();
				System.out.println("lista vacia: "+ne.getMessage());
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error: "+e.getMessage());
			}
			//return listaCertificados;
		}
		
		public void enviarCertificados() {
			System.out.println("enviando certificados ... ");
		}
		
		public void setSelectedCertificados(Certificadoa[] e) {
	        // Always passed a non null value (empty list)
	        // Its possible for the same object to be in list > once because of a bug in primefaces on refresh, page forward/back
	        this.selectedCertificados = e;
	        System.out.println(">> setCars");       
	        for (int i = 0; i < selectedCertificados.length; i++)        
	            System.out.println("   car " + i + ",id=" + this.selectedCertificados[i].getIntCodcertificado() + " " + this.selectedCertificados[i].getIntCodcita() + "/" + this.selectedCertificados[i].getCodmotivo());                    
	    }

		public List<Certificadoa> getListaCertificados() {
			try {
				System.out.println("elfiltro: "+elfiltro);
				
				listaCertificados = retiroService.obtenerCertificadosXAlumno(elfiltro);
				System.out.println("listaCertificados cargada - tamaño: "+listaCertificados.size());
			}catch (NullPointerException ne){
				System.out.println("null pointer: "+ne.getMessage());
			} 
			catch (Exception e) {
				//e.printStackTrace();
				System.out.println("error: "+e.getMessage());
			}
			return listaCertificados;
		}

		public void setListaCertificados(ArrayList<Certificadoa> listaCertificados) {
			this.listaCertificados = listaCertificados;
		}

		public Certificadoa getSelectedCerti() {
			return selectedCerti;
		}

		public void setSelectedCerti(Certificadoa selectedCerti) {
			this.selectedCerti = selectedCerti;
		}

		public boolean isEditMode() {
			return editMode;
		}

		public void setEditMode(boolean editMode) {
			this.editMode = editMode;
		}

		public String getElfiltro() {
			return elfiltro;
		}

		public void setElfiltro(String elfiltro) {
			this.elfiltro = elfiltro;
		}
	
	
}
