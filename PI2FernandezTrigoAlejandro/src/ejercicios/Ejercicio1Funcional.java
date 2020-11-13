/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import us.lsi.common.Streams2;

public class Ejercicio1Funcional {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dados dos strings, donde cada uno representa una frase,
	// itera sobre ambos. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posicion numerica, para ello se emplea el 
	// algoritmo de búsqueda binaria para obtener una complejidad de orden logaritmico:
	public static Integer hastaDondeSonIgualesFuncional(String frase1, String frase2) {
		
		return (int) Streams2.range(0, frase1.length(), 1).takeWhile(i -> frase1.charAt(i) == frase2.charAt(i)).count();
		
	}

}
