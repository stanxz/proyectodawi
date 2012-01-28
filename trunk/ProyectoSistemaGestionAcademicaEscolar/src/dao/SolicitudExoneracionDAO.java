package dao;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Boleta;
import entidades.SolicitudExoneracion;
import entidades.SolicitudRetiro;

public interface SolicitudExoneracionDAO {
	
	
	public boolean CumpleCalendarioExoneracion(int codigoCalendario) throws Exception;
	public boolean NoExisteDeudas(Boleta boleta) throws Exception;
	public SolicitudExoneracion buscarSolicitudXAsignatura(SolicitudExoneracion exoneracion) throws Exception;
	public void registrarSolictud(SolicitudExoneracion exoneracion) throws Exception;
	
	public ArrayList<SolicitudExoneracion> obtenerSolicitudes() throws Exception;
	public void apruebaSolicitudExoneracion(SolicitudExoneracion exoneracion) throws Exception;
	public void desapruebaSolicitudExoneracion(SolicitudExoneracion exoneracion) throws Exception;
	public  SolicitudRetiro  verificarExistenciaSR(Alumno  alumno) throws Exception;
}
