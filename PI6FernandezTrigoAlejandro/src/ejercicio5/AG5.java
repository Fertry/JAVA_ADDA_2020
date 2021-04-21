/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import us.lsi.ag.SeqNormalProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agchromosomes.ChromosomeFactory.CrossoverType;
import us.lsi.ag.agchromosomes.SeqNomalChromosome;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.grafos.datos.Carretera;

//Algoritmos Genéticos - Cromosoma de permutación
public class AG5 {
	
	/*
	 * Resolvedor de Algoritmos Genéticos: Se reciben los datos del fichero de entrada .txt y se 
	 * inicializan los datos en la clase Ejercicio5 donde se crea un objeto al cual se aplica el 
	 * algoritmo y devuelve la mejor solución que se pasa a la clase solución.
	*/
	public static void ejercicio5AG(String fichero) throws IOException {
		
		/*
		 * Parámetros configurables de algoritmos genéticos.
		*/
		AlgoritmoAG.ELITISM_RATE = 0.30;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 500;
		StoppingConditionFactory.NUM_GENERATIONS = 400;
		ChromosomeFactory.crossoverType = CrossoverType.OnePoint;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.GenerationCount;

		// Inicializa el objeto AG en la clase Ejercicio5:
		SeqNormalProblemAG<List<Integer>> objetoAG = Ejercicio5.AG(fichero);
		System.out.println(Ejercicio5.carreteras);
		System.out.println(Ejercicio5.ciudades);
		AlgoritmoAG<SeqNomalChromosome> cromosomas = AlgoritmoAG.create(objetoAG);

		// Ejecuta el algoritmo de Algoritmos Genéticos:
		cromosomas.ejecuta();

		// Solución del problema:
		// List<Integer> solucion = objetoAG.getSolucion(cromosomas.getBestChromosome());
		SeqNomalChromosome solucion = cromosomas.getBestChromosome();

		// Vuelca la salida "sin formatear" por consola:
		System.out.println(solucion);

		// En su lugar, llamo a la clase Solucion5 para formatear la salida:
		// Solucion5.solucionAG5(fichero, solucion);
		
	}

}
