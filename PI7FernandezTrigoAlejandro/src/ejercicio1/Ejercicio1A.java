/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio1;

import java.util.List;
import org.jgrapht.GraphPath;

import heuristicas.HeuristicaAlumno;
import soluciones.Solucion1;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.ActionSimpleEdge;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeAlumno;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Solución por A*.
*/

public class Ejercicio1A {
	
	public static void EjecutaEjercicio1A(String entrada) {

		// Inicializa las variables de la clase Ejercicio1:
		Ejercicio1.iniDatos(entrada);
		
		// Declarar vértices de inicio y de final para el grafo:
		// VerticeAlumno verticeFinal = VerticeAlumno.verticeFinal();
		VerticeAlumno verticeInicial = VerticeAlumno.verticeInicial();
		
		// Inicializar el grafo virtual:
		/*
		 * 2 vías:
		 * 	· Con peso en el vértice.
		 * 	· Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		// Arista extiende a ActionSimpleEdge
		EGraph<VerticeAlumno, ActionSimpleEdge<VerticeAlumno, Integer>> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight()); 
		//EGraph<VerticeAlumno, ActionSimpleEdge<VerticeAlumno, Integer>> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getPeso()); 
		
		// Invocar el algoritmo de A*: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		*/
		AStar<VerticeAlumno, ActionSimpleEdge<VerticeAlumno, Integer>> algoritmoA = GraphAlg.aStarGoal(
				grafoVirtual,
				VerticeAlumno.objetivo(),
				HeuristicaAlumno::heuristica
				);

		// Proporciona un camino devuelto por A* desde el vértice inicial al objetivo:
		GraphPath<VerticeAlumno, ActionSimpleEdge<VerticeAlumno, Integer>> caminoA = algoritmoA.search().get();
		
		// Solución: lista de vértices recorridos del grafo: 
		List<VerticeAlumno> vertices = caminoA.getVertexList();
		Solucion1.solucionA(vertices, entrada);
		
	}
	
}
