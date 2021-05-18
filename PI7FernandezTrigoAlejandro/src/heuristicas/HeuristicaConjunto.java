/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package heuristicas;

import java.util.function.Predicate;

import vertices.VerticeConjunto;

public class HeuristicaConjunto {
	
	/*
	 * M�todo heur�stico de de mejora que proporciona una direcci�n de mejora para la soluci�n buscada. 
	*/
	public static Double heuristica(VerticeConjunto origen, Predicate<VerticeConjunto> objetivo, VerticeConjunto destino) {
		
		// Si vr[0]==0 -> 0, else 1:
		return (double) (origen.getConjunto().get(0) == 0 ? 0 : 1);
				
	}

}
