package sermeden.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sermeden.java.bean.UsuarioDTO;

public interface CitaDAO {

	ArrayList<HashMap<String, Object>> listarTurnosMT();

	List<UsuarioDTO> cargarMedicos();

	List<HashMap<String, Object>> cargarHorasDispXFechaXMedico(String medicoCita,
			String fechaCita);

	List<Integer> cargarHorariosCitasHechas(String medicoCita, String fechaCita);

}
