/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.List;

import us.lsi.common.Streams2;

public class Ejercicio1Funcional {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dada una lista de listas de strings, donde cada lista contiene dos frases,
	// itera sobre ambas frases de cada lista. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posición numerica:
	public static Integer hastaDondeSonIgualesFuncional(List<String> lista) {
		
		return (int) Streams2.range(0, lista.get(0).length(), 1).takeWhile(i -> lista.get(0).charAt(i) == lista.get(1).charAt(i)).count();
		
	}

}
