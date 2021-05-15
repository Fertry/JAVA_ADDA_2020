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
import us.lsi.graphs.alg.DPR;
import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeProducto;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Solución por Programación Dinámica.
*/

public class Ejercicio3PD {

	public static void EjecutaEjercicio3PD(String entrada) {

		// Inicializa las variables de la clase Ejercicio3:
		Ejercicio3.iniDatos(entrada);

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

		// Invocar el algoritmo de Programación Dinámica:
		/*
		 * 2 vías: 
		 * 	· Expresando el vértice final de destino. 
		 * 	· Mediante un predicado objetivo.
		 */
		DynamicProgrammingReduction<VerticeProducto, ActionSimpleEdge<VerticeProducto, Integer>> algoritmoPD = DPR.dynamicProgrammingReductionGoal(
						grafoVirtual,
						VerticeProducto.objetivo(),
						HeuristicaProducto::heuristica,
						PDType.Max
						);

		// Proporciona un camino devuelto por PD desde el vértice inicial al objetivo:
		GraphPath<VerticeProducto, ActionSimpleEdge<VerticeProducto, Integer>> caminoPD = algoritmoPD.search().get();

		// Solución: lista de vértices recorridos del grafo:
		List<VerticeProducto> vertices = caminoPD.getVertexList();

		// DEBUG:
		System.out.println(vertices);

	}

}
