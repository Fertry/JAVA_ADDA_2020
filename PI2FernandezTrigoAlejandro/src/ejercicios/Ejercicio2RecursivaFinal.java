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
	// Si a==0 --> true, si 0<a<b --> false y si a>=b --> a=a-b lo que supone una complejidad lineal:
	public static boolean esMultiploRecursivoFinal(Integer numero1, Integer numero2) {
		
		return esMultiploRecursivoFinalInterno(false, numero1, numero2);
		
	}
	
	// Funcion interna (privada) para ser llamada por la de arriba (publica) con 
	// parametros ya establecidos:
	private static boolean esMultiploRecursivoFinalInterno(boolean verdadero, Integer numero1, Integer numero2) {
		
		boolean resultado;
		
		if (numero1 == 0) {
			
			return true;
			
		} else if (numero1 > 0) {
			
			return esMultiploRecursivoFinalInterno(verdadero, numero1 - numero2, numero2);
			
		} else {
			
			resultado = verdadero;
			return resultado;
			
		}
		
	}
		
}
