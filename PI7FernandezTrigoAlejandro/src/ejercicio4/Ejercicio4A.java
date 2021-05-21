/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeConjunto;

public class Ejercicio4A {
	
	public static void EjecutaEjercicio4A(String entrada) {

		/*
		 * La entrada del ejercicio 4 NO representa un �nico problema sino varios problemas
		 * cada uno en una l�nea de fichero. Para ejecutarlos todos de forma sistem�tica 
		 * creo un bucle que ejecute el ejercicio tantas veces c�mo l�neas de fichero. 
		*/
	
		Integer linea = 0;
		Integer lineas = Files2.linesFromFile(entrada).size();
		
		while (linea < lineas) {
			
			System.out.println("Linea de fichero: " + linea);
			System.out.println("Conjunto de entrada: " + Files2.linesFromFile(entrada).get(linea) + "\n");
			EjecutaProblemaEjercicio4A(entrada, linea);
			linea++;
			
		}
	
	}
	
	/*
	 * Este m�todo privado se encarga de ejecutar el algoritmo para UNA l�nea de fichero espec�fica, es
	 * decir, un problema espec�fico extraido del fichero de entrada.
	*/
	private static void EjecutaProblemaEjercicio4A(String entrada, Integer linea) {
		
		// Inicializa las variables de la clase Ejercicio4 para la l�nea de fichero proporcionado:
		Ejercicio4.iniDatos(entrada, linea);
		
		// Declarar v�rtice de inicio para el grafo:
		VerticeConjunto verticeInicial = VerticeConjunto.verticeInicial();
		
		// Inicializar el grafo virtual:
		/*
		 * 2 v�as:
		 * 	� Con peso en el v�rtice.
		 * 	� Con peso en las aristas. 
		*/ 
		
		// Inicializa un grafo virtual de tipo simpleVirtualGraph a partir del v�rtice inicial con peso:
		EGraph<VerticeConjunto, AristaConjunto> grafoVirtual = Graphs2.simpleVirtualGraph(verticeInicial, x -> x.getEdgeWeight()); 
		
		// Invocar el algoritmo de A*: 
		/*
		 * 2 v�as: 
		 *  � Expresando el v�rtice final de destino.
		 *  � Mediante un predicado objetivo.
		*/
		AStar<VerticeConjunto, AristaConjunto> algoritmoA = GraphAlg.aStarGoal(
				grafoVirtual,
				VerticeConjunto.objetivo(),
				HeuristicaConjunto::heuristica
				);

		// Proporciona un camino devuelto por A* desde el v�rtice inicial al objetivo:
		GraphPath<VerticeConjunto, AristaConjunto> caminoA = algoritmoA.search().get();
		
		// Soluci�n: lista de aristas recorridos del grafo: 
		List<AristaConjunto> aristas = caminoA.getEdgeList();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ A ESTRELLA $$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(aristas);
		Solucion4.solucion(aristas);
		
		// DEBUG:
		/*
		 * List<VerticeConjunto> vertices = caminoA.getVertexList();
		 * System.out.println(vertices);
		*/
		
	}

}
