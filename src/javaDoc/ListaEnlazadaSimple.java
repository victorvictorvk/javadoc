package javaDoc;

public class ListaEnlazadaSimple {
	/**
	 * una lista enlazada simple es una coleccion de nodos enlazados.
	 * Cada nodo tendrá como mínimo dos atributos: informacion y enlace.
	 * Información será la referencia del objeto que queremos almacenar.
	 * Enlace: es la refrencia de otro nodo.
	 * Siempre tendremos una referencia llamada inicio que apunte al primer nodo de la lista.
	 * El campo enlace del último nodo tiene que valer null.
	 * 
	 * @author: Víctor Sánchez Martín
	 * @version: 19/02/2019/
	 * @see Visitar <a href = "https://github.com/victorvictorvk/javadoc" />Enlace al repositorio en Github</a>
	 *  
	 */
		/**
		 * Variable de tipo Nodo que en un principio apunta a null 
		 * y que irá apuntando a los Nodos que vayamos insertando en la lista.
		 */
		Nodo inicio;//inicio es de tipo NODO
		/**
		 * Constructor por defecto que no recibe ningún parámetro, en el cual la variable
		 * inicio apunta a null.
		 */
		
		public ListaEnlazadaSimple()
		{
			inicio = null;//porque no apunta a nada
		}
		
		/**
		 * Este método recibe un objeto de tipo Object y lo inserta al principio de la lista enlazada.
		 * @param obj: es el objeto genérico que recibe el método y que se inserta al comienzo.
		 */
		
		public void insertarPrincipio(Object obj)
		{
			//Creamos un nuevo nodo que se insertara al ppio.
			Nodo nuevo = new Nodo( obj, inicio);
			//Inicio pasa a referenciar al nuevo nodo. eL nuevo nodo se insertará al principio.
			inicio = nuevo;
		}
		
		
		/**
		 * Método que imprime en pantalla todo el contenido de la lista enlazada.
		 * @exception ErrorVacia Esta excepción se lanza cuando intentamos imprimir por pantalla la lista pero está vacía.
		 */
		public void verLista()
		{
			try {
				if(listaVacia())
				{
					throw new ErrorVacia();
				}
				
				//tengo que recorrer la lista con un while
				//necesito coloacarme al ppio de la lista. necesito otra referencia que sea 'actual' que apunte al inicio de la lista
				Nodo actual = inicio;
				while(actual != null)
				{
					System.out.println(actual.info);
					//avanzamos al siguiente nodo
					actual = actual.enlace;
				}
			}catch(ErrorVacia error)
			{
				System.out.println(error.getMessage());

				System.err.println("Error: No se puede mostrar la lista porque está vacía");
			}
			
		}
		
		/**
		 * Método que inserta un nodo al final de la lista.
		 * @param obj: objecto que se le pasa al método como parámetro y que se añade al final.
		 */
		public void insertarAlFinal(Object obj)
		{
			//creamos un nuevo nodo donde en enlace que tenga será null por ser el final de la lista
			Nodo nuevo = new Nodo (obj, null);
			if(listaVacia())
			{
				inicio = nuevo; //esto hace lo mismo que insertar al ppio
				
			}else //Tendremos que conseguir llegar al último NODO. para ello hacemos un recorrido desde el ppio hasta el último nodo(porque de primeras 
				//no sé dónde nos encontramos
			{
				Nodo actual = inicio; //me creo una variable nueva de tipo nodo a la que le asigno la primera posición de la lista.
				while( actual.enlace != null) {//si esto es cierto avanzo al siguiente nodo
					actual = actual.enlace;//este será el ultimo de la lista que yo tenía
				}
				//Enlazamos el ultimo nodo que estaba en la lista con el que yo le he pasado que se convertirá en el último
				actual.enlace = nuevo;
			}
			
		}
		/**
		 * Método que nos indica si la lista está vacía.
		 *	@return <ul>
	     *          <li>true: si la lista está vacía.</li>
	     *          <li>false: si la lista contiene al menos un elemento.</li>
	     *          </ul>
		 */
		public boolean listaVacia()
		{
			return inicio == null; //es como el contructor vacío
		}
		
		/**
		 * Este método busca el elemento a eliminar y lo elimina enlazando el nodo anterior con el siguiente.
		 * Para ello creamos una varibale anterior que apunta a null porque de primeras no apunta a nada.
		 * @param obj: es el objeto que se eliminará de la lista.
		 */
		public void eliminar( Object obj)
		{
		
			//variables
			Nodo anterior =  null; //este nodo anterior lo inicializo a null porque al principio de recorrer la lista no existe
			Nodo actual = inicio;// lo inicializo a inicio para que se sitúe en el primer elemento de la lista
			boolean encontrado =  false;
			while( actual != null && !encontrado)//mientras el Nodo actual(que es el que itera) sea distinto de null(porque null
												//es cuando llega al final de la lista) y No se haya enconrtrado, avanzamos.
			{
				if( actual.info.equals(obj)) 
				{
					encontrado = true;
				}else {
					//si no lo ha encontrado, avanzar al siguiente nodo
					anterior = actual;
					actual = actual.enlace;
				}
			}
			if(encontrado)//si lo ha encontrado, comprobamos si es el primero
			{
				if(anterior == null) {//este es el primero, porque al declarar el nodo llamado anterior le dijimos que fuese null
					// el inicio de la lista pasa a ser el siguiente nodo
					inicio = inicio.enlace;
				}else
				anterior.enlace = actual.enlace;//Enlazamos el nodo anterior con el siguiente
			}
				System.out.println("Éste objeto no existe en la lista!.");
			}
		}

		/**
		 * Esta clase extiene a la clase superior Exception y sirve para 
		 * crear nuestra propia excepción particular cuando la lista está vacía.
		 */
	class ErrorVacia extends Exception
	{
		/**
		 * Constructor que llama a los métodos de la clase superior Exception.
		 */
		public ErrorVacia() 
		{
			super();
		}
	}

