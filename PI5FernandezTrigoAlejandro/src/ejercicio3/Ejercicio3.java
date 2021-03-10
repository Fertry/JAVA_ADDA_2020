/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.TopologicalOrderIterator;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.graphs.Graphs2;

/*
Un plan de estudios est� estructurado para que los alumnos no puedan matricularse
libremente de las asignaturas que deseen. Existen asignaturas que deben haberse
cursado (y aprobado) anteriormente para que un alumno se pueda matricular de una
asignatura dada. As�, los prerrequisitos de una asignatura pueden ser 0 o m�s
asignaturas.

a. Implemente un m�todo que devuelva una lista con todas las asignaturas en un
orden que cumpla con los prerrequisitos indicados.

b. Implemente un m�todo que devuelva el conjunto de asignaturas que se pueden
cursar sin tener ninguna aprobada previamente. Muestre el grafo configurando
su apariencia de forma que se resalten dichas asignaturas.

c. Implemente un m�todo que, dado un conjunto de asignaturas que un alumno
tiene aprobadas, devuelva un conjunto con las asignaturas que puede cursar el
pr�ximo a�o. Muestre el grafo configurando su apariencia de forma que se
resalten las asignaturas de ambos conjuntos con 2 colores diferentes.
*/

public class Ejercicio3 {

	/*
	 * Lectura de datos; devuelve un grafo simple de tipo <String, DefaultEdge> que
	 * representa los datos le�dos como nodos (los v�rtices representan a cada
	 * asignatura y las aristas simbolizan un grafo dirigido donde unas asignaturas 
	 * (v�rtices) apuntan a las asignaturas siguientes).
	 */
	private static Graph<String, DefaultEdge> lecturaDatosEjercicio3(String fichero) {

		int i = 0;
		Graph<String, DefaultEdge> grafo = new SimpleDirectedGraph(DefaultEdge.class);
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);
			// Hacer split en base a los dos puntos y trim() a la parte
			// izquierda y derecha que representan los v�rtices y las
			// aristas respectivamente. A las aristas, hay que aplicarles
			// split nuevamente en base a la coma para separarlas:
			String[] contenido = fila.split(":");
			String vertice = contenido[0].trim();
			String aristas = contenido[1].trim().replace("}", "").replace("{", "");
			String[] listaAristas = aristas.split(",");
			
			// A�adir los v�rtices (izquierda) al grafo:
			grafo.addVertex(vertice);
			
			// Recorrer la lista de aristas asocidada a cada v�rtice, mientras
			// que no sea nulo, a�adir al grafo la arista. Repetir para cada v�rtice:
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
	private static void ejercicio3A(Graph<String, DefaultEdge> grafo) {
		
		// Ordenaci�n topol�gica de JGraph:
		TopologicalOrderIterator<String, DefaultEdge> ordenador = new TopologicalOrderIterator<>(grafo);
		
		// Genera una lista de nombres de asignaturas en base al objeto ordenador:
		List<String> resultado = new ArrayList<>();
		ordenador.forEachRemaining(v -> resultado.add(v));
		System.out.println(resultado);
		
	}
	
	/*
	 * Apartado B.1): Devuelve un conjunto de asiugnaturas que pueden ser cursadas/aprobadas SIN necesidad de 
	 * cursar/aprobar NINGUNA asignatura previamente. 
	 */
	private static void ejercicio3B1(Graph<String, DefaultEdge> grafo) {
		
		// Salida por pantalla de datos:
		System.out.println("Las asignaturas que no requieren aprobar otra antes son: ");
		for (String vertice : grafo.vertexSet()) {
			
			// Si el grafo no tiene aristas dirigidas afuera, lo mostramos:
			if (grafo.incomingEdgesOf(vertice).size() == 0) {

				System.out.println(" " + vertice);

			}
		}
		System.out.println("");
		 
	}
	
	/*
	 * Apartado B.2): Muestra el grafo resultante del m�todo ejercicio3B1() coloreando aquellas asignaturas que cumplen
	 * la condici�n del apartado B.1). 
	 */
	private static void ejercicio3B2(Graph<String, DefaultEdge> grafo) {
		
		// Vuelca el resultado en un fichero .gv mediante el m�todo toDot():
		Graphs2.toDot(
				grafo,											// Grafo de entrada
				"salida/salidaEjercicio3B.gv",					// Ruta de salida de fichero
				v -> v,											// Valor de las v�rtices (v)
				e -> "",										// Valor de las aritas a "vac�o"
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
	private static Set<String> ejercicio3C1(Graph<String, DefaultEdge> grafo, Set<String> asignaturas) {
		
		Set<String> resultado = new HashSet<String>();
		
		// Por cada asignatura del grafo:
		for (String vertice : grafo.vertexSet()) { 
			
			Set<String> vertices = new HashSet<String>();
			// Si al grafo, dado un v�rtice NO le entra ning�n otro v�rtice Y el set de asignaturas contiene a todos los padres del v�rtice dado:
			if (!padres(grafo, vertice).isEmpty() && asignaturas.containsAll(padres(grafo, vertice))) {
				
				vertices.add(vertice);
				// Si asignaturas NO contiene todos los v�rtices, se a�ade al set:
				if (!asignaturas.containsAll(vertices)) {
					
					resultado.add(vertice);
					
				}
			}
		}
		
		return resultado;
		
	}
	
	/*
	 * Apartado C.2): Muestra el grafo resultante del m�todo ejercicio3C1() coloreando las asignaturas que pueden cursarse
	 * de un color y las que no de otro distinto. Emplea el m�todo auxiliar colorear() pasando como param�tros el v�rtice, la lista
	 * de asignaturas de entrada y una llamada al m�todo previo. 
	 */
	private static void ejercicio3C2(Graph<String, DefaultEdge> grafo, Set<String> asignaturas, Set<String> resultado) {
		
		// Vuelca el resultado en un fichero .gv mediante el m�todo toDot():
		Graphs2.toDot(
				grafo, 												// Grafo de entrada
				"salida/salidaEjercicio3C.gv",					    // Ruta de salida de fichero
				v -> v,												// Valor de las v�rtices (v)
				e -> "",											// Valor de las aritas a "vac�o"
				v -> colorear(v, asignaturas, resultado),		    // Obtiene el color de la funci�n colorear() en base a la lista de asignaturas de entrada y el resultado del apartado C
				e -> GraphColors.getStyle(Style.bold));				// Define el estilo del grafo
		
	}
	
	/*
	 * M�todo auxiliar para calcular un conjunto con los padres de un v�rtice; esto es, dado el grafo y el nombre del v�rtice, obtiene 
	 * un set con los v�rticess que apuntan a dicho v�rtice dado. 
	 */
	private static Set<String> padres(Graph<String, DefaultEdge> grafo, String vertice) {
		
		Set<String> resultado = new HashSet<String>();
		
		// Por cada arista del v�rtice que se pasa como par�metro:
		for (DefaultEdge arista : grafo.incomingEdgesOf(vertice)) { 

			// Convertir a string y eliminar los caracteres sobrantes:
			String[] aristas = arista.toString().split(":");
			String padre = aristas[0].replace("(", "").trim();
			
			// Si la arista NO es nula, se a�ade al resultado:
			if (!padre.equals("")) {
				
				resultado.add(padre);
				
			}
		}
		
		return resultado;
		
	}

	/*
	 * M�todo auxiliar para, dado un v�rtice de entrada, un set de asignturas seleccionadas y el set devuelto por el m�todo 
	 * del ejercicio 3C, asignar colores a cada v�rtice por separado. Se usa este m�todo al tratarse de una selecci�n de 3
	 * o m�s colores que no permite hacerlo con getColorIf().
	 */
	private static Map<String, Attribute> colorear(String vertice, Set<String> asignaturas, Set<String> resultado) {
		
		// Si el set de asignaturas seleccionadas contiene al v�rtice en cuesti�n:
		if (asignaturas.contains(vertice)) {
			
			return GraphColors.getColor(GraphColors.Color.blue);

    	// Si el set de asignaturas seleccionadas contiene al v�rtice en cuesti�n Y est� en resultado:
		} else if (resultado.contains(vertice)) {
			
			return GraphColors.getColor(GraphColors.Color.yellow);
		
		// Case contrario:
		} else {
			
			return GraphColors.getColor(GraphColors.Color.black);
			
		}
		
	}

	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio3(String fichero) {

		// Lectura de datos de entrada y generaci�n del grafo:
		Graph<String, DefaultEdge> grafo = lecturaDatosEjercicio3(fichero);
		
		// Conjuntos de prueba para el apartado 3:
		Set<String> datosDePrueba1 = new HashSet<>();
		datosDePrueba1.add("Asignatura_01");
		datosDePrueba1.add("Asignatura_02");
		datosDePrueba1.add("Asignatura_03");
		datosDePrueba1.add("Asignatura_04");
		datosDePrueba1.add("Asignatura_05");

		Set<String> datosDePrueba2 = new HashSet<>();
		datosDePrueba2.add("Asignatura_01");
		datosDePrueba2.add("Asignatura_02");
		datosDePrueba2.add("Asignatura_03");
		datosDePrueba2.add("Asignatura_04");
		datosDePrueba2.add("Asignatura_05");
		datosDePrueba2.add("Asignatura_06");
		datosDePrueba2.add("Asignatura_07");
		datosDePrueba2.add("Asignatura_08");
		datosDePrueba2.add("Asignatura_11");
		
		System.out.println("Apartado A). - Asignaturas ordenadas"); 
		 ejercicio3A(grafo);
		 System.out.println("");
		System.out.println("Apartado B.1). - Asignaturas sin requisitos");
		 ejercicio3B1(grafo);
		 System.out.println("");
		System.out.println("Apartado B.2). - Salida volcada en fichero salidaEjercicio3B.gv");
		 System.out.println("");
		 ejercicio3B2(grafo);
		System.out.println("Apartado C.1). - Asignaturas cursables");
		 System.out.println(" Apartado C.1) - Test 1"); 
		 Set<String> resultadoEjercicio3C11 = ejercicio3C1(grafo, datosDePrueba1);
		 System.out.println(resultadoEjercicio3C11);
		 System.out.println("");
		 System.out.println(" Apartado C.1) - Test 2"); 
		 Set<String> resultadoEjercicio3C12 = ejercicio3C1(grafo, datosDePrueba2);
		 System.out.println(resultadoEjercicio3C12);
		 System.out.println("");
		System.out.println("Apartado C.2). - Salida volcada en fichero salidaEjercicio3C.gv\n"); 
		 ejercicio3C2(grafo, datosDePrueba1, resultadoEjercicio3C11);
		 ejercicio3C2(grafo, datosDePrueba2, resultadoEjercicio3C12);
		
	}
	
}
