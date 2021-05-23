/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Conjunto;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Dado un conjunto de enteros determinar si puede particionarse en tres
	subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
	misma, y que el tamaño de uno de ellos sea lo menor posible.
*/

public class Ejercicio4 {
	
	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	private static List<Integer> elementos;
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * 
	 * Este método particular tiene cómo diferencia del resto un segundo parámetro para indicar 
	 * qué línea de fichero se está leyendo ya que cada línea, representa un problema distinto. 
	*/
	public static void iniDatos(String fichero, Integer indice) {
		
		// Inicializar las variables de la clase Ejercicio4:
		elementos = new ArrayList<Integer>();
		
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
        
		// Creo un objeto de tipo Conjunto del cual extraer sus propiedades:
		Conjunto conjunto = Conjunto.ofLinea(lista.get(indice));
		
		for (Integer elemento : conjunto.getElementos()) {
			
			elementos.add(elemento);
			
		}
		
	}
	
	/*
	 * Métodos auxiliares para resolver el problema.
	*/
	
	// Obtiene el elemento dado un indice:
	public static Integer elemento(Integer i) {
		
		return elementos.get(i);
		
	}

	// Obtiene el nº de elementos del conjunto:
	public static Integer getSizeConjunto() {
		
		return elementos.size();
		
	}

	// Obtiene el sumatorio de los elementos de un conjunto partido entre tres:
	public static Integer getSumatorio() {
		
		Integer suma = 0;
		
		for (Integer elemento : elementos) {
			
			suma += elemento;;
			
		}
		
		return suma / 3;
		
	}
	
}
