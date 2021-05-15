/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio2;

import java.util.List;

import org.jgrapht.GraphPath;

import heuristicas.HeuristicaAbogado;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeAbogado;

/*
	Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
	casos relacionados entre sí (m>=n), y deben terminar dicho análisis global lo antes
	posible para lo que trabajarán en paralelo. Cada caso será analizado por un único
	abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
	horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
	tiempo puede diferir para cada caso en función de qué abogado realice el análisis).
	Determine cuál es la mejor asignación de casos a abogados para conseguir el
	objetivo indicado (terminar de analizar todos los casos lo antes posible). 
	
	Solución por A*.
*/

public class Ejercicio2A {
	
	public static void EjecutaEjercicio2A(String entrada) {
		
		// Inicializa las variables de la clase Ejercicio2:
		Ejercicio2.iniDatos(entrada);
		
		// DEBUG:
		System.out.println(Ejercicio2.getNAbogados());
		System.out.println(Ejercicio2.getNCasos());
		
		// Declarar vértices de inicio y de final para el grafo:
		// VerticeAbogado verticeFinal = VerticeAbogado.verticeFinal();
		VerticeAbogado verticeInicial = VerticeAbogado.verticeInicial();
		
		// Inicializar el grafo virtual:
		/*
		 * 2 vías: 
		 * 	· Con peso en el vértice. 
		 * 	· Con peso en las aristas.
		*/
				
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeAbogado, ActionSimpleEdge<VerticeAbogado, Integer>> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		 */
		AStar<VerticeAbogado, ActionSimpleEdge<VerticeAbogado, Integer>> algoritmoA = GraphAlg.aStarGoal(
				grafoVirtual,
				VerticeAbogado.objetivo(),
				HeuristicaAbogado::heuristica
				);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeAbogado, ActionSimpleEdge<VerticeAbogado, Integer>> caminoA = algoritmoA.search().get();
		
		// Solución: lista de vértices recorridos del grafo: 
		List<VerticeAbogado> vertices = caminoA.getVertexList();
		
		// DEBUG:
		System.out.println(vertices);

	}
	
}
