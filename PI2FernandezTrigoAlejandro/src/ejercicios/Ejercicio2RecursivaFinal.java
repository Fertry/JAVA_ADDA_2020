/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */


package ejercicios;

public class Ejercicio2RecursivaFinal {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 2 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################
		
	//
	public static boolean esMultiploRecursivoFinal(Integer a, Integer b) {
		
		if (a == 0) {
			
			return true;
			
		} else if (a > 0 && b > a) {
			
			return false;
			
		} else if (a >= b) {
			
			return esMultiploRecursivoFinal(a - b, b);
			
		}
		
		return false;
		
	}
		
}
