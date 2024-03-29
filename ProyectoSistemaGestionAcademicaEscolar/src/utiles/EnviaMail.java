package utiles;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import entidades.Alumno;
import entidades.Certificadoa;
import entidades.Cita;
import entidades.Persona;
import entidades.SolicitudExoneracion;
import entidades.SolicitudRetiro;
import entidades.Usuario;

public class EnviaMail {

	
	public void EnviadorMailContrasena(String tipo,String maildestino, String destinatario, Usuario datosusuario){
		 // Propiedades de la conexi�n
	   Properties props = new Properties();
	   props.setProperty("mail.smtp.host", "smtp.gmail.com");
	   props.setProperty("mail.smtp.starttls.enable", "true");
	   props.setProperty("mail.smtp.port", "587");
	   props.setProperty("mail.smtp.user", "proylp2@gmail.com");
	   props.setProperty("mail.smtp.auth", "true");

	   // Preparamos la sesion
	   Session session = Session.getDefaultInstance(props);
	   
	   System.out.println("Cargando Session");

	   // Construimos el mensaje
	   MimeMessage message = new MimeMessage(session);
	   
	   System.out.println("Construyendo el Mensaje");

	   try {
		   message.setFrom(new InternetAddress("proylp2@gmail.com"));
		   message.addRecipient(
		       Message.RecipientType.TO,
		       new InternetAddress(maildestino));
		   
		   if(tipo.equals("registro")){
			   message.setSubject("SGAE - Registro Exitoso");
			   
		   }else if (tipo.equals("recuperacion")) {
			   message.setSubject("SGAE - Recuperaci�n de Contrase�a");
		   }
		   
		   message.setText("Estimado "+destinatario+ " su usuario es: " + datosusuario.getPersonas().getStrCodigoPersona() + 
		           " y su contrase�a es: " + datosusuario.getStrContrasena());

		   // Lo enviamos.
		   Transport t = session.getTransport("smtp");
		   t.connect("proylp2@gmail.com", "cibertec");
		   t.sendMessage(message, message.getAllRecipients());
		   System.out.println("Mensaje Enviado");
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

	public void enviarCorreoRegisroAl(Alumno nuevoAlumno,
			Persona apoderadobuscado) {
		// Propiedades de la conexi�n
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
			       new InternetAddress(apoderadobuscado.getStrMail()));

			   message.setSubject("SGAE - Registro de Alumno Exitoso");
			   String cuerpomensaje="Estimado "+apoderadobuscado.getStrNombre()+" "+apoderadobuscado.getStrApellidoPaterno()+ ", \n\n le enviamos la confirmacion del registro del alumno "+nuevoAlumno.getStrNombres()+" "+nuevoAlumno.getStrApellidoPaterno()+" con los siguientes datos: ";
			   
			   for (Method m : nuevoAlumno.getClass().getMethods()){
					if(m.getName().startsWith("get"))
						cuerpomensaje+="\n" + m.getName().substring(6).toUpperCase() + " : " +  m.invoke(nuevoAlumno);
				}
			   message.setText(cuerpomensaje);

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

	public void enviarCorreoRegisroApo(Persona nuevoApoderado) {
		// Propiedades de la conexi�n
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
			       new InternetAddress(nuevoApoderado.getStrMail()));

			   message.setSubject("SGAE - Registro de Nuevo Apoderado Exitoso");
			   String cuerpomensaje="Estimado "+nuevoApoderado.getStrNombre()+" "+nuevoApoderado.getStrApellidoPaterno()+ ", \n\n le enviamos la confirmacion de su registro con los siguientes datos: ";
			   
			   for (Method m : nuevoApoderado.getClass().getMethods()){
					if((m.getName().startsWith("getStr"))||(m.getName().startsWith("getInt"))){
						cuerpomensaje+="\n" + m.getName().substring(6).toUpperCase() + " : " +  m.invoke(nuevoApoderado);
					}
						
				}
			   message.setText(cuerpomensaje);

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
	
	public void enviarCorreoRegistroCita(Cita lacita) {
		// Propiedades de la conexi�n
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
			       new InternetAddress(lacita.getAlumno().getApoderados().getPersonas().getStrMail()));

			   message.setSubject("SGAE - Registro de Cita Exitoso");
			   String cuerpomensaje="Estimado "+lacita.getAlumno().getApoderados().getPersonas().getStrNombre()+" "+lacita.getAlumno().getApoderados().getPersonas().getStrApellidoPaterno()+ ", \n\n le enviamos la confirmacion de su registro de Cita con los siguientes datos: ";
			   
			   for (Method m : lacita.getClass().getMethods()){
					if((m.getName().startsWith("getStr"))||(m.getName().startsWith("getInt"))||(m.getName().startsWith("getTlf"))){
						cuerpomensaje+="\n" + m.getName().substring(6).toUpperCase() + " : " +  m.invoke(lacita);
					}else if(m.getName().startsWith("getDt")){
						cuerpomensaje+="\n" + m.getName().substring(5).toUpperCase() + " : " +  m.invoke(lacita);
					}
						
				}
			   message.setText(cuerpomensaje);

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
	
	public void enviarCorreoEvaluarSolicitudExoneracion(SolicitudExoneracion exoneracion,String estado) {
		// Propiedades de la conexi�n
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
			       new InternetAddress(exoneracion.getAlumno().getApoderados().getPersonas().getStrMail()));

			   message.setSubject("SGAE - Tr�mite Solicitud Exoneraci�n");
			   String cuerpomensaje="Estimado "+exoneracion.getAlumno().getApoderados().getPersonas().getStrNombre()+" "+exoneracion.getAlumno().getApoderados().getPersonas().getStrApellidoPaterno()+ 
			   ", \n\n remitimos la respuesta a su solicitud: ";
			   

				cuerpomensaje+="\n Codigo Solicitud : " + exoneracion.getIntIdCodigoSolicitudExoneracion();
				cuerpomensaje+="\n Alumno           : " + exoneracion.getAlumno().getStrNombres() + " " + exoneracion.getAlumno().getStrApellidoPaterno();
				cuerpomensaje+="\n Asignatura       : " + exoneracion.getAsignaturas().getStrNombreAsignatura();
				cuerpomensaje+="\n Estado           : Solicitud " + estado ; 
	
			   message.setText(cuerpomensaje);

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

	public void enviarCorreoEvaluacionSR(SolicitudRetiro selectedSolicitud,
			boolean b) {

		// Propiedades de la conexi�n
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
			       new InternetAddress(selectedSolicitud.getAlumno().getApoderados().getPersonas().getStrMail()));

			   message.setSubject("SGAE - Tr�mite Solicitud Retiro");
			   String cuerpomensaje="Estimado "+selectedSolicitud.getAlumno().getApoderados().getPersonas().getStrNombre()+" "+selectedSolicitud.getAlumno().getApoderados().getPersonas().getStrApellidoPaterno()+ 
			   ", \n\n remitimos la respuesta a su solicitud: ";
			   

				cuerpomensaje+="\n Codigo Solicitud : " + selectedSolicitud.getIntIdCodigoSolicitudRetiro();
				cuerpomensaje+="\n Alumno           : " + selectedSolicitud.getAlumno().getStrNombres() + " " + selectedSolicitud.getAlumno().getStrApellidoPaterno();
			 if(b==true)
				cuerpomensaje+="\n Estado           : Solicitud de Retiro APROBADA"; 
			 else
				cuerpomensaje+="\n Estado           : Solicitud de Retiro RECHAZADA";	
			   message.setText(cuerpomensaje);

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

	public void enviarCorreoCertificado(Certificadoa certificadoa, Alumno elalumno) {


		// Propiedades de la conexi�n
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
			       new InternetAddress(elalumno.getApoderados().getPersonas().getStrMail()));

			   message.setSubject("SGAE - Envio de Certificados");
			   String cuerpomensaje="Estimado "+elalumno.getApoderados().getPersonas().getStrNombre()+" "+elalumno.getApoderados().getPersonas().getStrApellidoPaterno()+ 
			   ", \n\n remitimos su Certificado de Asistencia Social: ";
			   

				cuerpomensaje+="\n Codigo Certificado : " + certificadoa.getIntCodcertificado();
				cuerpomensaje+="\n Alumno           : " + elalumno.getStrNombres() + " " + elalumno.getStrApellidoPaterno()+" "+elalumno.getStrApellidoMaterno();
	
				
				if(certificadoa.getContenidodoccertbin()!=null){
					System.out.println("correo con adjunto ...");
					//primara parte del mensaje, adjunto el texto del mail
                    MimeBodyPart messageBodyPart = new MimeBodyPart();
                    //fill message
                    messageBodyPart.setText(cuerpomensaje);
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);

                    //segunda parte del mensaje, adjunto el archivo
                    messageBodyPart = new MimeBodyPart();
                   // File file= new File("");
                    DataSource source =  new ByteArrayDataSource(certificadoa.getContenidodoccertbin(), "hola");
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName("Certificado Asistencia Social");
                    multipart.addBodyPart(messageBodyPart);
                    message.setContent(multipart);  
                    
				}else{
					System.out.println("No hay adjunto, mensaje simple ...");
					message.setText(cuerpomensaje);
				}
				

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
