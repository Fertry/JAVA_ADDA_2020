/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio4;

import java.util.List;

import org.jgrapht.GraphPath;

import aristas.AristaConjunto;
import heuristicas.HeuristicaConjunto;
import soluciones.Solucion4;
import us.lsi.common.Files2;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.DPR;
import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeConjunto;

/*
	Dado un conjunto de enteros determinar si puede particionarse en tres
	subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
	misma, y que el tamaño de uno de ellos sea lo menor posible.
	
	Solución por Programación Dinámica.
*/

public class Ejercicio4PD {

	public static void EjecutaEjercicio4PD(String entrada) {
		
		/*
		 * La entrada del ejercicio 4 NO representa un único problema sino varios problemas
		 * cada uno en una línea de fichero. Para ejecutarlos todos de forma sistemática 
		 * creo un bucle que ejecute el ejercicio tantas veces cómo líneas de fichero. 
		*/
	
		Integer linea = 0;
		Integer lineas = Files2.linesFromFile(entrada).size();
		
		while (linea < lineas) {
			
			System.out.println("Linea de fichero: " + linea);
			System.out.println("Conjunto de entrada: " + Files2.linesFromFile(entrada).get(linea) + "\n");
			EjecutaProblemaEjercicio4PD(entrada, linea);
			linea++;
			
		}
	
	}
	
	/*
	 * Este método privado se encarga de ejecutar el algoritmo para UNA línea de fichero específica, es
	 * decir, un problema específico extraido del fichero de entrada.
	*/
	private static void EjecutaProblemaEjercicio4PD(String entrada, Integer linea) {
		
		// Inicializa las variables de la clase Ejercicio4 para la línea de fichero proporcionado:
		Ejercicio4.iniDatos(entrada, linea);
		
		// Declarar vértice de inicio para el grafo:
		VerticeConjunto verticeInicial = VerticeConjunto.verticeInicial();
	
		// Inicializar el grafo virtual:
		/*
		 * 2 vías:
		 * 	· Con peso en el vértice.
		 * 	· Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del vértice inicial con peso:
		EGraph<VerticeConjunto, AristaConjunto> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight());	
		
		// Invocar el algoritmo de Programación Dinámica: 
		/*
		 * 2 vías: 
		 *  · Expresando el vértice final de destino.
		 *  · Mediante un predicado objetivo.
		*/
		DynamicProgrammingReduction<VerticeConjunto, AristaConjunto> algoritmoPD = DPR.dynamicProgrammingReductionGoal(
						grafoVirtual,
						VerticeConjunto.objetivo(),
						HeuristicaConjunto::heuristica,
						PDType.Min
						);
		
		// Proporciona un camino devuelto por PD desde el vértice inicial al objetivo:
		GraphPath<VerticeConjunto, AristaConjunto> caminoPD = algoritmoPD.search().get();
		
		// Solución: lista de aristas recorridos del grafo: 
		List<AristaConjunto> aristas = caminoPD.getEdgeList();
		System.out.println("$$$$$$$$$$$$$$$$$ PROGRAMACIÓN DINÁMICA $$$$$$$$$$$$$$$$$$");
		System.out.println(aristas);
		Solucion4.solucion(aristas);
		
		// DEBUG:
		/*
		 * List<VerticeConjunto> vertices = caminoPD.getVertexList();
		 * System.out.println(vertices);
		*/
	
	}
	
}
