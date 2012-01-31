package notificador;

import org.apache.log4j.Logger;

import controlador.NotificacionController;

public class Main extends Thread{

	static Logger log = Logger.getLogger(Main.class);
	
	public Main(String cadena) {
        super(cadena);
       // tipoDocumento = new SapTipoDocumento();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main("Notificador SGAE");
		main.start();
	}
	
	public void run() {
		log.info("Componente Notificador - Proyecto SGAE");
        log.info("Creado por: Rhandy Muguruza");
        log.info("Grupo: Sistema de Gestion Academica Escolar");
        log.info("Fecha Creacion 28/01/2012");
        NotificacionController minot=new NotificacionController();
        minot.procesoNotificacion();

	}

}
