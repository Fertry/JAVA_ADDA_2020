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
	
	public static Double heuristica(VerticeProducto vertice) {
		
		// Si fc=vacio -> 0, else, minimo(precio,index<=i<n):
		return vertice.getFuncionalidadesPorCubrir().isEmpty() ? 0.0 : minimo(vertice);
		
	}
	
	/*
	 * Método público para Backtracking manual (hace uso de la heurística de forma estática):
	 * (Calcula primero el vecino del vertice de entrada en base a la acción)
	*/
	public static Double cota(VerticeProducto vertice, Integer accion) {
		
		Double resultado = 0.0;
		VerticeProducto vecino = vertice.neighbor(accion);
		
		resultado = (accion * Ejercicio3.getPrecio(vertice.getIndice())) + heuristica(vecino); 
		
		return resultado;
		
	}
	
	/*
	 * Método privado que devuelve el mínimo precio tal que index<=i<n: 
	*/
	private static Double minimo(VerticeProducto vertice) {
		
		int i = 0;
		Double minimo = Ejercicio3.getPrecio(0);
		
		// Mientras index<=i<n, obtener el minimo precio:
		while (i < Ejercicio3.getNProductos()) {

			Double precio = Ejercicio3.getPrecio(i);
			if (precio < minimo) {

				minimo = precio;

			}

			i++;

		}
		
		return minimo;
		
	}

}
