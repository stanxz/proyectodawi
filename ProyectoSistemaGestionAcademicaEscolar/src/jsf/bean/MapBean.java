package jsf.bean;

import java.io.Serializable;  

import javax.faces.bean.ManagedBean;
  
import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Marker;  
  
@SuppressWarnings("serial")
@ManagedBean
public class MapBean implements Serializable {  
  
    private MapModel simpleModel;  
  
    public MapBean() {  
    	System.out.println("Creando MapaBean...");
        simpleModel = new DefaultMapModel();  
          
        //Shared coordinates  
        LatLng coord1 = new LatLng(-12.061276302138568,-77.04394340515137);  
        /*LatLng coord2 = new LatLng(36.883707, 30.689216);  
        LatLng coord3 = new LatLng(36.879703, 30.706707);  
        LatLng coord4 = new LatLng(36.885233, 30.702323);  */
          
        //Basic marker  
        simpleModel.addOverlay(new Marker(coord1, "Colegio San Carlos"));  
       /* simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));  
        simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));  
        simpleModel.addOverlay(new Marker(coord4, "Kaleici"));  */
    }  
  
    public MapModel getSimpleModel() {  
        return simpleModel;  
    }  
}  
