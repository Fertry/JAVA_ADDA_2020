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
		
		// Inicializar las variables de la clase Ejercicio1 que son los datos del problema:
		Ejercicio1.iniDatos(entrada);
		
		// DEBUG: Mostrar los datos de entrada:
		System.out.println("Alumnos: " + Ejercicio1.getNAlumnos());
		System.out.println("Afinidades (grupos): " +  Ejercicio1.getNGrupos());
		System.out.println("Reparto (alumnos/grupos): " + Ejercicio1.getReparto());
		 
		// Vertice inicial y final 
		VerticeAlumno verticeInicial = VerticeAlumno.of();
		VerticeAlumno verticeFinal = VerticeAlumno.lastVertex();
		
		System.out.println(verticeInicial);
		System.out.println(verticeFinal);
		
		EGraph<VerticeAlumno, AristaAlumno> graph = Graphs2.simpleVirtualGraph(verticeInicial,x->-x.getEdgeWeight());	
		System.out.println(graph.vertexSet());
	
		AStar<VerticeAlumno, AristaAlumno> ms = GraphAlg.aStarEnd(graph,verticeFinal,HeuristicaAlumno::heuristic_negate);
		
		GraphPath<VerticeAlumno,AristaAlumno> path = ms.search().get();
		List<AristaAlumno> edges = path.getEdgeList();
		System.out.println(edges);
		
	}
	
}
