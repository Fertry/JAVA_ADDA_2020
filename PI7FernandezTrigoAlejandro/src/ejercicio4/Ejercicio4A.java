/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio4;

import java.util.List;

import org.jgrapht.GraphPath;

import heuristicas.HeuristicaConjunto;
import us.lsi.common.Files2;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeConjunto;

public class Ejercicio4A {
	
	public static void EjecutaEjercicio4A(String entrada) {

		/*
		 * La entrada del ejercicio 4 NO representa un único problema sino varios problemas
		 * cada uno en una línea de fichero. Para ejecutarlos todos de forma sistemática 
		 * creo un bucle que ejecute el ejercicio tantas veces cómo líneas de fichero. 
		*/
	
		Integer linea = 0;
		Integer lineas = Files2.linesFromFile(entrada).size();
		
		while (linea < lineas) {
			
			System.out.println("Linea: " + linea);
			EjecutaProblemaEjercicio4A(entrada, linea);
			linea++;
			
		}
	
	}
	
	/*
	 * Este método privado se encarga de ejecutar el algoritmo para UNA línea de fichero específica, es
	 * decir, un problema específico extraido del fichero de entrada.
	*/
	private static void EjecutaProblemaEjercicio4A(String entrada, Integer linea) {
		
		// Inicializa las variables de la clase Ejercicio4 para la línea de fichero proporcionado:
		Ejercicio4.iniDatos(entrada, linea);
		
		System.out.println("Tamaño conjunto: " + Ejercicio4.getSizeConjunto());
		
		// Declarar vértices de inicio y de final para el grafo:
		// VerticeConjunto verticeFinal = VerticeConjunto.verticeFinal();
		VerticeConjunto verticeInicial = VerticeConjunto.verticeInicial();
		
		// Inicializar el grafo virtual:
		/*
		 * 2 vías:
		 * 	· Con peso en el vértice.
		 * 	· Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeConjunto, ActionSimpleEdge<VerticeConjunto, Integer>> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight()); 
		
		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		*/
		AStar<VerticeConjunto, ActionSimpleEdge<VerticeConjunto, Integer>> algoritmoA = GraphAlg.aStarGoal(
				grafoVirtual,
				VerticeConjunto.objetivo(),
				HeuristicaConjunto::heuristica
				);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeConjunto, ActionSimpleEdge<VerticeConjunto, Integer>> caminoA = algoritmoA.search().get();
		
		// Solución: lista de vértices recorridos del grafo: 
		List<VerticeConjunto> vertices = caminoA.getVertexList();
		
		// DEBUG:
		System.out.println(vertices);
		
	}

}
