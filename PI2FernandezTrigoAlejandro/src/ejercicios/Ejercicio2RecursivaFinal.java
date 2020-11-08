/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio2RecursivaFinal {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 2 - RECURSIVO				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dado dos numeros a,b se calcula si a es múltiplo de b en base a las siguientes condiciones
	// Si a==0 --> true, si 0<a<b --> false y si a>=b --> a=a-b:
	public static boolean esMultiploRecursivoFinal(Integer a, Integer b) {
		
		return esMultiploRecursivoFinalInterno(false, a, b);
	}
	
	// Funcion interna (privada) para ser llamada por la de arriba (publica) con 
	// parametros ya establecidos:
	private static boolean esMultiploRecursivoFinalInterno(boolean verdadero, Integer a, Integer b) {
		
		boolean resultado;
		
		if (a == 0) {
			
			return true;
			
		} else if (a > 0) {
			
			return esMultiploRecursivoFinalInterno(verdadero, a - b, b);
			
		} else {
			
			resultado = verdadero;
			return resultado;
			
		}
		
	}
		
}
