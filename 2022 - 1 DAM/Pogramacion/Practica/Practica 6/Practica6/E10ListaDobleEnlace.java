package Practica6;


public class E10ListaDobleEnlace {

	public static void main(String[] args) {
		ListaDoble listaCompra = new ListaDoble();
		listaCompra.add("Azucar");
		listaCompra.add("Chocolate");
		listaCompra.add("Helado");
		listaCompra.add("Pistachos");
		listaCompra.add("Cocacola");
		
		System.out.println("Lista de la compra con " + listaCompra.size() + " cosas:\n");
		
		for (int i = 0; i < listaCompra.size(); i++) {
			System.out.println(listaCompra.get(i));
		}
		
		System.out.println("\nLista de la compra obtenida desde el final:\n");
		
		for (int i = 0; i < listaCompra.size(); i++) {
			System.out.println(listaCompra.getInverso(i));
		}
	}
}

/**
 * Representa la implementación básica de una lista doble enlazada.
 */
class ListaDoble {
	private Nodo primero;
	private Nodo ultimo;
	private int numElementos;

	/**
	 * Constructor que inicializa los atributos al valor por defecto.
	 */
	public ListaDoble() {
		primero = null;
		ultimo = null;
		numElementos = 0;
	}

	/**
	 * Añade un elemento al final de la lista
	 * 
	 * @param dato - el dato del elemento a añadir que no sea null
	 */
	public void add(Object dato) {
		addUltimo(dato);
	}

	/**
	 * Inserta un elemento en la posición indicada de la lista.
	 * 
	 * @param indice - posición donde insertar el nuevo nodo.
	 * @param dato   - el dato del elemento a añadir. Admite que sea null.
	 * @exception IndexOutOfBoundsException. índice no está entre 0 y numElementos
	 *                                       numElementos-1
	 */
	public void add(int indice, Object dato) {
		// Lanza excepción si el índice no es válido.
		if (indice < 0 || indice >= numElementos) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		// Nuevo nodo al principio.
		if (indice == 0) {
			insertarPrimero(dato);
		}

		// Nuevo nodo en posiciones intermedias.
		if (indice > 0) {
			insertarIntermedio(indice, dato);
		}
	}

	/**
	 * Inserta un elemento en una posición intermedia de una lista doble enlazada.
	 * 
	 * @param el índice que ocupará el elemento nuevo.
	 * @param el dato del elemento nuevo.
	 */
	private void insertarIntermedio(int indice, Object dato) {
		// Lanza excepción si el índice no es válido.
		if (indice < 0 || indice >= numElementos) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		Nodo nuevo = new Nodo(dato);
		Nodo actual = obtenerNodo(indice); // Donde insertar.
		Nodo anterior = actual.anterior; // Obtiene el anterior.
		actual.anterior = nuevo; // Enlaza el nuevo nodo.
		anterior.siguiente = nuevo;
		nuevo.anterior = anterior; // Ajusta enlaces.
		nuevo.siguiente = actual;
		numElementos++; // Actualiza tamaño.
	}

	/**
	 * Inserta un elemento al principio de una lista doble enlazada.
	 * 
	 * @param el dato del elemento nuevo.
	 */
	private void insertarPrimero(Object dato) {
		Nodo nuevo = new Nodo(dato);

		// La lista está vacía; el nuevo nodo es primero y último.
		if (numElementos == 0) {
			primero = nuevo;
			ultimo = nuevo;
		}
		// La lista no está vacía; el nuevo nodo pasa a ser el primero.
		else {
			Nodo actual = primero; // Dónde insertar.
			actual.anterior = nuevo; // Enlaza el nuevo nodo.
			nuevo.siguiente = actual; // Ajusta enlace.
			primero = nuevo; // Actualiza el nuevo primero.
		}
		numElementos++; // Actualiza tamaño.
	}

	/**
	 * Añade un elemento al final de una lista doble enlazada.
	 * 
	 * @param el dato del elemento nuevo.
	 */
	private void addUltimo(Object dato) {
		Nodo nuevo = new Nodo(dato);
		// La lista está vacía; el nuevo nodo es último y primero.
		if (numElementos == 0) {
			ultimo = nuevo;
			primero = nuevo;
		}
		// La lista no está vacía; el nuevo nodo pasa a ser el último.
		else {
			Nodo actual = ultimo; // Dónde insertar.
			actual.siguiente = nuevo; // Enlaza el nuevo nodo.
			nuevo.anterior = actual; // Ajusta enlace.
			ultimo = nuevo; // Actualiza el nuevo último.
		}
		numElementos++; // Actualiza tamaño.
	}
	
	/**
	 * @return el número de elementos de la lista
	 */

	public int size() {
		return numElementos;
	}

	/**
	 * Obtiene el nodo correspondiente al índice.
	 * 
	 * @param indice - posición del nodo a obtener.
	 * @return el nodo que ocupa la posición indicada por el índice.
	 */
	private Nodo obtenerNodo(int indice) {
		// Lanza excepción si el índice no es válido.
		if (indice < 0 || indice >= numElementos) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		// Recorre la lista hasta llegar a la posición buscada.
		Nodo actual = primero;
		for (int i = 0; i < indice; i++) {
			actual = actual.siguiente;
		}
		return actual;
	}

	/**
	 * Obtiene el nodo correspondiente al índice de forma inversa.
	 * 
	 * @param indice - posición del nodo a obtener.
	 * @return el nodo que ocupa la posición indicada por el índice.
	 */
	private Nodo obtenerNodoInverso(int indice) {
		// Lanza excepción si el índice no es válido.
		if (indice < 0 || indice >= numElementos) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		// Recorre la lista hasta llegar a la posición buscada.
		Nodo actual = ultimo;
		for (int i = numElementos-1; i > indice; i--) {
			actual = actual.anterior;
		}
		return actual;
	}

	/**
	 * Busca el índice que corresponde a un elemento de la lista.
	 * 
	 * @param dato- el objeto elemento a buscar.
	 * @return el indice de la primera ocurrencia del objeto o -1 si no lo encuentra
	 */

	public int indexOf(Object dato) {
		Nodo actual = primero;
		for (int indice = 0; actual != null; indice++) {
			if ((actual.dato != null && actual.dato.equals(dato)) || (actual.dato == null) && (dato == null)) {
				return indice;
			}
			actual = actual.siguiente;
		}
		return -1;
	}

	/**
	 * Comprueba si un elemento esta en la lista
	 * 
	 * @param elem- el objeto elemento a buscar.
	 * @return true si existe el elemento en la lista
	 */

	public boolean contains(Object elem) {
		return indexOf(elem) != -1;
	}

	/**
	 * @param indice – obtiene un elemento por su índice.
	 * @return elemento contenido en el nodo indicado por el índice.
	 * @exception IndexOutOfBoundsException - índice no está entre 0 y
	 *                                      numElementos-1.
	 */

	public Object get(int indice) {
		// lanza excepción si el índice no es válido
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("índice incorrecto: " + indice);
		}
		Nodo aux = obtenerNodo(indice);
		return aux.dato;
	}

	/**
	 * @param indice – obtiene un elemento por su índice de manera inversa.
	 * @return elemento contenido en el nodo indicado por el índice.
	 * @exception IndexOutOfBoundsException - índice no está entre 0 y
	 *                                      numElementos-1.
	 */

	public Object getInverso(int indice) {
		// lanza excepción si el índice no es válido
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("índice incorrecto: " + indice);
		}
		Nodo aux = obtenerNodoInverso(indice);
		return aux.dato;
	}

} // class

/**
 * Representa la estructura de un nodo para una lista enlazada doble.
 */
class Nodo {
	Object dato;
	Nodo anterior;
	Nodo siguiente;

	/**
	 * Constructor que inicializa atributos por defecto.
	 * 
	 * @param dato - el elemento de información útil a almacenar.
	 */
	public Nodo(Object dato) {
		this.dato = dato;
		anterior = null;
		siguiente = null;
	}

} // class
