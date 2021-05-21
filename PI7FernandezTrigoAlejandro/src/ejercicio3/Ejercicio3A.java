/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

import java.util.List;

import org.jgrapht.GraphPath;

import aristas.AristaProducto;
import heuristicas.HeuristicaProducto;
import soluciones.Solucion3;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
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
	
		// Declarar vértice de inicio para el grafo:
		VerticeProducto verticeInicial = VerticeProducto.verticeInicial();
		
		// Inicializar el grafo virtual:
		/*
		 * 2 vías:
		 * 	· Con peso en el vértice.
		 * 	· Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeProducto, AristaProducto> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight()); 
		
		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		*/
		AStar<VerticeProducto, AristaProducto> algoritmoA = GraphAlg.aStarGoal(
				grafoVirtual,
				VerticeProducto.objetivo(),
				HeuristicaProducto::heuristica
				);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeProducto, AristaProducto> caminoA = algoritmoA.search().get();
		
		// Solución: lista de aristas recorridos del grafo: 
		List<AristaProducto> aristas = caminoA.getEdgeList();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ A ESTRELLA $$$$$$$$$$$$$$$$$$$$$$$");
		Solucion3.solucion(aristas, entrada);
		
		// DEBUG:
		/*
		 * List<VerticeProducto> vertices = caminoA.getVertexList();
		 * System.out.println(vertices);
		*/

	}

}
