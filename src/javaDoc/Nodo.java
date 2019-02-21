package javaDoc;
/**
 * Clase que contiene los atributos necesarios para construir un objeto de tipo Nodo
 * @author: Victor Sanchez Martin
 * @version: 19/02/2019/
 * @see Visitar <a href = "https://github.com/victorvictorvk/javadoc" />Enlace al repositorio en Github</a>
 *
 */
public class Nodo {

	
	Object info;
	Nodo enlace;
	
	/**
	 * Constructor para crear un objeto de tipo Nodo
	 * @param info, este campo contiene el objeto que formara parte de la lista
	 * @param enlace, es una referencia al Nodo siguiente.
	 */
	public Nodo(Object info, Nodo enlace)
	{
		this.info = info;
		this.enlace = enlace;
	}
	
}
