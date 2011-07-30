package sermeden.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sermeden.java.bean.UsuarioDTO;

public interface CitaDAO {

	ArrayList<HashMap<String, Object>> listarTurnosMT();

	List<UsuarioDTO> cargarMedicos();

}
