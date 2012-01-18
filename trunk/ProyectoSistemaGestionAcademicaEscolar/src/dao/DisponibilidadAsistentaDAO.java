package dao;

import entidades.Disponibilidadasistentasocial;

public interface DisponibilidadAsistentaDAO {
	public Disponibilidadasistentasocial obtenerDisponibilidad(String codAsistenta, int eldia) throws Exception;
}
