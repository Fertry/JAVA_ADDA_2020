/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio3RecursivaFinal {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 3 - RECURSIVO				##################
	// ###################################################################################
	// ###################################################################################	
	
	// Dados dos numeros 1 y 2, se calcula a^expo en base a las siguientes condiciones
	// Si n=0 --> 1, si n>0 --> en funcion del modulo, usamos divide y venceras para obtener
	// una complejidad logaritmica:
	public static Long elevaARecursivoFinal(Integer exponente, Integer n) {
		
		return elevaARecursivoFinalInterno(1L, exponente, n);
	}
	
	// Funcion interna (privada) para ser llamada por la de arriba (publica) con 
	// parametros ya establecidos:
	public static Long elevaARecursivoFinalInterno(Long base, Integer exponente, Integer n) {
		
		if (n > 0) {
			
			if (n % 2 == 1) {
				
				base = base * exponente;
					
			} 
			
			return elevaARecursivoFinalInterno(base, (exponente *= exponente), (n / 2));
			
		}
		
		return base;
		
	}

}
