package dao;

import java.util.ArrayList;

import entidades.Boleta;
import entidades.SolicitudRetiro;

public interface SolicitudRetiroDAO {

	public boolean NoExisteDeudas(Boleta boleta) throws Exception;
	public SolicitudRetiro buscarSolicitudXAlumnoXAño(SolicitudRetiro sr) throws Exception;
	public void registrarSolictud(SolicitudRetiro sr) throws Exception;
	
	public ArrayList<SolicitudRetiro> obtenerTodasSolicitudes() throws Exception;
	public ArrayList<SolicitudRetiro> obtenerSolicitudesPendientes() throws Exception;
}
