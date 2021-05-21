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
import us.lsi.graphs.alg.DPR;
import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import vertices.VerticeConjunto;

/*
	Dado un conjunto de enteros determinar si puede particionarse en tres
	subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
	misma, y que el tama�o de uno de ellos sea lo menor posible.
	
	Soluci�n por Programaci�n Din�mica.
*/

public class Ejercicio4PD {

	public static void EjecutaEjercicio4PD(String entrada) {
		
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
			EjecutaProblemaEjercicio4PD(entrada, linea);
			linea++;
			
		}
	
	}
	
	/*
	 * Este m�todo privado se encarga de ejecutar el algoritmo para UNA l�nea de fichero espec�fica, es
	 * decir, un problema espec�fico extraido del fichero de entrada.
	*/
	private static void EjecutaProblemaEjercicio4PD(String entrada, Integer linea) {
		
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
		
		// Invocar el algoritmo de Programaci�n Din�mica: 
		/*
		 * 2 v�as: 
		 *  � Expresando el v�rtice final de destino.
		 *  � Mediante un predicado objetivo.
		*/
		DynamicProgrammingReduction<VerticeConjunto, AristaConjunto> algoritmoPD = DPR.dynamicProgrammingReductionGoal(
						grafoVirtual,
						VerticeConjunto.objetivo(),
						HeuristicaConjunto::heuristica,
						PDType.Min
						);
		
		// Proporciona un camino devuelto por PD desde el v�rtice inicial al objetivo:
		GraphPath<VerticeConjunto, AristaConjunto> caminoPD = algoritmoPD.search().get();
		
		// Soluci�n: lista de aristas recorridos del grafo: 
		List<AristaConjunto> aristas = caminoPD.getEdgeList();
		System.out.println("$$$$$$$$$$$$$$$$$ PROGRAMACI�N DIN�MICA $$$$$$$$$$$$$$$$$$");
		System.out.println(aristas);
		Solucion4.solucion(aristas);
		
		// DEBUG:
		/*
		 * List<VerticeConjunto> vertices = caminoPD.getVertexList();
		 * System.out.println(vertices);
		*/
	
	}
	
}
