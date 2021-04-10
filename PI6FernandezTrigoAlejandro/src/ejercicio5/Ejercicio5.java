/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.io.IOException;

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
	private static void salidaGrafo(Graph<Ciudad, Carretera> grafo) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio5.gv",													// Ruta de salida de fichero
				v -> v.getNombre(),															    // Valor de vértices
				e -> e.getKm().toString(),														// Valor de las aristas
				v -> GraphColors.getColor(GraphColors.Color.green),								// Coloreado
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	

	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio5(String fichero) {
		
		// Lectura de datos de entrada:
		Graph<Ciudad, Carretera> grafo = lecturaDatosEjercicio5(fichero);
		
		// Solución por Programación Lineal:
		try {

			AG5.ejercicio5AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Algoritmos Genéticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			//e.printStackTrace();

		}

	}

}
