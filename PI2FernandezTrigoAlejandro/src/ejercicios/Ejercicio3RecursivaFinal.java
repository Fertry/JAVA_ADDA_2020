/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio3RecursivaFinal {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 3 - RECURSIVO				##################
	// ###################################################################################
	// ###################################################################################	
	
	// Dados dos numeros 1 y 2, que son respectivamente, la base (Long) y el exponente (Integer)
	// se calcula a^n en base a las siguientes condiciones
	// Si exponente=0 --> 0, si exponente>0 --> en funcion del modulo:
	public static Long elevaARecursivoFinal(Integer numero1, Integer numero2) {
		
		return elevaARecursivoFinalInterno(1L, numero1, numero2);
	}
	
	// Funcion interna (privada) para ser llamada por la de arriba (publica) con 
	// parametros ya establecidos:
	public static Long elevaARecursivoFinalInterno(Long resultado, Integer numero1, Integer numero2) {
		
		Long base = (long) numero1;
		Integer exponente = numero2;
		
		if (exponente > 0) {
			
			return elevaARecursivoFinalInterno(resultado, numero1, numero2);
			
		} else {
			
			return resultado;
			
		}
			
	}

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
	public static Long elevaAIterativo(Integer numero1, Integer numero2) {
		
		Long resultado = (long) 1;
		Long base = (long) numero1;
		Integer exponente = numero2;
		
		while (exponente > 0) {
				
			if (exponente % 2 == 1) {
					
				//Si modulo == 1 ----> (a^(n/2))^2 * a
				resultado = (long) (base * (Math.pow((Math.pow(base, (exponente / 2))), 2)));
				return resultado;
										
			} else {
					
				//Si modulo == 0 ----> (a^(n/2))^2
				resultado = (long) (Math.pow((Math.pow(base, (exponente / 2))), 2));
				return resultado;
					
			}
				
		}
			
		return resultado;
		
	}
*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////
