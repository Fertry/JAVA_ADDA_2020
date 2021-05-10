/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio1;

import java.util.function.BiFunction;

import aristas.AristaAlumno;
import heuristicas.HeuristicaAlumno;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.AStar;
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
		
		
		//Grafo virtual. Aristas -> Alternativas y su peso
//		AStar<VerticeAlumno, AristaAlumno> graph = Graphs2.simpleVirtualGraph(null);
		
		//Algoritmo A*
//		BiFunction<VerticeAlumno, VerticeAlumno, Double> heuristic = (v1,v2)->-HeuristicaAlumno.heuristica(v1,v2);
//		AStar<VerticeAlumno, AristaAlumno> a = AStar.of(graph,e0,e1,heuristic);
		
		//Solucion
//		SolucionEstanteria s = SolucionEstanteria.empty();
//		a.getPathEdgeList().stream().forEach(e -> s.add(DatosEstanteria.getLibros().get(e.getSource().getIndex()) ,e.a.intValue()));
//		System.out.println(s);
		
//		List<EstanteriaEdge> edges = a.getPathEdgeList();
//		System.out.println(edges);
		
		
	}
	
}
