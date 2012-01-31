package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import utiles.EnviaCorreo;
import utiles.Helper;

import beans.Cita;

public class NotificacionDbMapper {

	
	Logger log = Logger.getLogger(this.getClass());
	//private ConexionBD conexion;
	PreparedStatement pst;
	ResultSet rs;
	private ArrayList<Cita> listaCitasPendientes;
	EnviaCorreo enviador=new EnviaCorreo();
	
	public NotificacionDbMapper() {
		log.debug("Creando NotificacionDBMapper ... ");
		//this.conexion = new ConexionBD();
		listaCitasPendientes=new ArrayList<Cita>();
	}



	public void enviarCorreoCitasPendientes() {
		// TODO Auto-generated method stub
		log.info("en enviarCorreoCitasPendientes ... ");
		listaCitasPendientes=cargarCitasPendientes();
		log.info("citas pendientes cargadas: "+listaCitasPendientes.size());
		log.info("enviando correo ... ");
		if(listaCitasPendientes.size()>0){
			for(int i=0;i<listaCitasPendientes.size();i++){
				enviador.enviaRecordatorioCitaPendiente(listaCitasPendientes.get(i));
			}
		}else{
			log.info("No hay citas pendientes entre hoy 3 dias despues ... ");
		}
	}



	private ArrayList<Cita> cargarCitasPendientes() {
		log.debug("en el dbmapper - cargando Citas Pendientes ...");
		ArrayList<Cita> milista=new ArrayList<Cita>();
		Connection con = null;
		String query="SELECT CODCITA,CODALUMNO,CODTIPOSERVICIO,CORREOPERSONAL,TLFFIJO,TLFCELULAR,FECHAREGISTRO,ESTADO,CODDISPONIBILIDADAS,CODASISTENTASOCIAL FROM "+Helper.schema+"CITA " +
				"WHERE ESTADO='PENDIENTE' AND DATEDIFF(FECHAREGISTRO,NOW())<=3 AND DATEDIFF(FECHAREGISTRO,NOW())>=0";
		
		try {
			con=ConexionBD.getConnection();
			log.debug("query: "+query);
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			
			while(rs.next()){
				Cita micita=new Cita();
				micita.setIntCodCita(rs.getInt("CODCITA"));
				micita.setStrCodAlumno(rs.getString("CODALUMNO"));
				micita.setIntCodTipoServicio(rs.getInt("CODTIPOSERVICIO"));
				micita.setStrCorreoPersonal(rs.getString("CORREOPERSONAL"));
				micita.setStrTelfFijo(rs.getString("TLFFIJO"));
				micita.setStrTelfCelular(rs.getString("TLFCELULAR"));
				micita.setTsFechaRegistro(rs.getTimestamp("FECHAREGISTRO"));
				micita.setStrEstado(rs.getString("ESTADO"));
				micita.setStrCodDisponibilidadas(rs.getString("CODDISPONIBILIDADAS"));
				micita.setStrCodAsistenciaSocial(rs.getString("CODASISTENTASOCIAL"));
				milista.add(micita);
			}
		} catch (SQLException e) {
			log.error("error leyendo las citas: "+e.getMessage());
			milista=null;
			//e.printStackTrace();
		}finally{
			 try {
				 	if (rs != null) {
				 		rs.close();
				 		rs = null;
	                }
	                if (pst != null) {
	                    pst.close();
	                    pst = null;
	                }
	                con.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                log.info("Error al cerrar el statment " + ex.getMessage());
	            }
		}
		
		return milista;
	}

}
