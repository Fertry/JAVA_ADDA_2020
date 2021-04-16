/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.io.IOException;
import java.util.List;

import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ValuesInRangeChromosome;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

//Algoritmos Genéticos - Cromosoma de rango
public class AG2 {
	
	/*
	 * Resolvedor de Algoritmos Genéticos: Se reciben los datos del fichero de entrada .txt y se 
	 * inicializan los datos en la clase Ejercicio2AG donde se crea un objeto al cual se aplica el 
	 * algoritmo y devuelve la mejor solución que se pasa a la clase solución.
	 */
	public static void ejercicio2AG(String fichero) throws IOException {

		/*
		 * Parámetros configurables de algoritmos genéticos.
		*/
		AlgoritmoAG.ELITISM_RATE = 0.30;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 1000;
		StoppingConditionFactory.NUM_GENERATIONS = 400;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.GenerationCount;

		// Inicializa el objeto AG en la clase Ejercicio2AG:
		ValuesInRangeProblemAG<Integer, List<Integer>> objetoAG = Ejercicio2AG.AG(fichero);
		AlgoritmoAG<ValuesInRangeChromosome<Integer>> cromosomas = AlgoritmoAG.create(objetoAG);

		// Ejecuta el algoritmo de Algoritmos Genéticos:
		cromosomas.ejecuta();

		// Solución del problema:
		List<Integer> solucion = objetoAG.getSolucion(cromosomas.getBestChromosome());

		// Vuelca la salida "sin formatear" por consola:
		System.out.println(solucion);

		// En su lugar, llamo a la clase Solucion2 para formatear la salida:
		//Solucion2.solucionAG2(fichero, solucion);

	}
	
}
