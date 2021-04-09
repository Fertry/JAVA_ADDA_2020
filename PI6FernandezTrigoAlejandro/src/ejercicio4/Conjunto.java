/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.util.ArrayList;
import java.util.List;

// Clase conjunto para parsear la entrada por fichero del ejercicio creando objetos de clase Conjunto con 
// sus respectivos atributos: Nombre y Lista de elementos.
public class Conjunto {
	
	// MÉTODOS DE LA CLASE
	public static Conjunto of() {

		return new Conjunto();

	}

	public static Conjunto ofLinea(String linea) {

		return new Conjunto(linea);

	}
	
	// ATRIBUTOS DE LA CLASE
	public static String nombre;
	public static List<Integer> elementos;

	// CONSTRUCTORES DE LA CLASE
	public Conjunto() {
				
		Conjunto.nombre = null;
		Conjunto.elementos = null;
			
	}

	// Este constructor representa el constructor principal de la clase encargado de parsear cada línea de fichero:
	private Conjunto(String datos) {
			
		super();
		List<Integer> listaNumeros = new ArrayList<Integer>(); 
		
		// Secuencia de trims y splits:
		//

		String[] contenido = datos.split(", ");

		// Casteo los strings de "contenido" a entero para meterlos en la lista que se guarda en la lista resultado:
		for (String numero : contenido) {
			
			listaNumeros.add(Integer.parseInt(numero));
			
		}

	}
	
	// GETTTERS DE LA CLASE
	// Devuelve el nombre de un Alumno:
	public String getNombre() {
		
		return nombre;
		
	}

	// Devuelve la lista de afinidades de un Alumno:
	public List<Integer> getElementos() {
		
		return elementos;
		
	}
	
	// Devuelve el nº de afinidades de un Alumno:
	public Integer getNumeroElementos() {
		
		return elementos.size();
		
	}

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Conjunto " + nombre + "[" + elementos + "]";
		
	}
	
}
