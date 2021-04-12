/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Dado un conjunto de enteros determinar si puede particionarse en tres
	subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
	misma, y que el tama�o de uno de ellos sea lo menor posible.
	
	Se pide solucionar por Programaci�n Lineal
*/

public class Ejercicio4 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * PL que resuelve el ejercicio. 
	*/
	public static List<Integer> elementos;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde la clase PL que resuelve el ejercicio.
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
	 * M�todos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	// Obtiene el elemento dado un indice:
	public static Integer elemento(Integer i) {
		
		return elementos.get(i);
		
	}

	// Obtiene el n� de elementos del conjunto:
	public static Integer getSizeConjunto() {
		
		return elementos.size();
		
	}

	// Obtiene el sumatorio de los elementos de un conjunto partido de 3:
	public static Integer getSumatorio() {
		
		Integer suma = 0;
		
		for (Integer elemento : elementos) {
			
			suma += elemento;;
			
		}
		
		return suma / 3;
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 * Este m�todo difiere del resto en que el fichero de entrada representa no uno
	 * sino varios ejercicios en un mismo fichero por lo que se llama al resolvedor
	 * tantas veces como l�neas de fichero entran.
	*/
	public static void ejercicio4(String fichero) {

		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
		
			// Soluci�n por Programaci�n Lineal:
			try {

				LP4.ejercicio4LP(fichero, i);
				
			} catch (IOException e) {

				System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal ");
				System.out.println("para el fichero: " + fichero + ".\n");
				// e.printStackTrace();

			}
			
			i++;
			
		}
	
	}

}
