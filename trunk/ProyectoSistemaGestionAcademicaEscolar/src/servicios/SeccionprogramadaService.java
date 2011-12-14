package servicios;

import java.util.ArrayList;
import entidades.Seccionprogramada;

public interface SeccionprogramadaService {
	public ArrayList<Seccionprogramada> obtenerListaGrados(String nivelelegidocombo) throws Exception;
	public Seccionprogramada obtenerSP(Seccionprogramada temporal) throws Exception;
}
