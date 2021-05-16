/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

import java.util.List;

import org.jgrapht.GraphPath;

import heuristicas.HeuristicaProducto;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeProducto;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Solución por A*.
*/

public class Ejercicio3A {
	
	public static void EjecutaEjercicio3A(String entrada) {
		
		// Inicializa las variables de la clase Ejercicio3:
		Ejercicio3.iniDatos(entrada);
		
		// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		System.out.println(Ejercicio3.getNProductos());
		System.out.println(Ejercicio3.getRequisitos());
		System.out.println(Ejercicio3.getPrecio(1));
		System.out.println(Ejercicio3.contiene(1, 1));
		// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

		// Declarar vértices de inicio y de final para el grafo:
		// VerticeProducto verticeFinal = VerticeProducto.verticeFinal();
		VerticeProducto verticeInicial = VerticeProducto.verticeInicial();
		
		// Inicializar el grafo virtual:
		/*
		 * 2 vías:
		 * 	· Con peso en el vértice.
		 * 	· Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeProducto, ActionSimpleEdge<VerticeProducto, Integer>> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight()); 
		
		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		*/
		AStar<VerticeProducto, ActionSimpleEdge<VerticeProducto, Integer>> algoritmoA = GraphAlg.aStarGoal(
				grafoVirtual,
				VerticeProducto.objetivo(),
				HeuristicaProducto::heuristica
				);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeProducto, ActionSimpleEdge<VerticeProducto, Integer>> caminoA = algoritmoA.search().get();
		
		// Solución: lista de vértices recorridos del grafo: 
		List<VerticeProducto> vertices = caminoA.getVertexList();
		
		// DEBUG:
		System.out.println(vertices);

	}

}
