/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.io.IOException;
import java.util.List;

import org.jgrapht.Graph;

import ejercicio3.Ejercicio3AG;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.ValuesInRangeChromosome;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Style;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

/*
	Se tiene un grafo cuyos v�rtices son Ciudades y sus Aristas son Carreteras, y un
	predicado sobre carreteras. Se desea saber cu�l es el camino cerrado m�s corto
	que pase por todos los v�rtices del grafo una sola vez y que contiene al menos una
	arista que cumple el predicado.
	
	Se pide solucionar por Algoritmos Gen�ticos
*/

public class Ejercicio5 implements ValuesInRangeProblemAG<Integer, List<Integer>> {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * AG que resuelve el ejercicio. 
	*/
	
	/*
	 * M�todos inicializadores de la clase AG.
	*/
	public Ejercicio5(String fichero) {
		
		Ejercicio5.iniDatos(fichero);
		
	}
	
	public static Ejercicio5 AG(String fichero) {
		
		return new Ejercicio5(fichero);
		
	}
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde la clase AG que resuelve el ejercicio.
	*/
	
	/*
	 * Lectura de datos; devuelve un grafo de tipo <Ciudad, Carretera> siendo estos
	 * clases definidas para nodos/v�rtices (ciudades) y aristas (carreteras).
	*/
	private static Graph<Ciudad, Carretera> lecturaDatosEjercicio5(String fichero) {

		// Se emplea el m�todo GraphsReader con las clases predefinidas Ciudad y Carreta de la librer�a
		// para definir un grafo ponderado a partir del fichero de entrada:
		Graph<Ciudad, Carretera> grafo = GraphsReader.newGraph(
				fichero,
				Ciudad::ofFormat,
				Carretera::ofFormat,
				Graphs2::simpleWeightedGraph,
				Carretera::getKm);

		return grafo;

	}
	
	/*
	 * M�todo privado para volcar los datos del grafo en un fichero de extensi�n .gv para ser mostrado por pantalla.
	*/
	private static void salidaGrafo(Graph<Ciudad, Carretera> grafo) {

		Graphs2.toDot(
				grafo, 																			// Grafo de entrada
				"salida/salidaEjercicio5.gv",													// Ruta de salida de fichero
				v -> v.getNombre(),															    // Valor de v�rtices
				e -> e.getKm().toString(),														// Valor de las aristas
				v -> GraphColors.getColor(GraphColors.Color.green),								// Coloreado
				e -> GraphColors.getStyle(Style.bold));											// Define el estilo del grafo
		
	}
	
	/*
	 * M�todos auxiliares para definir las restricciones del problema y m�todos para ser usados
	 * por el algoritmo de resoluci�n. Son invocados en la clase AG5. 
	*/	

	// Define el tipo de cromosoma que usa el problema:
	@Override
	public ChromosomeType getType() {

		return null;
		
	}

	// Define el n� de elementos del problema: N� de ...:
	@Override
	public Integer getCellsNumber() {

		return null;
		
	}

	// Define el l�mite superior del problema: N� de ...:
	public Integer getMax(Integer i) {

		return null;
		
	}

	// Devuelve el l�mite inferior del problema: siempre 0:
	public Integer getMin(Integer i) {

		return 0;
		
	}

	/*
	 * M�todos de Algoritmos Gen�ticos para determinar la recompensa / penalizaci�n del cromosoma
	 * seleccionado.
	*/
	
	// Funci�n de fitness que define el problema:
	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cromosoma) {

		List<Integer> cromosomas = cromosoma.decode();

		return recompensa(cromosomas) - penalizacion(cromosomas);

	}

	// Funci�n decode:
	@Override
	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> cromosoma) {

		return cromosoma.decode();

	}

	/*
	 * M�todo objetivo o recompensa para recompensar cromosomas que cumplan las
	 * restricciones.
	 */
	public Double recompensa(List<Integer> cromosomas) {

		return null;

	}

	/*
	 * M�todo de "castigo" o penalizaci�n para cromosomas que no cumplen las
	 * restricciones.
	 */
	public Double penalizacion(List<Integer> cromosomas) {

		return null;

	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio5(String fichero) {
		
		// Lectura de datos de entrada:
		Graph<Ciudad, Carretera> grafo = lecturaDatosEjercicio5(fichero);
		
		// Soluci�n por Programaci�n Lineal:
		try {

			AG5.ejercicio5AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Algoritmos Gen�ticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

	}

}
