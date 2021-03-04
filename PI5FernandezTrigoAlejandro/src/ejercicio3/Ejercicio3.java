/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio3;

import java.util.List;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.graphs.Graphs2;

/*
Un plan de estudios está estructurado para que los alumnos no puedan matricularse
libremente de las asignaturas que deseen. Existen asignaturas que deben haberse
cursado (y aprobado) anteriormente para que un alumno se pueda matricular de una
asignatura dada. Así, los prerrequisitos de una asignatura pueden ser 0 o más
asignaturas.

a. Implemente un método que devuelva una lista con todas las asignaturas en un
orden que cumpla con los prerrequisitos indicados.

b. Implemente un método que devuelva el conjunto de asignaturas que se pueden
cursar sin tener ninguna aprobada previamente. Muestre el grafo configurando
su apariencia de forma que se resalten dichas asignaturas.

c. Implemente un método que, dado un conjunto de asignaturas que un alumno
tiene aprobadas, devuelva un conjunto con las asignaturas que puede cursar el
próximo año. Muestre el grafo configurando su apariencia de forma que se
resalten las asignaturas de ambos conjuntos con 2 colores diferentes.
*/

public class Ejercicio3 {

	/*
	 * Lectura de datos; devuelve un grafo simple de tipo <String, DefaultEdge> que
	 * representa los datos leídos como nodos (los vértices representan a cada
	 * asignatura y las aristas simbolizan un grafo dirigido donde unas asignaturas 
	 * (vértices) apuntan a las asignaturas siguientes).
	 */
	private static Graph<String, DefaultEdge> lecturaDatosEjercicio3(String fichero) {

		int i = 0;
		Graph<String, DefaultEdge> grafo = new SimpleDirectedGraph(DefaultEdge.class);
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);
			// Hacer split en base a los dos puntos y trim() a la parte
			// izquierda y derecha que representan los vértices y las
			// aristas respectivamente. A las aristas, hay que aplicarles
			// split nuevamente en base a la coma para separarlas:
			String[] contenido = fila.split(":");
			String vertice = contenido[0].trim();
			String aristas = contenido[1].trim().replace("}", "").replace("{", "");
			String[] listaAristas = aristas.split(",");
			
			// Añadir los vértices (izquierda) al grafo:
			grafo.addVertex(vertice);
			
			// Recorrer la lista de aristas asocidada a cada vértice, mientras
			// que no sea nulo, añadir al grafo la arista. Repetir para cada vértice:
			if (listaAristas.length >= 1) {
				for (String arista : listaAristas) {
					
					if (arista.trim() != "") {
						
						grafo.addEdge(arista.trim(), vertice);
						
					}
					
				}
			}
			
			// Pasar a la sig. fila:
			i++;
			
		}

		return grafo;

	}
	
	/*
	 * Apartado A): Devuelve una lista con todas las asignaturas del fichero de entrada ordenadas en 
	 * base a: unas asignaturas deben cursarse/aprobarse ANTES de poder acceder a la siguiente (Ej: Asignatura_06
	 * necesita cursar/aprobar Asignatura_01 ANTES de poder seleccionarla). 
	 */
	private static void ejercicio3A() {
		
	}
	
	/*
	 * Apartado B.1): Devuelve un conjunto de asiugnaturas que pueden ser cursadas/aprobadas SIN necesidad de 
	 * cursar/aprobar NINGUNA asignatura previamente. 
	 */
	private static void ejercicio3B1(Graph<String, DefaultEdge> grafo) {
		
		// Salida por pantalla de datos:
		System.out.println("Las asignaturas que no requieren aprobar otra antes son: ");
		for (String vertice : grafo.vertexSet()) {

			if (grafo.incomingEdgesOf(vertice).size() == 0) {

				System.out.println(" " + vertice);

			}
		}
		System.out.println("");
		 
	}
	
	/*
	 * Apartado B.2): Muestra el grafo resultante del método ejercicio3B1() coloreando aquellas asignaturas que cumplen
	 * la condición del apartado B.1). 
	 */
	private static void ejercicio3B2(Graph<String, DefaultEdge> grafo) {
		
		// Vuelca el resultado en un fichero .gv mediante el método toDot():
		Graphs2.toDot(
				grafo,											// Grafo de entrada
				"salida/salidaEjercicio3B.gv",					// Ruta de salida de fichero
				v -> v,											// Valor de las vértices (v)
				e -> "",										// Valor de las aritas a "vacío"
				v -> GraphColors.getColorIf(					// Condicional: en base al booleano devuelto
						GraphColors.Color.green,   				// por grafo.incomingEdgesOf(v).size() == 0
						GraphColors.Color.black,				// (apartado B.1), colorea en verde o negro 
						grafo.incomingEdgesOf(v).size() == 0),	// el nodo correspondiente.
				e -> GraphColors.getStyle(Style.bold));			// Define el estilo del grafo
		
	}
	
	/*
	 * Apartado C.1): Devuelve un conjunto de asignaturas que pueden ser cursadas/aprobadas, dado un 
	 * conjunto de asignaturas que ya han sido cursadas/aprobadas previamente. 
	 */
	private static void ejercicio3C1() {
		
	}
	
	/*
	 * Apartado C.2): Muestra el grafo resultante del método ....() coloreando las asignaturas que pueden cursarse
	 * de un color y las que no de otro distinto. 
	 */
	private static void ejercicio3C2() {
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio3(String fichero) {

		Graph<String, DefaultEdge> grafo = lecturaDatosEjercicio3(fichero);
		
		System.out.println("Apartado A). - Asignaturas ordenadas\n"); 
		ejercicio3A();
		System.out.println("Apartado B.1). - Asignaturas sin requisitos\n");
		ejercicio3B1(grafo);
		System.out.println("Apartado B.2). - Salida volcada en fichero salidaEjercicio3B.gv\n");
		ejercicio3B2(grafo);
		System.out.println("Apartado C.1). - Asignaturas cursables\n");
		System.out.println(" Apartado C.1) - Test 1\n"); ejercicio3C1();
		System.out.println(" Apartado C.1) - Test 2\n"); ejercicio3C1(); System.out.
		println("Apartado C.2). - Salida volcada en fichero salidaEjercicio3C.gv\n"); 
		System.out.println(" Apartado C.1) - Test 1\n"); ejercicio3C2();
		System.out.println(" Apartado C.1) - Test 2\n"); ejercicio3C2();
		
	}
	
}
