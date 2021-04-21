/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.util.ArrayList;
import java.util.List;
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
public class Circuito extends Pair<List<Ciudad>, List<Carretera>> {

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
	public static List<Ciudad> ciudades;
	public static List<Carretera> carreteras;
	
	// CONSTRUCTORES DE LA CLASE
	public Circuito(String fichero) {
		
		super(ciudades, carreteras);
		
		// La creación del grafo se delega al método GraphsReader de la librería:
		Graph<Ciudad, Carretera> grafo = GraphsReader.newGraph(
				fichero,
				Ciudad::ofFormat,
				Carretera::ofFormat,
				Graphs2::simpleWeightedGraph,
				Carretera::getKm);
		
		List<Ciudad> lista1 = new ArrayList<Ciudad>();
		for (Ciudad ciudad : grafo.vertexSet()) {
			
			lista1.add(ciudad);
			
		}
		
		List<Carretera> list2 = new ArrayList<Carretera>();
		for (Carretera carretera : grafo.edgeSet()) {
			
			list2.add(carretera);
			
		}
		
		Circuito.ciudades = lista1;
		Circuito.carreteras = list2;
		
	}

	// GETTTERS DE LA CLASE
	
	// Devuelve la lista de ciudades:
	public List<Ciudad> getCiudades() {
		
		return ciudades;
		
	}

	// Devuelve la lista de carreteras:
	public List<Carretera> getCarreteras() {
		
		return carreteras;
		
	}
	
	// TO_STRING DE LA CLASE (Solo para debug)
	@Override
	public String toString() {
		
		return "[Circuito: Ciudades: " + ciudades +  " , carreteras:  " + carreteras + "]";
		
	}
	
}
