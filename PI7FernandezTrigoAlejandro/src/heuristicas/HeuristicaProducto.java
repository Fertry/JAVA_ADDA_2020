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
		
		// Si fc=vacio -> 0, else, minimo(precio,index<=i<n):
		return origen.getFuncionalidadesPorCubrir().isEmpty() ? 0.0 : minimo(origen);
		
	}
	
	/*
	 * Método privado que devuelve el mínimo precio tal que index<=i<n: 
	*/
	private static Double minimo(VerticeProducto vertice) {
		
		int i = 0;
		Double minimo = Ejercicio3.getPrecio(0);
		
		// Mientras index<=i<n, obtener el minimo precio:
		while (vertice.getIndice() <= i && i < Ejercicio3.getNProductos()) {

			Double precio = Ejercicio3.getPrecio(i);
			if (precio < minimo) {

				minimo = precio;

			}

			i++;

		}
		
		return minimo;
		
	}

}
