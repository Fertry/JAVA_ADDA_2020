/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio1;

import java.util.List;
import org.jgrapht.GraphPath;

import aristas.AristaAlumno;
import heuristicas.HeuristicaAlumno;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
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
		VerticeAlumno verticeFinal = VerticeAlumno.lastVertex();
		VerticeAlumno verticeInicial = VerticeAlumno.initialVertex();
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial:
		EGraph<VerticeAlumno, AristaAlumno> grafo = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());
		
		// Invoca al algoritmo A* con el grafo virtual, su destino y la heurística encargada de mejorar la solución:
		AStar<VerticeAlumno, AristaAlumno> recorrido = GraphAlg.aStarEnd(grafo, verticeFinal, HeuristicaAlumno::heuristica);
		
		// DEBUG!!!
		System.out.println(verticeFinal);
		System.out.println(verticeInicial);
		System.out.println(grafo.vertexSet());
		System.out.println(recorrido);
		System.out.println("Grupos (nº afinidades): " + Ejercicio1.getNGrupos());
		System.out.println("Alumnos: " + Ejercicio1.getNAlumnos());
		System.out.println("Reparto: " + Ejercicio1.getReparto());
		System.out.println("Indice " + VerticeAlumno.initialVertex());
		System.out.println("Indice " + VerticeAlumno.lastVertex());
		 
		GraphPath<VerticeAlumno, AristaAlumno> camino = recorrido.search().get();
	//	List<AristaAlumno> edges = camino.getEdgeList();
	//	System.out.println(edges);
		
	}
	
}
