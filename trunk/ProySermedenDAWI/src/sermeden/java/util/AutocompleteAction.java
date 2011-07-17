package sermeden.java.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class AutocompleteAction {

	private List<String> cursos;
	private String cursoFavorito;

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}
	public String getCursoFavorito() {
		return cursoFavorito;
	}
	public void setCursoFavorito(String cursoFavorito) {
		this.cursoFavorito = cursoFavorito;
	}

	public String execute(){
		System.out.println("Curso Favorito "+cursoFavorito);
		cursos=new ArrayList<String>();
		cursos.add("Desarrollo de aplicaciones Web I");
		cursos.add("Programacion Orientada a Objetos II");
		cursos.add("Estructura de Datos");
		cursos.add("Desarrollo de Aplicaciones Distribuidas");
		cursos.add("Ninguno");
		
		return Action.SUCCESS;
	}

}
