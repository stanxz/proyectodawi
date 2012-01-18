package servicios;

import entidades.Disponibilidadasistentasocial;


public interface DisponibilidadAsistentaService {
	
	public Disponibilidadasistentasocial obtenerDisponibilidad(String codAsistenta, int eldia) throws Exception;
}
