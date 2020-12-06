/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

public class Ejercicio3Iterativa {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 3 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion que dado un nº n entero calcula la siguiente sucesion numerica
	haciendo uso de un bucle while y devuelve el resultado como Long:
	* Complejidad: ????????????????????????
	*/
	public static Long ejercicio3Iterativo(Integer numero) {
		
	    int i = 3;
	    Long f1 = 1L;
	    Long f2 = 1L;
	    Long f3 = 2L;
	    Long fn = 0L;
	        
	    while (i <= numero) {
	    	
	        fn = 4 * f1 + f2 + f3;
	        f3 = f2;
	        f2 = f1;
	        f1 = fn;
	        i++;
	            
	    }
	    
	    return fn;
		 
	}
	
}
