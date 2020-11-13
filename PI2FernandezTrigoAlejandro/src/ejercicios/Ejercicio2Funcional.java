/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.stream.Stream;

public class Ejercicio2Funcional {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 2 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dado dos numeros a,b se calcula si a es múltiplo de b en base a las siguientes condiciones
	// Si a==0 --> true, si 0<a<b --> false y si a>=b --> a=a-b lo que supone una complejidad lineal:
	public static boolean esMultiploFuncional(Integer numero1, Integer numero2) {
		
		boolean resultado = true;

		if (numero1 == 0) {
			
			return true;
			 
		} else {

			resultado = Stream.iterate(numero1, x -> x - numero2).limit(numero1).anyMatch(x -> x == 0);
			
		}
		
		return resultado;
 		
	}
	
}
