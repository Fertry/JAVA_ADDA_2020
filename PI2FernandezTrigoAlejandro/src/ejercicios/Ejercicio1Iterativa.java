/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.List;

public class Ejercicio1Iterativa {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################

	// Dada una lista de listas de strings, donde cada lista contiene dos frases,
	// itera sobre ambas frases de cada lista. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posición numérica, para ello se emplea el 
	// algoritmo de búsqueda binaria:
	public static Integer hastaDondeSonIgualesIterativo(List<String> lista) {
		
		int i = 0;
		Boolean verdadero = true;
		String frase1 = lista.get(0);
		String frase2 = lista.get(1);

		while (i < frase1.length() && verdadero) {
			
			if (frase1.charAt(i) == frase2.charAt(i)) {
				
				i++;
				
			} else {
				
				verdadero = false;
				
			}
				
		}
		
		return i;
		
	}

}
	