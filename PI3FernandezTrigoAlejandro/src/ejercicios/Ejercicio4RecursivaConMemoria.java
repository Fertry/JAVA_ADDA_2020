/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class Ejercicio4RecursivaConMemoria {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion publica que llame al ejercicio recursivo pasando como parametro
	el Map que se emplea como memoria para actuar de forma opaca al usuario:
	*/
	public static Long ejercicio4RecursivoConMemoria(Integer numeroA, Integer numeroB) {
		
		// Empleamos Tuple2 para "encapsular" los dos numeros que se reciben como parametros:
		Map <Tuple2 <Integer, Integer>, Long> memoria = new HashMap <Tuple2 <Integer, Integer>, Long>();
		
		return ejercicio4RecursivoConMemoriaPrivado(numeroA, numeroB, memoria);
		
	}
	
	/*
	Funcion publica que dados dos enteros a, b, calcule la siguiente sucesion numerica en funcion 
	de tres casos bases y uno recursivo que se llama a si mismo tantas veces como sea necesario
	haciendo uso de memoria con un Map para evitar repetir calculos y devuelve el 
	resultado en forma de Long:
	* Recursividad: 3 casos base y uno recursivo
	*/ 
	private static Long ejercicio4RecursivoConMemoriaPrivado(Integer numeroA, Integer numeroB, Map <Tuple2 <Integer, Integer>, Long> memoria) {
		
		Long resultado;
		Tuple2 <Integer, Integer> tupla = Tuple.create(numeroA, numeroB);
		
		// Casos bases:	
		if (memoria.containsKey(tupla)) {
			
			resultado = memoria.get(tupla);
		
		} else if (numeroA < 2 && numeroB < 2) {
			
			resultado = (long) (numeroA + Math.pow(numeroB, 2));
			memoria.put(tupla, resultado);
			
		} else if (numeroA < 2 || numeroB < 2) {
			
			resultado = (long) (Math.pow(numeroA, 2) + numeroB);
			memoria.put(tupla, resultado);

		// Caso recursivo:
		} else {
			
			resultado = (long) ejercicio4RecursivoConMemoriaPrivado((numeroA / 2), (numeroB - 1), memoria) + 
						ejercicio4RecursivoConMemoriaPrivado((numeroA / 3), (numeroB - 2), memoria) +
						ejercicio4RecursivoConMemoriaPrivado((numeroA - 2), (numeroB / 4), memoria);
			
		}
		
		return resultado;
		
	}
	
}
