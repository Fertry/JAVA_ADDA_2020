/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio1 {
	
	/*
	 * Lectura de datos; devuelve un mapa de tipo <String, List<Integer> que se corresponde a los 
	 * alumnos (claves) junto a la lista de afinidad de pertenencia a los respectivos grupos (valores).
	 */
	private static Map<String, List<Integer>> lecturaDatosEjercicio1(String fichero) {
		
		int i = 0;	
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();
		
		while (i < lista.size()) {

			String linea = lista.get(i);
			// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
			// que representa a los alumnos, hacer split nuevamente en base a
			// la coma (en la derecha) para quedarnos con la lista de grupos:
			String[] contenido = linea.split(": ");
			String alumno = contenido[0];
			String[] grupos = contenido[1].split(",");
			
			// En cada iteración reinicio la lista:
			List<Integer> listaAfinidades = new ArrayList<>();
			
			// Casteo los strings de "grupos" a entero para meterlos en la lista que se almacena en el mapa:
			for (String numero : grupos) {
				
				listaAfinidades.add(Integer.parseInt(numero));
				
			}
			
			// Para cada alumno, añadimos al mapa su nombre (String) y como valor asociado 
			// a dicha clave, la lista de afinidades:
			resultado.put(alumno, listaAfinidades);

			// Pasa a la siguiente línea del fichero:
			i++;

		}
		
		return resultado;
		
	}
	
	private static List<Alumno> lecturaDatosEjercicio1_Test(String fichero) {
		
		int i = 0;	
		List<Alumno> resultado = new ArrayList<Alumno>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {

			String linea = lista.get(i);
			Alumno alumno = Alumno.ofLinea(linea);
			resultado.add(alumno);
			
			// Pasa a la siguiente línea del fichero:
			i++;

		}
		
		return resultado;
		
	}
	
	/*
	 * Repartir a los alumnos en base a su afinidad a pertenecer a cada uno de los 5 grupos (siempre
	 * que no sea 0) de forma que se maximize la afinidad total del grupo y que todos los grupos 
	 * contengan el mismo nº de alumnos. Realizar mediante Programación Lineal (PL).
	 */
	private static void ejercicio1ProgramacionLineal(Map<String, List<Integer>> entrada) {
		
		int i = 0;
		Set<String> alumnos = entrada.keySet();

		for (String alumno : alumnos) {
			int aux = entrada.get(alumno).size();
			while (i < aux) {
				
				System.out.println("Afinidad " + alumno + " grupo " + i + ": " + entrada.get(alumno).get(i).toString());
				i++;
			}
			i=0;
			
		}
		
		/*
		 * Mochila contiene: alumno con peso + valor
		 */
		
	}
	
	/*
	 * Repartir a los alumnos en base a su afinidad a pertenecer a cada uno de los 5 grupos (siempre
	 * que no sea 0) de forma que se maximize la afinidad total del grupo y que todos los grupos 
	 * contengan el mismo nº de alumnos. Realizar mediante Algoritmos Genéticos (GA).
	 */
	private static void ejercicio1AlgoritmosGeneticos() {
		
		//TO-DO
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio1(String fichero) {
		
		// Lectura de datos de entrada:
		//Map<String, List<Integer>> mapa = lecturaDatosEjercicio1(fichero);
		List<Alumno> lista = lecturaDatosEjercicio1_Test(fichero);
		
		// Salida de datos:
		//ejercicio1ProgramacionLineal(mapa);
		//ejercicio1AlgoritmosGeneticos();
		
		System.out.println(" Reparto obtenido: ");
		System.out.println(" ");
		System.out.println(" Afinidad media: ");
		System.out.println(" ");

		//System.out.println(mapa);
		System.out.println(lista);
		
	}

}
