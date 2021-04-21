/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import org.jgrapht.Graph;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.common.Pair;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

/* 
 * Clase circuito para parsear la entrada por fichero del ejercicio creando objetos de clase Circuito con 
 * sus respectivos atributos, esto es, el Grafo en si y un ID. Implemento la clase como extensión de Pair.
*/
public class Circuito extends Pair<Graph<Ciudad, Carretera>, Integer> {

	// MÉTODOS DE LA CLASE
	public static Circuito ofFichero(String fichero) {
		
		return new Circuito(fichero);
		
	}
	
	// Método auxiliar para hacer debug: se usa toGraph para mostrar el grafo por pantalla creando una salida de tipo .gv:
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
	
	// ATRIBUTOS DE LA CLASE
	private static Integer n = 0;
	public static Integer id;
	public static Graph<Ciudad, Carretera> grafo;
	
	// CONSTRUCTORES DE LA CLASE
	public Circuito(String fichero) {
		
		super(grafo, n);
		
		// La creación del grafo se delega al método GraphsReader de la librería:
		Graph<Ciudad, Carretera> grafo = GraphsReader.newGraph(
				fichero,
				Ciudad::ofFormat,
				Carretera::ofFormat,
				Graphs2::simpleWeightedGraph,
				Carretera::getKm);
		
		Circuito.id = n + 1;
		Circuito.grafo = grafo;
		
	}
	
	// GETTTERS DE LA CLASE
	
	// Devuelve un objeto de tipo Graph<Ciudad, Carretera> creado:
	public Graph<Ciudad, Carretera> getGrafo() {
		
		return grafo;
		
	}
	
	// TO_STRING DE LA CLASE (Solo para debug)
	@Override
	public String toString() {
		
		return "[Circuito_" + id + ", cuyo grafo es: " + grafo + "]";
		
	}

}
