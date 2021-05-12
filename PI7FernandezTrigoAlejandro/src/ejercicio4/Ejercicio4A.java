/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio4;

import org.jgrapht.GraphPath;

import aristas.AristaConjunto;
import heuristicas.HeuristicaConjunto;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeConjunto;

public class Ejercicio4A {
	
	public static void EjecutaEjercicio4A(String entrada) {
		
		// Inicializa las variables de la clase Ejercicio4:
		Ejercicio4.iniDatos(entrada, 0);
		
		// Declarar vértices de inicio y de final para el grafo:
		VerticeConjunto verticeFinal = VerticeConjunto.verticeFinal();
		VerticeConjunto verticeInicial = VerticeConjunto.verticeInicial();
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeConjunto, AristaConjunto> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · ????
		 */
		AStar<VerticeConjunto, AristaConjunto> algoritmoA = GraphAlg.aStarEnd(grafoVirtual, verticeFinal, HeuristicaConjunto::heuristica);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeConjunto, AristaConjunto> caminoA = algoritmoA.search().get();

	}

}
