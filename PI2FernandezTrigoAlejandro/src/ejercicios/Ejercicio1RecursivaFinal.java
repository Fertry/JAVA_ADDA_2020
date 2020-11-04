package ejercicios;

import java.util.List;

public class Ejercicio1RecursivaFinal {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 1 - RECURSIVO				##################
	// ###################################################################################
	// ###################################################################################
	
	// Dada una lista de listas de strings, donde cada lista contiene dos frases,
	// itera sobre ambas frases de cada lista. Determina en que punto de ambas frases
	// dejan de ser iguales y devuelve esa posición numérica:
	public static Integer hastaDondeSonIgualesRecursivo(List<String> lista) {
		
		return hastaDondeSonIgualesRecursivoInterno(0, lista);
		
	}
	
	private static Integer hastaDondeSonIgualesRecursivoInterno(int i, List<String> lista) {
		// TO-DO
		Integer resultado = 0;
		Boolean verdadero = true;		
		String frase1 = lista.get(0);
		String frase2 = lista.get(1);
			
		if (frase1.charAt(i) == frase2.charAt(i)) {

			resultado = hastaDondeSonIgualesRecursivoInterno(i, lista);
			i++;
			
		} else {
			
			verdadero = false;
			
		}
		
		return resultado;

	}
	
}
