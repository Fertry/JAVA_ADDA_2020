/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio1Funcional {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dada una lista de listas de strings, donde cada lista contiene dos frases,
	// itera sobre ambas frases de cada lista. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posición numérica:
	public static Integer hastaDondeSonIgualesFuncional(List<String> lista) {
		
		return (int) IntStream.range(0, lista.get(0).length()).takeWhile(i -> lista.get(0).charAt(i) == lista.get(1).charAt(i)).count();
		
	}

}
