package jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
