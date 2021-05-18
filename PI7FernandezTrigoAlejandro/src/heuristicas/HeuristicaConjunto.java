/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package heuristicas;

import java.util.function.Predicate;

import vertices.VerticeConjunto;

public class HeuristicaConjunto {
	
	/*
	 * Método heurístico de de mejora que proporciona una dirección de mejora para la solución buscada. 
	*/
	public static Double heuristica(VerticeConjunto origen, Predicate<VerticeConjunto> objetivo, VerticeConjunto destino) {
		
		// Si vr[0]==0 -> 0, else 1:
		return (double) (origen.getConjunto().get(0) == 0 ? 0 : 1);
				
	}

}
