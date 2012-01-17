package org.primefaces.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@SuppressWarnings("serial")
public class DefaultScheduleModel implements ScheduleModel, Serializable{
	
	  private List<ScheduleEvent> events;

      public DefaultScheduleModel() {
              events = new ArrayList<ScheduleEvent>(); 
      }
      
      public DefaultScheduleModel(List<ScheduleEvent> events) {
              this.events = events;
      }
      
      public void addEvent(ScheduleEvent event) {
              event.setId(UUID.randomUUID().toString());
              
              events.add(event);
      }
      
      public boolean deleteEvent(ScheduleEvent event) {
              return events.remove(event);
      }
      
      public List<ScheduleEvent> getEvents() {
              return events;
      }
      
      public ScheduleEvent getEvent(String id) {
              for(ScheduleEvent event : events) {
                      if(event.getId().equals(id))
                              return event;
              }
              
              return null;
      }
      
      public void updateEvent(ScheduleEvent event) {
              int index = -1;
              
              for(int i = 0 ; i < events.size(); i++) {
                      if(events.get(i).getId().equals(event.getId())) {
                              index = i;
                              
                              break;
                      }
              }
              
              if(index >= 0) {
                      events.set(index, event);
              }
      }
      
      public int getEventCount() {
              return events.size();
      }

      public void clear() {
              events = new ArrayList<ScheduleEvent>();
      }

}
