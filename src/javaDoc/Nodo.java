package javaDoc;

public class Nodo {
	/**
	 * @author: Víctor Sánchez Martín
	 * @version: 19/02/2019/
	 * @see <a href = "http://www.aprenderaprogramar.com" /> aprenderaprogramar.com – Didáctica en programación </a>
	 */
	
	Object info;
	Nodo enlace;
	
	/**
	 * Constructor para crear un objeto de tipo Nodo
	 * @param info, este campo contiene el objeto que formará parte de la lista
	 * @param enlace, es una referencia al Nodo siguiente.
	 */
	public Nodo(Object info, Nodo enlace)
	{
		this.info = info;
		this.enlace = enlace;
	}
	
}
