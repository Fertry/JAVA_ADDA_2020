/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package heuristicas;

import java.util.function.Predicate;

import ejercicio3.Ejercicio3;
import vertices.VerticeProducto;

public class HeuristicaProducto {
	
	/*
	 * Método heurístico de de mejora que proporciona una dirección de mejora para la solución buscada. 
	*/
	public static Double heuristica(VerticeProducto origen, Predicate<VerticeProducto> objetivo, VerticeProducto destino) {
		
		int i = 0;
		Double minimo = Ejercicio3.getPrecio(0);
		Double resultado = 0.0;
		
		// Si el conjunto contiene TODOS los requisitos:
		if (origen.getFuncionalidadesPorCubrir().containsAll(Ejercicio3.getRequisitos())) {
			
			resultado = 0.0;
			
		} else {
			
			// En caso contrario, mientras index<=i<n, obtener el minimo precio:
			while (origen.getIndice() <= i && i < Ejercicio3.getNProductos()) {
				
				Double precio = Ejercicio3.getPrecio(i);
				if (precio < minimo) {
				
					minimo = precio;
					
				}
				
				i++;
				
			}
			
		}
		
		return resultado;
		
	}

}
