/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
	misma, y que el tama�o de uno de ellos sea lo menor posible.
*/

public class Ejercicio4 {
	
	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	private static List<Integer> elementos;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * 
	 * Este m�todo particular tiene c�mo diferencia del resto un segundo par�metro para indicar 
	 * qu� l�nea de fichero se est� leyendo ya que cada l�nea, representa un problema distinto. 
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
	 * M�todos auxiliares para resolver el problema.
	*/
	
	// Obtiene el elemento dado un indice:
	public static Integer elemento(Integer i) {
		
		return elementos.get(i);
		
	}

	// Obtiene el n� de elementos del conjunto:
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
