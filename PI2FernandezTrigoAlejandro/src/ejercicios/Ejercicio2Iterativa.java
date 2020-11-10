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
		
	// Dado dos numeros a,b se calcula si a es múltiplo de b en base a las siguientes condiciones
	// Si a==0 --> true, si 0<a<b --> false y si a>=b --> a=a-b:
	public static boolean esMultiploIterativo(Integer numero1, Integer numero2) {
		
		boolean resultado = false;
	
		while (numero1 > 0) {
				
				numero1 = numero1 - numero2;
				if (numero1 == 0) {
					
					return true;
					
				} else if (numero1 < 0) {
					
					return false;
					
				}
				
			}

		return resultado;
		
	}
		
}
