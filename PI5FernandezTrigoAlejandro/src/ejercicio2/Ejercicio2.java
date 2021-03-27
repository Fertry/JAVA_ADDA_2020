/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.graphs.Graphs2;

/*
En una academia se imparten una serie de grupos por parte de un conjunto de
profesores. Cada profesor imparte varios grupos, y cada grupo es impartido por 2
profesores. Para minimizar el tiempo en el que la academia estar� abierta al p�blico,
se van a impartir grupos en paralelo de forma que se minimicen las franjas horarias
con clases.

a. Determine qu� grupos deber�an impartirse en paralelo y cu�ntas franjas
horarias son necesarias, teniendo en cuenta que no se pueden poner en paralelo
grupos impartidos por el mismo profesor.

b. Muestre el problema como un grafo en el que los v�rtices son los grupos, y
configure su apariencia de forma que se muestren los v�rtices coloreados en
funci�n de la franja horaria en la que se impartan. 
*/

public class Ejercicio2 {

	/*
	 * Lectura de datos; devuelve un grafo simple de tipo <String, DefaultEdge> que
	 * representa los datos le�dos como nodos (los v�rtices representan a cada
	 * grupo).
	 */
	@SuppressWarnings("rawtypes")
	private static Graph<String, DefaultEdge> lecturaDatosEjercicio2(String fichero) {

		int i = 0;
		@SuppressWarnings("unchecked")
		Graph<String, DefaultEdge> grafo = new SimpleGraph(DefaultEdge.class);
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

		while (i < lista.size()) {

			String fila = lista.get(i);
			// Hacer split en base a los dos puntos y quedarnos con la parte derecha
			// que representa a la lista de grupos, hacer split nuevamente en base a
			// la coma para quedarnos con una lista de grupos sin espacios:
			String[] contenido = fila.split(":");
			String[] grupos = contenido[1].trim().split(",");

			// A�adir cada nodo/v�rtice (grupo) de la lista al grafo vac�o:
			for (String vertice : grupos) {
				grafo.addVertex(vertice.trim());
			}

			int j = 0;
			int k = 0;

			// A�adir al grafo resultante las aristas contenidos en grupos[] sin
			// espacios, comprobando que dicha conexi�n no se encuentra ya dentro:
			while (j < grupos.length) {
				while (k < grupos.length) {

					// Si NO est� ya conectado en el grafo:
					if (!grupos[j].trim().equals(grupos[k].trim())) {

						// A�ade los v�rtices al grafo:
						grafo.addEdge(grupos[j].trim(), grupos[k].trim());

					}

					// Pasa al siguiente v�rtice:
					k++;

				}

				// Reinicia el acumulador cuando pasamos al siguiente v�rtice j para
				// comprobar uno a uno si grupo[j] == grupo[k] y pasa al siguiente j:
				k = 0;
				j++;

			}

			// Pasa a la siguiente l�nea del fichero:
			i++;

		}

		return grafo;

	}

	/*
	 * Apartado A): Usando el tipo de GreedyColoring, igual al apartado B, obtenemos
	 * un mapa que contiene los grupos del grafo de entrada y como valores, los
	 * colores asociados despu�s de colorear los v�rtices.
	 */
	private static void ejercicio2A(Graph<String, DefaultEdge> grafo) {

		// Crea un objeto de tipo GreedyColoring y colorea el grafo entrante:
		VertexColoringAlgorithm<String> vertice = new GreedyColoring<>(grafo);
		VertexColoringAlgorithm.Coloring<String> verticeColoreado = vertice.getColoring();

		// Crea un mapa donde las claves representan los grupos y sus valores los
		// colores asociados:
		Map<String, Integer> colores = verticeColoreado.getColors();

		// Crea un mapa conteniendo las franjas horarias como claves y los grupos
		// asociados a cada una:
		Map<Integer, List<String>> mapa = new HashMap<Integer, List<String>>();

		for (Entry<String, Integer> entry : colores.entrySet()) {

			// Lista de grupos vaciada en cada iteraci�n:
			List<String> lista = new ArrayList<String>();

			if (mapa.containsKey(colores.get(entry.getKey()))) {

				lista = mapa.get(colores.get(entry.getKey()));

			}

			// A�adir a la lista el grupo y meterlo en el mapa:
			lista.add(entry.getKey());
			mapa.put(colores.get(entry.getKey()), lista);

		}

		// Salida por pantalla de datos:
		System.out.println(" N� de franjas horarias necesarias: " + verticeColoreado.getNumberColors());
		System.out.println(" Grupos a impartirse en paralelo seg�n franja horaria: ");

		for (int i = 0; i < verticeColoreado.getNumberColors(); i++) {

			// Por cada franja horaria, muestra el n� junto con los grupos (en el mapa)
			// asociados a la misma:
			System.out.print(" Franja n� " + (i + 1) + ": " + mapa.get(i));

		}

	}

	/*
	 * Apartado B): Muestra el problema como un grafo donde los nodos/v�rtices
	 * representan los grupos y colorea los nodos/v�rtices en base a la franja
	 * horaria en la que se imparten dichos grupos. Usa la clase GreedyColoring para
	 * colorear los nodos del grafo como un problema de coloreado de v�rtices.
	 */
	private static void ejercicio2B(Graph<String, DefaultEdge> grafo) {

		// Crea un objeto de tipo GreedyColoring y colorea el grafo entrante:
		VertexColoringAlgorithm<String> vertice = new GreedyColoring<>(grafo);
		VertexColoringAlgorithm.Coloring<String> verticeColoreado = vertice.getColoring();

		// Crea un mapa donde las claves representan los grupos y sus valores los
		// colores asociados:
		Map<String, Integer> colores = verticeColoreado.getColors();

		// Vuelca el resultado en un fichero .gv mediante el m�todo toDot():
		Graphs2.toDot(
				grafo, 										// Grafo de entrada
				"salida/salidaEjercicio2.gv", 				// Ruta de salida de fichero
				x -> x, 									// Valor de las aristas que unen los
				x -> "", 							        // v�rtices (en blanco) para no aparecer en el .gv
				x -> GraphColors.getColor(colores.get(x)), 	// Obtiene el color asociado del mapa
				e -> GraphColors.getStyle(Style.bold) 		// Define el estilo del grafo
		);

	}

	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio2(String fichero) {

		// Lectura de datos de entrada y generaci�n del grafo:
		Graph<String, DefaultEdge> grafo = lecturaDatosEjercicio2(fichero);
		
		System.out.println("Apartado A). - Franjas horarias");
		 ejercicio2A(grafo);
		 System.out.println("");
		System.out.println("Apartado B). - Salida volcada en fichero salidaEjercicio2.gv");
		 ejercicio2B(grafo);
		 System.out.println("");
		
	}

}
