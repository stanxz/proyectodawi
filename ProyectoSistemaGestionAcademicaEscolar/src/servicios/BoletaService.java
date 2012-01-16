package servicios;

import entidades.Boleta;

public interface BoletaService {

	 public Boleta obtenerBoleta(Boleta temporal) throws Exception;
	 public void registrarBoleta(Boleta laboleta) throws Exception;
	public void actualizaCierredeBoleta(Boleta miboleta)throws Exception;
}
