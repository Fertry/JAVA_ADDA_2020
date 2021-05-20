/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
import us.lsi.graphs.alg.DPR;
import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeProducto;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener m�s de una funcionalidad). Se
	desea dise�ar un lote con una selecci�n de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Soluci�n por Programaci�n Din�mica.
*/

public class Ejercicio3PD {

	public static void EjecutaEjercicio3PD(String entrada) {

		// Inicializa las variables de la clase Ejercicio3:
		Ejercicio3.iniDatos(entrada);

		// Declarar v�rtice de inicio para el grafo:
		VerticeProducto verticeInicial = VerticeProducto.verticeInicial();

		// Inicializar el grafo virtual:
		/*
		 * 2 v�as: 
		 * 	� Con peso en el v�rtice. 
		 * 	� Con peso en las aristas.
		 */

		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del v�rtice inicial con peso:
		EGraph<VerticeProducto, AristaProducto> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de Programaci�n Din�mica:
		/*
		 * 2 v�as: 
		 * 	� Expresando el v�rtice final de destino. 
		 * 	� Mediante un predicado objetivo.
		 */
		DynamicProgrammingReduction<VerticeProducto, AristaProducto> algoritmoPD = DPR.dynamicProgrammingReductionGoal(
						grafoVirtual,
						VerticeProducto.objetivo(),
						HeuristicaProducto::heuristica,
						PDType.Max
						);

		// Proporciona un camino devuelto por PD desde el v�rtice inicial al objetivo:
		GraphPath<VerticeProducto, AristaProducto> caminoPD = algoritmoPD.search().get();

		// Soluci�n: lista de aristas recorridos del grafo:
		List<AristaProducto> aristas = caminoPD.getEdgeList();
		System.out.println("$$$$$$$$$$$$$$$$$ PROGRAMACI�N DIN�MICA $$$$$$$$$$$$$$$$$$");
		System.out.println(aristas);
		//Solucion3.solucion(aristas, entrada);

		// DEBUG:
		/*
		 * List<VerticeProducto> vertices = caminoPD.getVertexList();
		 * System.out.println(vertices);
		*/

	}

}
