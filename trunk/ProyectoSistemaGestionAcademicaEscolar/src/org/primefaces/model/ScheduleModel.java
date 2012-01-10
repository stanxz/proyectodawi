package org.primefaces.model;

import java.util.List;



public interface ScheduleModel {

	  public void addEvent(ScheduleEvent event);
      
      public boolean deleteEvent(ScheduleEvent event);
      
      public List<ScheduleEvent> getEvents();
      
      public ScheduleEvent getEvent(String id);
      
      public void updateEvent(ScheduleEvent event);
      
      public int getEventCount();
      
      public void clear();
	
}
