/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
 */

package ejercicio1;

import org.jgrapht.GraphPath;

import aristas.AristaAlumno;
import heuristicas.HeuristicaAlumno;
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
		
		System.out.println(entrada);		
		
		// Declarar vértices de inicio y de final para el grafo:
		VerticeAlumno verticeFinal = VerticeAlumno.verticeFinal();
		VerticeAlumno verticeInicial = VerticeAlumno.verticeInicial();
		
		System.out.println(verticeFinal);
		System.out.println(verticeInicial);
		
		EGraph<VerticeAlumno, AristaAlumno> grafo = Graphs2.simpleVirtualGraph(verticeInicial,x->x.getEdgeWeight());	
				
		DynamicProgrammingReduction<VerticeAlumno, AristaAlumno> algoritmoPD = 
				DPR.dynamicProgrammingReductionEnd(grafo,
						verticeFinal,
						HeuristicaAlumno::heuristica,
						PDType.Max);
				
		System.out.println(algoritmoPD.search());
		System.out.println(algoritmoPD.solutionsTree);
		
		GraphPath<VerticeAlumno, AristaAlumno> solucion = algoritmoPD.search().get();
		System.out.println(solucion);
		
	}

}
