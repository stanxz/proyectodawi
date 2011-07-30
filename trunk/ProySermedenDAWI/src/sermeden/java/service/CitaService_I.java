package sermeden.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sermeden.java.bean.UsuarioDTO;


public interface CitaService_I {

	ArrayList<HashMap<String, Object>> listadoTurnos();

	List<UsuarioDTO> cargarMedicos();

}
