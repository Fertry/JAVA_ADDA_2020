/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

import java.util.stream.Stream;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple4;

public class Ejercicio1Funcional {

	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - FUNCIONAL				##################
	// ###################################################################################
	// ###################################################################################
		
	// Dados dos strings, donde cada uno representa una frase,
	// itera sobre ambos. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posicion numerica, para ello se emplea el 
	// algoritmo de b�squeda binaria para obtener una complejidad de orden logaritmico:
	public static Integer hastaDondeSonIgualesFuncional(String frase1, String frase2) {
		
		Integer i = 0;
		Integer k = 0;
		Integer resultado = -1;
		Integer j = frase1.length();

		return Stream
				.iterate(Tuple.create(i, j, k, resultado), tupla -> siguienteIteracion(tupla, frase1, frase2))	// Creamos la tupla con los valores a utilizar
		        .filter(tupla -> !(tupla.v2 - tupla.v1 > 0 && tupla.v4 == -1))									// Mientras se cumpla j - i > 0 y resultado = -1
		        .findFirst()																					// Devuelve el 1� resultado que es v4
		        .get()																							// Obtenemos su valor (entero) que se devuelve
		        .v4;
		
	}
	
	// M�todo privado para ser llamado desde el Stream, itera sobre la tupla dada siguiendo la misma secuencia if/else utilizada en el m�todo
	// iterativo para aplicar b�squeda binaria al problema y resolverlo con complejidad logar�tmica:
	private static Tuple4 <Integer, Integer, Integer, Integer> siguienteIteracion(Tuple4 <Integer, Integer, Integer, Integer> tupla, String frase1, String frase2) {
		
		Integer i = tupla.getV1();
		Integer j = tupla.getV2();
		Integer k = tupla.getV3();
		Integer resultado = tupla.getV4();

		// Posici�n: la mitad
		k = ((tupla.v1 + tupla.v2) / 2);
		if (frase1.charAt(k) == frase2.charAt(k)) {
			
		    i = k + 1;
		    
		} else {
			
			// Hacia la izquierda
		    if (frase1.charAt(k - 1) == frase2.charAt(k - 1)) {
		    	
		    	resultado = k;
		    	
		    } else {
		    	
		        j = k;
		        
		    }
		    
		}
		
		return Tuple.create(i, j, k, resultado);
		
	}

}
