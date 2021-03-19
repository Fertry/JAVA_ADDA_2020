/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.util.List;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Una academia de ingl�s tiene n alumnos a ser repartidos en m grupos (n m�ltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo n�mero de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no est�
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
*/

public class Ejercicio1 {
	
	/*
	 * Lectura de datos; devuelve un grafo simple de tipo <String, DefaultEdge> que
	 * representa los datos le�dos como nodos.
	 */
	private static Graph<String, DefaultEdge> lecturaDatosEjercicio1(String fichero) {
		
		int i = 0;
		Graph<String, DefaultEdge> grafo = new SimpleGraph(DefaultEdge.class);
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {

			String fila = lista.get(i);
			// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
			// que representa a los alumnos, hacer split nuevamente en base a
			// la coma (en la derecha) para quedarnos con la lista de grupos:
			String[] contenido = fila.split(": ");
			String alumno = contenido[0];
			String[] grupos = contenido[1].split(",");

			// A�adir el v�rtice al grafo vac�o (cada alumno):
			grafo.addVertex(alumno);
			
			// Para cada alumno, a�adimos al grafo las aristas que representan las
			// afinidades a pertenecer a cada uno de los 5 grupos:


//			int j = 0;
//			int k = 0;
//
//			// A�adir al grafo resultante los v�rtices contenidos en grupos[] sin
//			// espacios, comprobando que dicho v�rtice no se encuentra ya dentro:
//			while (j < grupos.length) {
//				while (k < grupos.length) {
//
//					// Si NO est� ya en el grafo:
//					if (!grupos[j].trim().equals(grupos[k].trim())) {
//
//						// A�ade los v�rtices al grafo:
//						grafo.addEdge(grupos[j].trim(), grupos[k].trim());
//
//					}
//
//					// Pasa al siguiente v�rtice:
//					k++;
//
//				}
//
//				// Reinicia el acumulador cuando pasamos al siguiente v�rtice j para
//				// comprobar uno a uno si grupo[j] == grupo[k] y pasa al siguiente j:
//				k = 0;
//				j++;
//
//			}
//
//			// Pasa a la siguiente l�nea del fichero:
//			i++;

		}
		
		return grafo;
		
	}
	
	public static void ejercicio1(String fichero) {
		
		// Lectura de datos de entrada y generaci�n del grafo:
		Graph<String, DefaultEdge> grafo = lecturaDatosEjercicio1(fichero);
		
		System.out.println(grafo);
		
	}

}
