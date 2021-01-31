/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

import java.util.stream.Stream;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple4;

public class Funcional {
	
	/*
	 * Función de tipo funcional para:
	 * 	1. Recorrer dos elementos (en este caso strings) caracter a caracter (se usa una función auxiliar
	 * 	   para hacerlo con divide y venceras en lugar de a lo bestia),
	 * 	2. Comprobar si cumplen un predicado concreto,
	 * 	3. Devolver el primer caso que verifique el predicado anterior.
	 */
	public static Integer ejercicio1(String frase1, String frase2) {
		
		Integer i = 0;
		Integer k = 0;
		Integer resultado = -1;
		Integer j = frase1.length();

		return Stream
				// Creamos la tupla con los valores a utilizar: se itera sobre los elementos de entrada llamando a la función específica para ello:
				.iterate(Tuple.create(i, j, k, resultado), tupla -> siguienteIteracion(tupla, frase1, frase2))	
				// Mientras se cumpla j - i > 0 y resultado = -1, es decir, se comprueba si verifica todavia un predicado:
				.filter(tupla -> !(tupla.v2 - tupla.v1 > 0 && tupla.v4 == -1))									
				// Devuelve el 1º resultado que es v4: Esto es, encuentra el elemento y lo obtiene con .get() tras lo cual acabamos:
				.findFirst()																					
		        .get()																						
		        .v4;
		
	}
	
	// #######################################################################################
	// #######################################################################################
	
	/*
	 * Ejemplo de divide y vencerás, explicado en el fichero de DivideYVenceras.java que se llama desde la función
	 * funcional de arriba como una lambda. 
	 */
	private static Tuple4 <Integer, Integer, Integer, Integer> siguienteIteracion(Tuple4 <Integer, Integer, Integer, Integer> tupla, String frase1, String frase2) {
		
		Integer i = tupla.getV1();
		Integer j = tupla.getV2();
		Integer k = tupla.getV3();
		Integer resultado = tupla.getV4();

		// Posicion: la mitad
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
	
	// #######################################################################################
	// #######################################################################################
	
	/*
	 * Función que:
	 * 	1. Itera sobre un parámetro (numero1, actualizandose con numero2),
	 *  2. Establece un limite (usando numero1) como condicion de parada final, 
	 *  3. Calcula un valor booleano en base a un predicado.
	 */
	public static boolean ejercicio2(Integer numero1, Integer numero2) {
		
		boolean resultado = true;

		if (numero1 == 0) {
			return true;
		} else {
			// Iterar fijando un límite previo y comprobar (booleano) si se verifica un predicado
			// durante el recorrido: 
			resultado = Stream.iterate(numero1, x -> x - numero2).limit(numero1).anyMatch(x -> x == 0);
		}
		
		return resultado;
 		
	}
	
	// #######################################################################################
	// #######################################################################################
	
	/*
	 * Función de tipo funcional para trabajar con Maps. Crear tuplas de los valores de entrada
	 * para los cuales define un ciclo iterador, un filtro y una operación (reduce) antes de 
	 * añadirlos al mapa en base a la clave (v2). 
	 */
	public static Long ejercicio3(Integer exponente, Integer n) {
		
		// 1º tupla: valores de entrada, 2º tupla: operaciones sobre los valores:
 		return Stream.iterate(Tuple.create(n, exponente), t2 -> Tuple.create(t2.v1 / 2, t2.v2 * t2.v2))
 				.takeWhile(t -> t.v1 > 0)									// Mientras n > 0
 				.filter(t2 -> t2.v1 % 2 == 1)								// Solo si n % 2 == 1
 				.mapToLong(i -> i.v2)										// Obtenemos la base
 				.reduce(1, (numero1, numero2) -> numero1 * numero2);		// Multiplicamos las bases
 		
	}

}
