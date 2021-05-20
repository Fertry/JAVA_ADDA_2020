/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio2;

import java.util.List;

import org.jgrapht.GraphPath;

import aristas.AristaAbogado;
import heuristicas.HeuristicaAbogado;
import soluciones.Solucion2;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.DPR;
import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeAbogado;

/*
	Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
	casos relacionados entre s� (m>=n), y deben terminar dicho an�lisis global lo antes
	posible para lo que trabajar�n en paralelo. Cada caso ser� analizado por un �nico
	abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
	horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
	tiempo puede diferir para cada caso en funci�n de qu� abogado realice el an�lisis).
	Determine cu�l es la mejor asignaci�n de casos a abogados para conseguir el
	objetivo indicado (terminar de analizar todos los casos lo antes posible).
	
	Soluci�n por Programaci�n Din�mica.
*/

public class Ejercicio2PD {

	public static void EjecutaEjercicio2PD(String entrada) {

		// Inicializa las variables de la clase Ejercicio2:
		Ejercicio2.iniDatos(entrada);

		// Declarar v�rtice de inicio para el grafo:
		VerticeAbogado verticeInicial = VerticeAbogado.verticeInicial();

		// Inicializar el grafo virtual:
		/*
		 * 2 v�as: 
		 * 	� Con peso en el v�rtice. 
		 * 	� Con peso en las aristas.
		 */

		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del v�rtice inicial con peso:
		EGraph<VerticeAbogado, AristaAbogado> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de Programaci�n Din�mica:
		/*
		 * 2 v�as: 
		 * 	� Expresando el v�rtice final de destino. 
		 * 	� Mediante un predicado objetivo.
		 */
		DynamicProgrammingReduction<VerticeAbogado, AristaAbogado> algoritmoPD = DPR.dynamicProgrammingReductionGoal(
						grafoVirtual,
						VerticeAbogado.objetivo(),
						HeuristicaAbogado::heuristica,
						PDType.Min
						);

		// Proporciona un camino devuelto por PD desde el v�rtice inicial al objetivo:
		GraphPath<VerticeAbogado, AristaAbogado> caminoPD = algoritmoPD.search().get();

		// Soluci�n: lista de v�rtices recorridos del grafo:
		List<VerticeAbogado> vertices = caminoPD.getVertexList();
		System.out.println(vertices);
		Solucion2.solucionPD(vertices, entrada);

	}

}
