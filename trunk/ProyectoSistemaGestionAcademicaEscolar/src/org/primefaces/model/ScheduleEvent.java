package org.primefaces.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.Date;

public interface ScheduleEvent extends Serializable{

	    public String getId();
	    
	    public void setId(String id);
	    
	    public Object getData();
	    
	    public String getTitle();
	    
	    public Date getStartDate();
	    
	    public Date getEndDate();
	    
	    public boolean isAllDay();
	    
	    public String getStyleClass();
	    

	    // end
	    //dtos d cita
		public String getCodAlu();
	    public int getCodCita();
	    public Date getFecReg();
	    public String getStado();
	    public String getObservacion();
	    
	    //pra archivo
	    public UploadedFile getFile();
	    
	
}
