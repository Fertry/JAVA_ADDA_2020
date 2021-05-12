/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio3;

import org.jgrapht.GraphPath;

import aristas.AristaAbogado;
import aristas.AristaProducto;
import ejercicio2.Ejercicio2;
import heuristicas.HeuristicaAbogado;
import heuristicas.HeuristicaProducto;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeAbogado;
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
		
		// Inicializa las variables de la clase Ejercicio2:
		Ejercicio3.iniDatos(entrada);
		
		// Declarar vértices de inicio y de final para el grafo:
		VerticeProducto verticeFinal = VerticeProducto.verticeFinal();
		VerticeProducto verticeInicial = VerticeProducto.verticeInicial();
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeProducto, AristaProducto> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · ????
		 */
		AStar<VerticeProducto, AristaProducto> algoritmoA = GraphAlg.aStarEnd(grafoVirtual, verticeFinal, HeuristicaProducto::heuristica);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeProducto, AristaProducto> caminoA = algoritmoA.search().get();

	}

}
