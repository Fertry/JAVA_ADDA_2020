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
	 * Método heurístico de mejora/optmización optimista que proporciona una dirección de mejora para la solución buscada. 
	 * sum(max(af(i,j)|pl[j]>0)) dónde i:index..n-1, j:0..m-1
	*/
	public static Double heuristica(VerticeAlumno origen, Predicate<VerticeAlumno> objetivo, VerticeAlumno destino) {
		
		int j = 0;
		Integer maximo = 0;
		Integer afinidad = 0;
		Double resultado = 0.0;
		int i = origen.getIndice();

		while (i < Ejercicio1.getNAlumnos()) {
			while (j < Ejercicio1.getNGrupos()) {
				
				// SI hay plazas restantes para dicho grupo j:
				if (origen.getPlazasRestantes().get(j) > 0) {
					
					// Obtener la mayor afinidad para dicho índice alumno i:
					afinidad = Ejercicio1.getAfinidadPorIndice(i, j);
					if (afinidad > maximo) {
						
						maximo = afinidad;
						
					}
					
				}
				
				j++;
				
			}
			
			// Sumar el valor obtenido y resetear el maximo encontrado:
			resultado += maximo;
			maximo = 0;
			i++;
			
		}
		
		// A* siempre minimiza así que niego el valor de la heurística:
		return -resultado;
		
	}
	
}
