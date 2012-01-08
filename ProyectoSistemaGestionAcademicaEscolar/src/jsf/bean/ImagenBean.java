package jsf.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


@ManagedBean
@SessionScoped
public class ImagenBean implements Serializable{  
   

	private static final long serialVersionUID = 6794776505066253054L;
	
	 //private Logger logger = LoggerFactory.getLogger(FileUploadController.class); 
	private StreamedContent image; 
	
	public ImagenBean(){
		System.out.println("Creando ImagenBean...");
	}

	public void cargarImagen(FileUploadEvent event) {  
    	System.out.println("XD " + event.getFile().getFileName());
    	
    	try {
    	    image = new DefaultStreamedContent(event.getFile().getInputstream());
    	    
    	    System.out.println("XD2 " + event.getFile().getFileName());
    	    System.out.println("XD2 " + event.getFile().getContents());
    	    
    	    FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
    	    FacesContext.getCurrentInstance().addMessage(null, msg);
    	  } catch (Exception ex) {
    	 } 
    }

	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}
	
	
}  
