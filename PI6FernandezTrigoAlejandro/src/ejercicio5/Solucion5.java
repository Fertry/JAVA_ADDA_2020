/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.util.List;

import org.jgrapht.Graph;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;

/*
 * Clase solución que pretende parsear la salida la salida de algoritmos genéticos para mostrar 
 * los resultados acordes al fichero de resultados.
 */
public class Solucion5 {
	
	// Función que dado una solución de Algoritmos Genéticos parsea la solución:
	public static void solucionAG5(String fichero, List<Integer> entrada) {
		
		
	}
	
	// Función que parsea la salida de solucionAG5 para mostrar el resultado por pantalla:
	public static void formateo() {
		
		
	}
	
	/*
	 * Método para volcar los datos del grafo en un fichero de extensión .gv para ser mostrado por pantalla.
	*/
	public static void salidaGrafo(Graph<Ciudad, Carretera> grafo, String fichero) {

		String ruta = "salida/salidaEjercicio5_" + fichero.replace("ficheros/PI6Ej5DatosEntrada", "").replace(".txt", "") + ".gv";
		
		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				ruta,																			// Ruta de salida de fichero
				v -> v.getNombre(),															    // Valor de vértices
				e -> e.getKm().toString(),														// Valor de las aristas
				v -> GraphColors.getColor(GraphColors.Color.green),								// Coloreado
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
}
