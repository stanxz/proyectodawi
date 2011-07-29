package sermeden.java.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class CitaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> listadoTurnos;
	
	public Map<String, Object> getListadoTurnos() {
		return listadoTurnos;
	}
	public void setListadoTurnos(Map<String, Object> listadoTurnos) {
		this.listadoTurnos = listadoTurnos;
	}

}
