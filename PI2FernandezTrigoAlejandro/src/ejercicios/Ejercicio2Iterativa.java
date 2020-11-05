/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio2Iterativa {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 2 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################
		
	//
	public static boolean esMultiploIterativo(Integer a, Integer b) {
		
		boolean resultado = true;
			
		if (a == 0) {
				
			return true;
				
		} else if (a > 0 && b > a) {
				
			return false;
				
		} else if (a >= b) {
				
			while (a >= b) {
					
				a = a - b;
				
				if (a == 0) {
						
					return true;
						
				} else if (a > 0 && b > a) {
						
					return false;
						
				}
					
			}
				
		}

		return resultado;
		
	}

}
