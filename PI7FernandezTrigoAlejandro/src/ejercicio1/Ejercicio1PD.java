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
import soluciones.Solucion1;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.DPR;
import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
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
	
	Solución por Programación Dinámica.
*/

public class Ejercicio1PD {

	public static void EjecutaEjercicio1PD(String entrada) {
		
		// Inicializa las variables de la clase Ejercicio1:
		Ejercicio1.iniDatos(entrada);
		
		// Declarar vértice de inicio para el grafo:
		VerticeAlumno verticeInicial = VerticeAlumno.verticeInicial();
	
		// Inicializar el grafo virtual:
		/*
		 * 2 vías:
		 * 	· Con peso en el vértice.
		 * 	· Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeAlumno, AristaAlumno> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());	
		
		// Invocar el algoritmo de Programación Dinámica: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		*/
		DynamicProgrammingReduction<VerticeAlumno, AristaAlumno> algoritmoPD = DPR.dynamicProgrammingReductionGoal(
						grafoVirtual,
						VerticeAlumno.objetivo(),
						HeuristicaAlumno::heuristica,
						PDType.Max
						);
		
		// Proporciona un camino devuelto por PD desde el vértice inicial al objetivo:
		GraphPath<VerticeAlumno, AristaAlumno> caminoPD = algoritmoPD.search().get();
		
		// Solución: lista de vértices recorridos del grafo: 
		List<VerticeAlumno> vertices = caminoPD.getVertexList();
		Solucion1.solucionPD(vertices, entrada);
		
	}

}
