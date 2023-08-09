package Practica6;

public class E04ListaEnlazada {

	public static void main(String[] args) {
		ListaEnlazada listaCompra = new ListaEnlazada();
		listaCompra.add("Leche");
		listaCompra.add("Miel");
		listaCompra.add("Aceitunas");
		listaCompra.add("Cerveza");
		listaCompra.add("Café");
		listaCompra.add(0, "Agua");
		listaCompra.add(3, "Azúcar");
		
		System.out.println("Lista de la compra:\n");
		for (int i = 0; i < listaCompra.size(); i++) {
			System.out.println(listaCompra.get(i));
		}
		System.out.println("\n------\n");
		System.out.println("elementos en la lista: " + listaCompra.size());
		System.out.println("elementos 3 en la lista: " + listaCompra.get(3));
		System.out.println("posición del elemento Miel: " + listaCompra.indexOf("Miel"));
		System.out.println("eliminado: " + listaCompra.remove("Miel"));
		System.out.println("posición del elemento Miel: " + listaCompra.indexOf("Miel"));
		System.out.println("\n------\n");

		ListaEnlazada listaBorrado = new ListaEnlazada();
		listaBorrado.add("Aceitunas");
		listaBorrado.add("Patatas");
		listaBorrado.add("Cerveza");
		listaCompra.removeAll(listaBorrado);
		
		System.out.println("Lista de la compra tras borrado:\n");
		for (int i = 0; i < listaCompra.size(); i++) {
			System.out.println(listaCompra.get(i));
		}

	}

}

class ListaEnlazada {

	// Atributos
	private Nodo primero; // Referencia a nodo
	private int numElementos;

	// Métodos
	/**
	 * Constructor que inicializa los atributos al valor por defecto. Lista vacía.
	 */
	public ListaEnlazada() {
		primero = null;
		numElementos = 0;
	}

	/**
	 * Añade un elemento al final de la lista.
	 * 
	 * @param elem - el elemento a añadir. Admite que el elemento a añadir sea null.
	 */

	public void add(Object dato) {
		// variables auxiliares
		Nodo nuevo = new Nodo(dato);
		Nodo ultimo = null;
		if (numElementos == 0) {
			// Si la lista está vacía enlaza el nuevo nodo el primero.
			primero = nuevo;
		} else {
			// Obtiene el último nodo y enlaza el nuevo.
			ultimo = obtenerNodo(numElementos - 1);
			ultimo.siguiente = nuevo;
		}
		numElementos++; // Actualiza el número de elementos.
	}
	
	/**
	 * Inserta un elemento en la posición especificada por el índice.
	 * 
	 * @param indice   - indica la posición de inserción en la lista.
	 * @param dato - elemento a insertar.
	 * @throws IndexOutOfBoundsException
	 */

	public void add(int indice, Object dato) {
		// El índice debe ser válido.
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		
		//añadir al principio
		if (indice == 0) {
			addPrimero(dato);
		} else { //añadir en posición intermedia
			addIntermedio(dato, indice);
		}
		
		numElementos++;
	}

	/**
	 * Añade un dato en la primera posición.
	 * 
	 * @param dato – a insertar.
	 */
	private void addPrimero(Object dato) {
		
		Nodo nuevo = new Nodo(dato);
		// Si la lista está vacía lo enlaza al primero.
		if (numElementos == 0) {
			primero = nuevo;
		} else {
			nuevo.siguiente = primero;
			primero = nuevo;
		}
		
	}
	/**
	 * Inserta el elemento indicado en ese índice.
	 * 
	 * @param dato – a insertar.
	 * @param indice - posición del elemento a insertar.
	 */
	private void addIntermedio(Object dato, int indice) {
		
		Nodo nuevo = new Nodo(dato);
		Nodo anterior = obtenerNodo(indice-1);
		nuevo.siguiente = anterior.siguiente;
		anterior.siguiente = nuevo;
		
	}

	/**
	 * Obtiene el nodo correspondiente al índice. Recorre secuencialmente la cadena
	 * de enlaces.
	 * 
	 * @param indice - posición del nodo a obtener.
	 * @return - el nodo que ocupa la posición indicada por el índice.
	 */

	private Nodo obtenerNodo(int indice) {
		assert indice >= 0 && indice < numElementos;
		// Recorre la lista hasta llegar al nodo de posición buscada.
		Nodo actual = primero;
		for (int i = 0; i < indice; i++)
			actual = actual.siguiente;
		return actual;
	}

	/**
	 * Elimina el elemento indicado por el índice. Ignora índices negativos
	 * 
	 * @param indice - posición del elemento a eliminar
	 * @return - el elemento eliminado o null si la lista está vacía.
	 * @exception IndexOutOfBoundsException - índice no está entre 0 y
	 *                                      numElementos-1
	 */

	public Object remove(int indice) {
		// Lanza excepción si el índice no es válido.
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		if (indice > 0) {
			return removeIntermedio(indice);
		}
		if (indice == 0) {
			return removePrimero();
		}
		return null;
	}

	/**
	 * Elimina el primer elemento.
	 * 
	 * @return - el elemento eliminado o null si la lista está vacía.
	 */

	private Object removePrimero() {
		// variables auxiliares
		Nodo actual = primero; // Guarda actual.
		primero = primero.siguiente; // Elimina elemento del principio.
		numElementos--;
		return actual.dato;
	}

	/**
	 * Elimina el elemento indicado por el índice.
	 * 
	 * @param indice - posición del elemento a eliminar.
	 * @return - el elemento eliminado o null si la lista está vacía.
	 */

	private Object removeIntermedio(int indice) {
		assert indice > 0 && indice < numElementos;
		// variables auxiliares
		Nodo actual = null;
		Nodo anterior = null;
		// Busca nodo del elemento anterior correspondiente al índice.
		anterior = obtenerNodo(indice - 1);
		actual = anterior.siguiente; // Guarda actual.
		anterior.siguiente = actual.siguiente; // Elimina el elemento.
		numElementos--;
		return actual.dato;
	}

	/**
	 * Elimina el dato especificado.
	 * 
	 * @param dato – a eliminar.
	 * @return - el índice del elemento eliminado o -1 si no existe.
	 */

	public int remove(Object dato) {
		// Obtiene el índice del elemento especificado.
		int actual = indexOf(dato);
		if (actual != -1) {
			remove(actual); // Elimina por índice.
		}
		return actual;
	}
	
	
	/**
	 * Elimina los datos que se encuentran en otra lista
	 * 
	 * @param datosAborrar – lista con los datos a borrar.
	 * 
	 */
	public void removeAll(ListaEnlazada datosAborrar) {
		
		for (int i = 0; i < datosAborrar.size(); i++) {
			remove(datosAborrar.get(i));
		}
	}
	
	/**
	 * Elimina todos los datos que se encuentran en la lista
	 * 
	 */
	public void removeAll() {
		primero = null;
		numElementos = 0;
	}

	/**
	 * Busca el índice que corresponde a un elemento de la lista.
	 * 
	 * @param dato- el objeto elemento a buscar.
	 */

	public int indexOf(Object dato) {
		Nodo actual = primero;
		for (int i = 0; actual != null; i++) {
			if ((actual.dato != null && actual.dato.equals(dato)) || actual.dato == dato) {
				return i;
			}
			actual = actual.siguiente;
		}
		return -1;
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
	 * @return el número de elementos de la lista
	 */

	public int size() {
		return numElementos;
	}

}

/**
 * Representa la estructura de un nodo para una lista dinámica con enlace
 * simple.
 */

class Nodo {
// Atributos
	Object dato;
	Nodo siguiente;

	/**
	 * Constructor que inicializa atributos por defecto.
	 * 
	 * @param elem - el elemento de información útil a almacenar.
	 */
	public Nodo(Object dato) {
		this.dato = dato;
		siguiente = null;
	}

}
