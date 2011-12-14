package dao;

import java.util.ArrayList;

import entidades.Seccionprogramada;

public interface SeccionProgramadaDAO {
	public ArrayList<Seccionprogramada> obtenerListaGrados(String nivelelegidocombo) throws Exception;
	public Seccionprogramada obtenerSP(Seccionprogramada temporal) throws Exception;
}
