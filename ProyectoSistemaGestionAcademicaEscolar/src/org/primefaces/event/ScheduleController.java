package org.primefaces.event;

import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import entidades.Cita;

import servicios.ApplicationBusinessDelegate;
import servicios.CitaService;


@ManagedBean
public class ScheduleController {

    private ScheduleModel eventModel;
    
    private ScheduleModel lazyEventModel;
    
    //
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
    private ScheduleEvent event = new DefaultScheduleEvent();
    private ArrayList<Cita> citas;
  
  
    
    public static CitaService citaService = abd.getCitaService();
 
    private String theme;

	/**
	 * 
	 */
	@SuppressWarnings("serial")
	public ScheduleController() {  
    	System.out.println("ENTRA AQUI");
    	
   
    	//
    	
    	System.out.println(event.getStartDate());
    	
    	
        eventModel = new DefaultScheduleModel();  
   

        
        listarcitas();
     
       
        lazyEventModel = new LazyScheduleModel() {  
              
     
			public void fetchEvents(Date start, Date end) {  
                clear();  
                  
                Date random = getRandomDate(start);  
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));  
                 
                  
                random = getRandomDate(start);  
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));  
          
			}     
        }; 
    }
	
	void listarcitas(){
		try {
			citas= citaService.obtenercitas();
			eventModel.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   for(Cita x : citas){
	        	
		     /*  eventModel.addEvent(new DefaultScheduleEvent(x.getStrCodigoAlumno()+"dd", x.getDtfecharegistro(),
		    		  x.getDtfecharegistro(), x.getIntcodcita(), x.getStrestado())); 	*/ 
		       System.out.println("ScheduleController.listarcitas()"+x.getIntcodcita());
		       eventModel.addEvent(new DefaultScheduleEvent(x.getAlumno().getStrNombres() + " " +
		    		   x.getAlumno().getStrApellidoPaterno(),x.getIntcodcita(),
		    		     x.getDtfecharegistro(),x.getDtfecharegistro(),x.getDtfecharegistro(),
		    		     x.getStrestado().equals("1")?"generado":"atendido")); 
		       
		       
		        }
		
		
		
	}
    
    public Date getRandomDate(Date base) {
            Calendar date = Calendar.getInstance();
            date.setTime(base);
            date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);        //set random day of month
            
            return date.getTime();
    }
    
    public Date getInitialDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
            
            return calendar.getTime();
    }
    
    public ScheduleModel getEventModel() {
            return eventModel;
    }
    
    public ScheduleModel getLazyEventModel() {
            return lazyEventModel;
    }

    private Calendar today() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

            return calendar;
    }
    
    @SuppressWarnings("unused")
	private Date previousDay8Pm() {
    	
            Calendar t = (Calendar) today().clone();
            t.set(Calendar.AM_PM, Calendar.PM);
            t.set(Calendar.DATE, t.get(Calendar.DATE));
            t.set(Calendar.HOUR, 8);
         
            return t.getTime();
    }
    
    @SuppressWarnings("unused")
    private Date previousDay11Pm() {
            Calendar t = (Calendar) today().clone();
            t.set(Calendar.AM_PM, Calendar.PM);
            t.set(Calendar.DATE, t.get(Calendar.DATE));
            t.set(Calendar.HOUR, 11);
            
            return t.getTime();
    }
    
    @SuppressWarnings("unused")
    private Date today1Pm() {
            Calendar t = (Calendar) today().clone();
            t.set(Calendar.AM_PM, Calendar.PM);
            t.set(Calendar.HOUR, 1);
            
            return t.getTime();
    }
    
    @SuppressWarnings("unused")
    private Date theDayAfter3Pm() {
            Calendar t = (Calendar) today().clone();
            t.set(Calendar.DATE, t.get(Calendar.DATE));         
            t.set(Calendar.AM_PM, Calendar.PM);
            t.set(Calendar.HOUR, 3);
            
            return t.getTime();
    }

    @SuppressWarnings("unused")
    private Date today6Pm() {
            Calendar t = (Calendar) today().clone(); 
            t.set(Calendar.AM_PM, Calendar.PM);
            t.set(Calendar.HOUR, 6);
            
            return t.getTime();
    }
    
    @SuppressWarnings("unused")
    private Date nextDay9Am() {
            Calendar t = (Calendar) today().clone();
            t.set(Calendar.AM_PM, Calendar.AM);
            t.set(Calendar.DATE, t.get(Calendar.DATE)+1);
            t.set(Calendar.HOUR, 9);
            
            return t.getTime();
    }
   
    @SuppressWarnings("unused")
    private Date nextDay11Am() {
            Calendar t = (Calendar) today().clone();
            t.set(Calendar.AM_PM, Calendar.AM);
            t.set(Calendar.DATE, t.get(Calendar.DATE)+1);
            t.set(Calendar.HOUR, 11);
            
            return t.getTime();
    }
    
    @SuppressWarnings("unused")
    private Date fourDaysLater3pm() {
            Calendar t = (Calendar) today().clone(); 
            t.set(Calendar.AM_PM, Calendar.PM);
            t.set(Calendar.DATE, t.get(Calendar.DATE)+4);
            t.set(Calendar.HOUR, 3);
            
            return t.getTime();
    }
    
    public ScheduleEvent getEvent() {
            return event;
    }

    public void setEvent(ScheduleEvent event) {
            this.event = event;
    }
 
    public void addEvent(ActionEvent actionEvent) {  
        if(event.getId() == null)  {
        //	eventModel.addEvent(event);  
        /*	System.out.println("nombre distrito :"+event.getTitle());*/
         	
        }
            
        else  {
        	eventModel.updateEvent(event);  
        	/*System.out.println("iD dferente a null");
        	System.out.println("cod distrito:"+event.getIddis());
        	System.out.println("nombre distrito:"+event.getTitle());
  */
                   try {
		    
                	   Cita cita= new Cita();
                	   cita.setIntcodcita(event.getCodCita());
                	   citaService.actualizarEstadoCita(cita);
                	   listarcitas();
	             } catch (Exception e) {
		// TODO Auto-generated catch block
	              	e.printStackTrace();
	             }
	             
      
        }
            
          
        event = new DefaultScheduleEvent();  
    }  
      
    public void onEventSelect(ScheduleEntrySelectEvent selectEvent) {  
        event = selectEvent.getScheduleEvent();  
    }  
      
    public void onDateSelect(DateSelectEvent selectEvent) {  
       // event = new DefaultScheduleEvent(Math.random() + "", selectEvent.getDate(), selectEvent.getDate());  
     event = new DefaultScheduleEvent(Math.random()  + "", selectEvent.getDate(), selectEvent.getDate());  
    }  
      
    public void onEventMove(ScheduleEntryMoveEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  
    }  
      
    public void onEventResize(ScheduleEntryResizeEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  
    }  
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  

    public String getTheme() {
            return theme;
    }

    public void setTheme(String theme) {
            this.theme = theme;
    }
}
