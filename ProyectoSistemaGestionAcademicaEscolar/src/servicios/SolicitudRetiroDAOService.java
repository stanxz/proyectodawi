package servicios;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.SolicitudRetiroDAO;

import entidades.Boleta;
import entidades.SolicitudRetiro;

public class SolicitudRetiroDAOService implements SolicitudRetiroService {

	private DAOFactory fabrica = null;
	private SolicitudRetiroDAO retirodao;
	
	
	public SolicitudRetiroDAOService(int jpa) {
		fabrica = DAOFactory.getDAOFactory(jpa);
		this.retirodao = fabrica.getSolicitudRetiroDAO();
	}

	@Override
	public boolean NoExisteDeudas(Boleta boleta) throws Exception {
		// TODO Auto-generated method stub
		return retirodao.NoExisteDeudas(boleta);
	}

	@Override
	public SolicitudRetiro buscarSolicitudXAlumnoXAño(SolicitudRetiro sr)
			throws Exception {
		// TODO Auto-generated method stub
		return retirodao.buscarSolicitudXAlumnoXAño(sr);
	}

	@Override
	public void registrarSolictud(SolicitudRetiro sr) throws Exception {
		// TODO Auto-generated method stub
		retirodao.registrarSolictud(sr);
	}

	@Override
	public ArrayList<SolicitudRetiro> obtenerTodasSolicitudes()
			throws Exception {
		// TODO Auto-generated method stub
		return retirodao.obtenerTodasSolicitudes();
	}

	@Override
	public ArrayList<SolicitudRetiro> obtenerSolicitudesPendientes()
			throws Exception {
		// TODO Auto-generated method stub
		return retirodao.obtenerSolicitudesPendientes();
	}

}
