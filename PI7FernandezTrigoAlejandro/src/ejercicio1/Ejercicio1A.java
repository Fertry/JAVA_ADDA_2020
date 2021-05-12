/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
	Una academia de ingl�s tiene n alumnos a ser repartidos en m grupos (n m�ltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo n�mero de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no est�
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Soluci�n por A*.
*/

public class Ejercicio1A {
	
	public static void EjecutaEjercicio1A(String entrada) {

		// Inicializa las variables de la clase Ejercicio1:
		Ejercicio1.iniDatos(entrada);
		
		// Declarar v�rtices de inicio y de final para el grafo:
		VerticeAlumno verticeFinal = VerticeAlumno.verticeFinal();
		VerticeAlumno verticeInicial = VerticeAlumno.verticeInicial();
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del v�rtice inicial con peso:
		EGraph<VerticeAlumno, AristaAlumno> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());

		// Invocar el algoritmo de A*: 
		/*
		 * 2 v�as: 
		 *  � Expresando el v�rtice final de destino.
		 *  � ????
		 */
		AStar<VerticeAlumno, AristaAlumno> algoritmoA = GraphAlg.aStarEnd(grafoVirtual, verticeFinal, HeuristicaAlumno::heuristica);

		// Proporciona un camino devuelto por A* desde el v�rtice inicial al objetivo:
		GraphPath<VerticeAlumno, AristaAlumno> caminoA = algoritmoA.search().get();
		
		// DEBUG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		List<AristaAlumno> aristas = caminoA.getEdgeList();
		System.out.println(aristas);
		System.out.println(verticeFinal);
		System.out.println(verticeInicial);
		System.out.println(grafoVirtual.vertexSet());
		System.out.println(caminoA);
		System.out.println("Grupos (n� afinidades): " + Ejercicio1.getNGrupos());
		System.out.println("Alumnos: " + Ejercicio1.getNAlumnos());
		System.out.println("Reparto: " + Ejercicio1.getNAlumnos() / Ejercicio1.getNGrupos());

	}
	
}
