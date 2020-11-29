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
	public static List<Integer> ejercicio1Recursivo(List<Integer> lista) {
		
		Integer i = 0;
		Integer j = 0;
		
		return ejercicio1RecursivoPrivado(i, j, lista);
		
	}
	
	//
	private static List<Integer> ejercicio1RecursivoPrivado(int i, int j, List<Integer> lista) {
		
		Integer k = 0;
		List<Integer> resultado = new ArrayList<Integer>();
		
		if (j - i > 0 && resultado.isEmpty()) {
			
			// Posición: la mitad
			k = ((i + j) / 2);
			if (frase1.charAt(k) == frase2.charAt(k)) {
				
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
