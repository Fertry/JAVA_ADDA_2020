/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package heuristicas;

import java.util.function.Predicate;

import ejercicio1.Ejercicio1;
import vertices.VerticeAlumno;

public class HeuristicaAlumno {
	
	/*
	 * M�todo heur�stico de mejora/optmizaci�n optimista que proporciona una direcci�n de mejora para la soluci�n buscada. 
	 * sum(max(af(i,j)|pl[j]>0)) d�nde i:index..n-1, j:0..m-1
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
					
					// Obtener la mayor afinidad para dicho �ndice alumno i:
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
		
		// A* siempre minimiza as� que niego el valor de la heur�stica:
		return -resultado;
		
	}
	
}
