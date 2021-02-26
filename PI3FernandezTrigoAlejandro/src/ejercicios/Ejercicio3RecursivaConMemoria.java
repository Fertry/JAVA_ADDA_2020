/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio3RecursivaConMemoria {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 3 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion publica que llame al ejercicio recursivo pasando como parametro
	el Map que se emplea como memoria para actuar de forma opaca al usuario:
	*/
	public static Long ejercicio3RecursivoConMemoria(Integer numero) {
		
		Map<Integer, Long> memoria = new HashMap<Integer, Long>();
		
		return ejercicio3RecursivoConMemoriaPrivado(numero, memoria);
		
	}
	
	/*
	Funcion privada que dado un nº n entero calcula la siguiente sucesion numerica
	en base a tres casos bases y uno recursivo que se llama a si mismo tantas
	veces como sea necesario haciendo uso de memoria con un Map para evitar
	repetir operaciones y devuelve el resultado como Long:
	* Recursividad: 3 casos base y uno recursivo
	*/
	private static Long ejercicio3RecursivoConMemoriaPrivado(Integer numero, Map<Integer, Long> memoria) {
		
		Long resultado = 0L;
		
		// Casos base:
		if (memoria.containsKey(numero)) {
			
			resultado = memoria.get(numero);
			
		} else if (numero == 0) {
			
			resultado = 2L;
			memoria.put(numero, resultado);
			
		} else if (numero == 1 || numero == 2) {
			
			resultado = 1L;
			memoria.put(numero, resultado);
			
		// Caso recursivo:
		} else {
			
			resultado = (4 * ejercicio3RecursivoConMemoriaPrivado((numero - 1), memoria)) + 
						ejercicio3RecursivoConMemoriaPrivado((numero - 2), memoria) + 
						ejercicio3RecursivoConMemoriaPrivado((numero - 3), memoria);
			memoria.put(numero, resultado);
			
		}
		
		return resultado;
		
	}

}
