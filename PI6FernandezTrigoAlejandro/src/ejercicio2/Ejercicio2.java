/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
	casos relacionados entre s� (m>=n), y deben terminar dicho an�lisis global lo antes
	posible para lo que trabajar�n en paralelo. Cada caso ser� analizado por un �nico
	abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
	horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
	tiempo puede diferir para cada caso en funci�n de qu� abogado realice el an�lisis).
	Determine cu�l es la mejor asignaci�n de casos a abogados para conseguir el
	objetivo indicado (terminar de analizar todos los casos lo antes posible).
	
    Se piden soluciones por Programaci�n Lineal y Algoritmos Gen�ticos
*/

public class Ejercicio2 {
	
	/*
	 * Lectura de datos; devuelve un mapa de tipo <String, List<Integer> que se corresponde a los 
	 * abogados (claves) junto a la lista de horas por caso (posicion) (valores). 
	 */
	private static Map<String, List<Integer>> lecturaDatosEjercicio2(String fichero) {
		
		int i = 0;	
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();
		
		while (i < lista.size()) {

			String fila = lista.get(i);
			// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
			// que representa a los abogados, hacer split nuevamente en base a
			// la coma (en la derecha) para quedarnos con la lista de horas:
			String[] contenido = fila.split(": ");
			String abogado = contenido[0];
			String[] horas = contenido[1].split(",");
			
			// En cada iteraci�n reinicio la lista:
			List<Integer> listaHoras = new ArrayList<>();
			
			// Casteo los strings de "horas" a entero para meterlos en la lista que se almacena en el mapa:
			for (String numero : horas) {
				
				listaHoras.add(Integer.parseInt(numero));
				
			}
			
			// Para cada abogado, a�adimos al mapa su nombre (String) y como valor asociado 
			// a dicha clave, la lista de horas:
			resultado.put(abogado, listaHoras);

			// Pasa a la siguiente l�nea del fichero:
			i++;

		}
		
		return resultado;
		
	}
	
	/*
	 * Repartir a los abogados por casos de forma que se minimice el tiempo invertido en casos.
	 * Un caso solo puede ser investigado por un abogado (no varios) pero un abogado puede investigar
	 * varios casos. Realizar mediante Programaci�n Lineal (PL).
	 */
	private static void ejercicio2ProgramacionLineal() {
		
		//TO-DO
		
	}
	
	/*
	 * Repartir a los abogados por casos de forma que se minimice el tiempo invertido en casos.
	 * Un caso solo puede ser investigado por un abogado (no varios) pero un abogado puede investigar
	 * varios casos. Realizar mediante Algoritmos Gen�ticos (GA).
	 */
	private static void ejercicio2AlgoritmosGeneticos() {
		
		//TO-DO
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio2(String fichero) {
		
		// Lectura de datos de entrada:
		Map<String, List<Integer>> mapa = lecturaDatosEjercicio2(fichero);
		
		// Salida de datos:
		ejercicio2ProgramacionLineal();
		ejercicio2AlgoritmosGeneticos();
		
		System.out.println(" ");
		System.out.println("  Horas empleadas: ");
		System.out.println("  Casos estudiados: ");
		System.out.println("  Media (horas/caso): ");
		System.out.println(" � -- - -- � -- - -- � -- - -- � -- - -- � -- - -- � -- - -- � -- - -- � -- -");
		System.out.println(" El estudio de todos los casos ha supuesto un total de " + " horas de trabajo\n"
				+ "para el bufete, que al trabajar en paralelo se ha podido llevar a cabo en " + " horas.");
		System.out.println(" ");
		
		System.out.println(mapa);
			
	}

}
