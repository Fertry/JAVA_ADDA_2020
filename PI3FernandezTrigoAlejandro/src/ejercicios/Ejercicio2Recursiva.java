/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2Recursiva {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 2 				 #################
	// ###################################################################################
	// ###################################################################################

	// Funcion que dado una lista de numeros localiza la sublista cuya suma de adyacentes 
	// es mayor usando divide y vencerás para obtener una solucion con complejidad ??????
	// y que se realiza llamando a la funcion privada ejercicio1RecursivoPrivado para
	// actuar de forma opaca hacia el usuario: 
	public static List<Integer> ejercicio1Recursivo(List<Integer> lista) {
		
		Integer i = 0;
		Integer j = lista.size();
		
		return ejercicio1RecursivoPrivado(i, j, lista);
		
	}
	
	// Funcion privada que emplea el algoritmo de divide y venceras sobre la lista de entrada
	// para ser llamada por la funcion publica del ejercicio:
	/*
	 * Recursividad: ????????????????????????
	 * Complejidad: ????????????????????????
	 */
	private static List<Integer> ejercicio1RecursivoPrivado(int i, int j, List<Integer> lista) {
		
		Integer k = 0;
		List<Integer> resultado = new ArrayList<Integer>();
		
		if (j - i > 0 && resultado.isEmpty()) {
			
			// Posición: la mitad
			k = ((i + j) / 2);
			if (lista.get(k)) {
				
				//i = k + 1;
				return hastaDondeSonIgualesRecursivoInterno((k + 1), j, frase1, frase2);
				
			} else {
				
				// Hacia la izquierda
				if (frase1.charAt(k - 1) == frase2.charAt(k - 1)) {
					
					resultado = k;
					
				} else {
					
					//j = k;
					return hastaDondeSonIgualesRecursivoInterno(i, k, frase1, frase2);
					
				}
				
			}
			
		} else {
			
			return resultado;
			
		}
		
		return resultado;
		
	}
	
}
