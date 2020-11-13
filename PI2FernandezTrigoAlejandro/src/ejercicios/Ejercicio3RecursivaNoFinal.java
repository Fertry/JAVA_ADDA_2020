/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio3RecursivaNoFinal {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 	 EJERCICIO 3 - RECURSIVO	NO FINAL	    ##############
	// ###################################################################################
	// ###################################################################################	
		
	// Dados dos numeros 1 y 2, se calcula a^expo en base a las siguientes condiciones
	// Si n=0 --> 1, si n>0 --> en funcion del modulo, usamos divide y venceras para obtener
	// una complejidad logaritmica:
	public static Long elevaARecursivoNoFinal(Integer exponente, Integer n) {
		
		Long resultado;
		
		if (n > 0) {
			
			resultado = elevaARecursivoNoFinal(exponente, (n / 2));
			
			if (n % 2 == 1) {
				
				resultado = ((resultado * resultado) * exponente);
				
			} else {
				
				resultado *= resultado;
				
			}
			
		} else {
			
			resultado = 1L;
			
		}
		
		return resultado;
		
	}
	
}
