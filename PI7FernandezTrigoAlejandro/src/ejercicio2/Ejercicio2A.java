/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio2;

import org.jgrapht.GraphPath;

import aristas.AristaAbogado;
import heuristicas.HeuristicaAbogado;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
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
	
	Soluci�n por A*.
*/

public class Ejercicio2A {
	
	public static void EjecutaEjercicio2A(String entrada) {
		
		// Inicializa las variables de la clase Ejercicio2:
		Ejercicio2.iniDatos(entrada);
		
		// Declarar v�rtices de inicio y de final para el grafo:
		VerticeAbogado verticeFinal = VerticeAbogado.verticeFinal();
		VerticeAbogado verticeInicial = VerticeAbogado.verticeInicial();
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del v�rtice inicial con peso:
		EGraph<VerticeAbogado, AristaAbogado> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de A*: 
		/*
		 * 2 v�as: 
		 *  � Expresando el v�rtice final de destino.
		 *  � ????
		 */
		AStar<VerticeAbogado, AristaAbogado> algoritmoA = GraphAlg.aStarEnd(grafoVirtual, verticeFinal, HeuristicaAbogado::heuristica);

		// Proporciona un camino devuelto por A* desde el v�rtice inicial al objetivo:
		GraphPath<VerticeAbogado, AristaAbogado> caminoA = algoritmoA.search().get();

	}
	
}
