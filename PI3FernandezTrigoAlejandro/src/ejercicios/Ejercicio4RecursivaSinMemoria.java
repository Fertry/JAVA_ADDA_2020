/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

public class Ejercicio4RecursivaSinMemoria {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion que dados dos enteros a, b, calcule la siguiente sucesion numerica en funcion 
	de dos casos bases y uno recursivo que se llama a si mismo tantas veces como sea necesario
	y devuelve el resultado en forma de Long: 
	* Recursividad: 2 casos base y uno recursivo
	* Complejidad: ????????????????????????
	*/
	public static Long ejercicio4RecursivoSinMemoria(Integer numeroA, Integer numeroB) {
		
		Long resultado;
		
		// Casos bases:
		if (numeroA < 2 && numeroB < 2) {
			
			resultado = (long) (numeroA + Math.pow(numeroB, 2));

		} else if (numeroA < 2 || numeroB < 2) {
			
			resultado = (long) (Math.pow(numeroA, 2) + numeroB);
		
		// Caso recursivo:
		} else {
			
			resultado = (long) ejercicio4RecursivoSinMemoria((numeroA / 2), (numeroB - 1)) + 
					ejercicio4RecursivoSinMemoria((numeroA / 3), (numeroB - 2)) + 
					ejercicio4RecursivoSinMemoria((numeroA - 2), (numeroB / 4));
			
		}
		
		return resultado;
		
	}
	
}
