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
	public static boolean esMultiploIterativo(Integer a, Integer b) {
		
		boolean resultado = false;
	
		while (a > 0) {
				
				a = a - b;
				if (a == 0) {
					
					return true;
					
				} else if (a < 0) {
					
					return false;
					
				}
				
			}

		return resultado;
		
	}
		
}

/*
boolean resultado = false;
		
		if (a == 0) {
			
			return true;
			
		} else {
			
			while (a > 0) {
				
				a = a - b;
				if (a == 0) {
					
					return true;
					
				}
				
			}
			
		}
		
return resultado;
*/
