/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.List;

public class Ejercicio1RecursivaFinal {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - RECURSIVO				##################
	// ###################################################################################
	// ###################################################################################
	
	// Dada una lista de listas de strings, donde cada lista contiene dos frases,
	// itera sobre ambas frases de cada lista. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posición numérica:
	public static Integer hastaDondeSonIgualesRecursivo(List<String> lista) {
		
		return hastaDondeSonIgualesRecursivoInterno(0, lista);
		
	}
	
	//
	private static Integer hastaDondeSonIgualesRecursivoInterno(int i, List<String> lista) {
	
		String frase1 = lista.get(0);
		String frase2 = lista.get(1);
		while (i < frase1.length()) {
			
			if (frase1.charAt(i) == frase2.charAt(i)) {
				
				i++;
				return hastaDondeSonIgualesRecursivoInterno(i, lista);
				
			} else {
				
				return i;
				
			}
	
		}
		
		return i;
		
	}
			
}
