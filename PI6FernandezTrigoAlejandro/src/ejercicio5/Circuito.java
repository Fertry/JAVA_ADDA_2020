/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import org.jgrapht.Graph;

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
	
	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Circuito " + id + "" + grafo;
		
	}

}
