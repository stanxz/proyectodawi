package utiles;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entidades.Usuario;

public class EnviaMail {

	
	public void EnviadorMailContrasena(String maildestino, String destinatario, Usuario datosusuario){
		//logica para envio de correos debe ir aqui
		 // Propiedades de la conexión
	   Properties props = new Properties();
	   props.setProperty("mail.smtp.host", "smtp.gmail.com");
	   props.setProperty("mail.smtp.starttls.enable", "true");
	   props.setProperty("mail.smtp.port", "587");
	   props.setProperty("mail.smtp.user", "proylp2@gmail.com");
	   props.setProperty("mail.smtp.auth", "true");

	   // Preparamos la sesion
	   Session session = Session.getDefaultInstance(props);

	   // Construimos el mensaje
	   MimeMessage message = new MimeMessage(session);

	   try {
		   message.setFrom(new InternetAddress("proylp2@gmail.com"));
		   message.addRecipient(
		       Message.RecipientType.TO,
		       new InternetAddress(maildestino));
		   
		   message.setSubject("Recuperación de Contraseña");
		   
		   message.setText("Estimado "+destinatario+ " su usuario es: " + datosusuario.getPersonas().getStrCodigoPersona() + 
				           " y su contraseña es: " + datosusuario.getStrContrasena());

		   // Lo enviamos.
		   Transport t = session.getTransport("smtp");
		   t.connect("proylp2@gmail.com", "cibertec");
		   t.sendMessage(message, message.getAllRecipients());
		   // Cierre.
           t.close();
	   } catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("error enviando el correo : "+e.getMessage());
	   }catch(Exception e1){
		   	e1.printStackTrace();
			System.out.println("error enviando el correo : "+e1.getMessage());
	   }
	   
	   
	}
	
	
	
	

   
}
