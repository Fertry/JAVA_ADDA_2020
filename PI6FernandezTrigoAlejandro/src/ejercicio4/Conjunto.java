/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.util.ArrayList;
import java.util.List;

// Clase conjunto para parsear la entrada por fichero del ejercicio creando objetos de clase Conjunto con 
// sus respectivos atributos: Nombre y Lista de elementos.
public class Conjunto {
	
	// M�TODOS DE LA CLASE
	public static Conjunto ofLinea(String linea) {

		return new Conjunto(linea);

	}
	
	// ATRIBUTOS DE LA CLASE
	public static List<Integer> elementos;

	// CONSTRUCTORES DE LA CLASE
	public Conjunto(String datos) {
			
		super();
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
	
	// Devuelve el n� de elementos de un Conjunto:
	public Integer getNumeroElementos() {
		
		return elementos.size();
		
	}

	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "[" + elementos + "]";
		
	}
	
}
