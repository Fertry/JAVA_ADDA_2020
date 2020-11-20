/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.stream.Stream;

import us.lsi.common.Tuple;

public class Ejercicio3Funcional {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 3 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dados dos numeros 1 y 2, se calcula a^expo en base a las siguientes condiciones
	// Si n=0 --> 1, si n>0 --> en funcion del modulo, usamos divide y venceras para obtener
	// una complejidad logaritmica:
	public static Long elevaAFuncional(Integer exponente, Integer n) {
		
		// 1ª tupla: valores de entrada, 2ª tupla: operaciones sobre los valores:
 		return Stream.iterate(Tuple.create(n, exponente), t2 -> Tuple.create(t2.v1 / 2, t2.v2 * t2.v2))
 				.takeWhile(t -> t.v1 > 0)									// Mientras n > 0
 				.filter(t2 -> t2.v1 % 2 == 1)								// Solo si n % 2 == 1
 				.mapToLong(i -> i.v2)										// Obtenemos la base
 				.reduce(1, (numero1, numero2) -> numero1 * numero2);		// Multiplicamos las bases
 		
	}

}
