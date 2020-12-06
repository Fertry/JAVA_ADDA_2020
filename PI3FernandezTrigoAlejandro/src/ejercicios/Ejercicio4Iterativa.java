/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

public class Ejercicio4Iterativa {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion que dados dos enteros a, b, calcule la siguiente sucesion numerica de forma
	iterativa gracias a un bucle while en base a los parametros de entrada y devuelve
	el resultado como Long: 
	* Complejidad: ????????????????????????
	*/
	public static Long ejercicio4Iterativo(Integer numeroA, Integer numeroB) {
		
		Long resultado = 0L;

        if (numeroA < 2 && numeroB < 2) {
        	
            resultado = (long) (numeroA + Math.pow(numeroB, 2));
            
        } else if (numeroA < 2 || numeroB < 2) {
        	
            resultado = (long) (Math.pow(numeroA, 2) + numeroB);
            
        } else {
        	
            // while()
        	
        }
        
        return resultado;
		
	}
	
}
