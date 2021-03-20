/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import org.jgrapht.Graph;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

/*
	Se tiene un grafo cuyos vértices son Ciudades y sus Aristas son Carreteras, y un
	predicado sobre carreteras. Se desea saber cuál es el camino cerrado más corto
	que pase por todos los vértices del grafo una sola vez y que contiene al menos una
	arista que cumple el predicado.
	
	Se pide solucionar por Algoritmos Genéticos
*/

public class Ejercicio5 {
	
	/*
	 * Lectura de datos; devuelve un grafo de tipo <Ciudad, Carretera> siendo estos
	 * clases definidas para nodos/vértices (ciudades) y aristas (carreteras).
	 */
	private static Graph<Ciudad, Carretera> lecturaDatosEjercicio5(String fichero) {

		// Se emplea el método GraphsReader con las clases predefinidas Ciudad y Carreta de la librería
		// para definir un grafo ponderado a partir del fichero de entrada:
		Graph<Ciudad, Carretera> grafo = GraphsReader.newGraph(
				fichero,
				Ciudad::ofFormat,
				Carretera::ofFormat,
				Graphs2::simpleWeightedGraph,
				Carretera::getKm);

		return grafo;

	}
	
	/*
	 * Método privado para volcar los datos del grafo en un fichero de extensión .gv para ser mostrado por pantalla.
	 */
	private static void salidaGrafo(Graph<Ciudad, Carretera> grafo, String nombreFichero) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				nombreFichero,																	// Ruta de salida de fichero
				v -> v.getNombre(),															    // Valor de vértices
				e -> e.getKm().toString(),														// Valor de las aristas
				v -> GraphColors.getColor(GraphColors.Color.green),								// Coloreado
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
	/*
	 * Determina el camino cerrado más corto (minimizar) que pasa por TODOS los vértices UNA SOLA VEZ y que contiene
	 * al menos una arista que cumple el predicado. Realizar mediante Algoritmos Genéticos (GA).
	 */
	private static void ejercicio5AlgoritmosGeneticos() {
		
		//TO-DO
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio5(String fichero) {
		
		// Lectura de datos de entrada:
		Graph<Ciudad, Carretera> grafo = lecturaDatosEjercicio5(fichero);
		
		/*
		 * Para que se pueda llamar múltiples veces al método y que la salida del grafo .gv NO 
		 * sea sobrescrita con cada llamada, obtengo el nº del fichero de entrada y lo concateno 
		 * al String que recibe el método salidaGrafo() para que todos los nombres sean distintos.
		 */
		String texto = fichero.replace("ficheros/PI6Ej5DatosEntrada", "").replace(".txt", "");
		String nombre = "salida/salidaEjercicio5_".concat(texto).concat(".gv");
		
		// Salida del fichero .gv para mostrar el grafo visualmente:
		salidaGrafo(grafo, nombre);
		
		// Salida de datos:
		ejercicio5AlgoritmosGeneticos();
		
		System.out.println(" Predicado Carreteras de ... ");
		System.out.println("  Camino propuesto: ");
		System.out.println("  Coste total: " + " kms");
		System.out.println(" ");
		
		System.out.println(grafo);

	}

}
