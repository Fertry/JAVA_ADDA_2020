/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package heuristicas;

import java.util.function.Predicate;

import ejercicio1.Ejercicio1;
import vertices.VerticeAlumno;

public class HeuristicaAlumno {
	
	/*
	 * Método heurístico de de mejora que proporciona una dirección de mejora para la solución buscada. 
	*/
	public static Double heuristic(VerticeAlumno v1, Predicate<VerticeAlumno> goal, VerticeAlumno v2) {
		Double res = 0.;
		Integer max = 0;
		for (int i = v1.indice; i < Ejercicio1.getNAlumnos(); i++) {
			for (int j = 0; j < Ejercicio1.getNGrupos(); j++) {
				if (v1.plazasRestantes.get(j) > 0) {
					if (Ejercicio1.getAfinidadPorIndice(i, j) > max) {
						max = Ejercicio1.getAfinidadPorIndice(i, j);
					}
				}
			}
			res += max;
			max = 0;
		}
		return res;
	}
	
}
