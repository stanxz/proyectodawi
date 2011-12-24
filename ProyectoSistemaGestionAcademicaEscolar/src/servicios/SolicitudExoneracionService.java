package servicios;

import java.util.ArrayList;

import entidades.Boleta;
import entidades.SolicitudExoneracion;


public interface SolicitudExoneracionService {

	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception;
	public boolean NoExisteDeudas(Boleta boleta) throws Exception;
	public SolicitudExoneracion buscarSolicitudXAsignatura(SolicitudExoneracion exoneracion) throws Exception;
	public void registrarSolictud(SolicitudExoneracion exoneracion) throws Exception;
	
	public ArrayList<SolicitudExoneracion> obtenerSolicitudes() throws Exception;
	public void apruebaSolicitudExoneracion(SolicitudExoneracion exoneracion) throws Exception;
	public void desapruebaSolicitudExoneracion(SolicitudExoneracion exoneracion) throws Exception;
}
