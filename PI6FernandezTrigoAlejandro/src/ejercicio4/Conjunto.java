/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Pair;

/* Clase conjunto para parsear la entrada por fichero del ejercicio creando objetos de clase Conjunto con 
 * sus respectivos atributos: Id y Lista de elementos. 
*/
public class Conjunto extends Pair<Integer, List<Integer>> {
	
	// MÉTODOS DE LA CLASE
	public static Conjunto ofLinea(String linea) {

		return new Conjunto(linea);

	}
	
	// ATRIBUTOS DE LA CLASE
	private static Integer n = 0;
	public static Integer id; 
	public static List<Integer> elementos;

	// CONSTRUCTORES DE LA CLASE
	public Conjunto(String datos) {
			
		super(id, elementos);
		List<Integer> listaNumeros = new ArrayList<Integer>(); 
		
		String[] contenido = datos.split(", ");

		// Casteo los strings de "contenido" a entero para meterlos en la lista que se guarda en la lista resultado:
		for (String numero : contenido) {
			
			listaNumeros.add(Integer.parseInt(numero));
			
		}

	}
	
	// GETTTERS DE LA CLASE

	// Devuelve la lista de elementos de un Conjunto:
	public List<Integer> getElementos() {
		
		return elementos;
		
	}
	
	// Devuelve el nº de elementos de un Conjunto:
	public Integer getNumeroElementos() {
		
		return elementos.size();
		
	}

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "[" + elementos + "]";
		
	}
	
}
