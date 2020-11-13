/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 2
 */

package ejercicios;

public class Ejercicio3Iterativa {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 		EJERCICIO 3 - ITERATIVO				##################
	// ###################################################################################
	// ###################################################################################
			
	// Dados dos numeros 1 y 2, se calcula a^expo en base a las siguientes condiciones
	// Si n=0 --> 1, si n>0 --> en funcion del modulo, usamos divide y venceras para obtener
	// una complejidad logaritmica:
	public static Long elevaAIterativo(Long exponente, Integer n) {
		
		Long base = 1L;

		while (n > 0) {
			
			if (n % 2 == 1) {
				
				base = base * exponente;
				
			}
				
			exponente *= exponente; 
			n = n / 2;
					
		}
		
		return base;
		
	}

}


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
