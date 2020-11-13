/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio1RecursivaFinal {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - RECURSIVO				##################
	// ###################################################################################
	// ###################################################################################
	
	// Dados dos strings, donde cada uno representa una frase,
	// itera sobre ambos. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posicion numerica, para ello se emplea el 
	// algoritmo de búsqueda binaria para obtener una complejidad de orden logaritmico:
	public static Integer hastaDondeSonIgualesRecursivo(String frase1, String frase2) {
		
		Integer i = 0;
		Integer j = frase1.length();
		
		return hastaDondeSonIgualesRecursivoInterno(i, j, frase1, frase2);
		
	}
	
	// Funcion interna (privada) para ser llamada por la de arriba (publica) con 
	// parametros ya establecidos:
	private static Integer hastaDondeSonIgualesRecursivoInterno(int i, int j, String frase1, String frase2) {

		Integer k = 0;
		Integer resultado = -1;
		
		if (j - i > 0 && resultado == -1) {
			
			// Posición: la mitad
			k = ((i + j) / 2);
			if (frase1.charAt(k) == frase2.charAt(k)) {
				
				//i = k + 1;
				return hastaDondeSonIgualesRecursivoInterno((k + 1), j, frase1, frase2);
				
			} else {
				
				// Hacia la izquierda
				if (frase1.charAt(k - 1) == frase2.charAt(k - 1)) {
					
					resultado = k;
					
				} else {
					
					//j = k;
					return hastaDondeSonIgualesRecursivoInterno(i, k, frase1, frase2);
					
				}
				
			}
			
		} else {
			
			return resultado;
			
		}
		
		return resultado;
		
	}
			
}
