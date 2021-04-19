/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.ValuesInRangeChromosome;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;

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
	public static Graph<Ciudad, Carretera> grafo;
	
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
	 * Predicados que se aplican al ejercicio: 
	 * 1. Carreteras de m�s de 100 kms
	 * 2. Carreteras de m�s de 200 kms
	*/
	Predicate<Circuito> predicado100 = new Predicate<Circuito>() {

		@Override
		public boolean test(Circuito circuito) {

			return false;
			
		}
		
	};
	
	Predicate<Circuito> predicado200 = new Predicate<Circuito>() {

		@Override
		public boolean test(Circuito circuito) {
			
			return false;
			
		}
		
	};
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro. Se acceder� a los datos desde la clase AG que resuelve el ejercicio.
	*/
	private static void iniDatos(String fichero) {

		// Inicializar las variables de la clase Ejercicio5:
		grafo = new SimpleWeightedGraph<>(null,null);
		
		// Creo un objeto de tipo Circuito del cual extraer sus propiedades:
		Circuito circuito = Circuito.ofFichero(fichero);

		grafo = circuito.getGrafo();
		
	}

	
	/*
	 * M�todos auxiliares para definir las restricciones del problema y m�todos para ser usados
	 * por el algoritmo de resoluci�n. Son invocados en la clase AG5. 
	*/	
	
	// Define el tipo de cromosoma que usa el problema:
	@Override
	public ChromosomeType getType() {

		return ChromosomeType.Range;
		
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
				
		// Soluci�n por Algoritmos Gen�ticos - Cromosoma de ... :
		try {

			AG5.ejercicio5AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Algoritmos Gen�ticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

	}

}
