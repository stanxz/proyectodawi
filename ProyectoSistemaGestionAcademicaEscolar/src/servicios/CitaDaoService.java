package servicios;

import java.util.ArrayList;

import dao.CitaDAO;
import dao.DAOFactory;
import entidades.Cita;

public class CitaDaoService implements CitaService{
	private DAOFactory fabrica = null;
	private CitaDAO citadao;
	
	public CitaDaoService(int whichFactory) {
		
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.citadao = fabrica.getCitaDAO();
		
	}

	@Override
	public ArrayList<Cita> obtenercitas() throws Exception {
		// TODO Auto-generated method stub
		return citadao.obtenercitas();
	}
	@Override
	public void actualizarEstadoCita(Cita cita) throws Exception {
		 this.citadao.actualizarEstadoCita(cita);
		
	}

	@Override
	public void registrarCita(Cita miciCita) throws Exception {
		// TODO Auto-generated method stub
		citadao.registrarCita(miciCita);
	}

	@Override
	public Cita consultaCitaPendiente(String strCodigoAlumno) throws Exception {
		// TODO Auto-generated method stub
		return citadao.consultaCitaPendiente(strCodigoAlumno);
	}
	
	
	

}
