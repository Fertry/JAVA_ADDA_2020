/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

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
	 * Lectura de datos; devuelve una lista de tipo List<List<Integer>> que se corresponde a las listas de n�meros
	 * le�dos por fichero l�nea a l�nea. 
	 */
	private static List<List<Integer>> lecturaDatosEjercicio4(String fichero) {
		
		int i = 0;	
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {

			String linea = lista.get(i);
			// Hacer split en base a las comas (junto al espacio) que separan los n�meros:
			String[] contenido = linea.split(", ");

			// En cada iteraci�n reinicio la lista:
			List<Integer> listaNumeros = new ArrayList<>();
			
			// Casteo los strings de "contenido" a entero para meterlos en la lista que se guarda en la lista resultado:
			for (String numero : contenido) {
				
				listaNumeros.add(Integer.parseInt(numero));
				
			}

			// Pasa a la siguiente l�nea del fichero y guarda la listaNumeros en la lista de resultado:
			resultado.add(listaNumeros);
			i++;

		}
		
		return resultado;
		
	}
	
	/*
	 * Particionar el conjunto de entrada en tres subconjuntos de manera que los elementos de estos
	 * sumen igual en los tres y que su tama�o sea el menor posible (minimizar). Realizar mediante
	 * Programaci�n Lineal (PL).
	 */
	private static void ejercicio4ProgramacionLineal() {
		
		//TO-DO
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio4(String fichero) {
		
		// Lectura de datos de entrada:
		List<List<Integer>> listas = lecturaDatosEjercicio4(fichero);
		
		// Salida de datos:
		ejercicio4ProgramacionLineal();
		
		System.out.println(" Conjunto de entrada: ");
		System.out.println(" Suma objetivo: ");
		System.out.println(" o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o");
		System.out.println(" El menor conjunto tiene " + " elemento.");
		System.out.println(" Elementos del conjunto 1: ");
		System.out.println(" Elementos del conjunto 2: ");
		System.out.println(" Elementos del conjunto 3: ");
		System.out.println(" o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o");
		
		System.out.println(listas);
		
	}

}
