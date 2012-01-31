package controlador;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utiles.Helper;

import bd.NotificacionDbMapper;

public class NotificacionController {
	NotificacionDbMapper mimapper=new NotificacionDbMapper();
	static {
        PropertyConfigurator.configure(Helper.log4jNotificador);
    }
	Logger log = Logger.getLogger(this.getClass());
	public NotificacionController() {
		log.info("creando NotificacionController");
		// TODO Auto-generated constructor stub
	}
	
	
	public void procesoNotificacion() {
		// TODO Auto-generated method stub
		log.debug("En procesoNotificacion");
		mimapper.enviarCorreoCitasPendientes();
	}

}
