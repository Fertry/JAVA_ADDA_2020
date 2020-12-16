/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Pair;

public class Ejercicio4Iterativa {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion que dados dos enteros a, b, calcule la siguiente sucesion numerica de forma
	iterativa gracias a dos bucles whiles en base a los parametros de entrada y devuelve
	el resultado como Long: 
	* Complejidad: ????????????????????????
	*/
	public static Long ejercicio4Iterativo(Integer numeroA, Integer numeroB) {
		
		Map <Pair<Integer, Integer>, Long> mapa = new HashMap<>();
		
		int i = 0;
		while (i <= numeroA) {
			
			int j = 0;
			while (j <= numeroB) {
				
				if (i < 2 && j < 2) {
					
					mapa.put(Pair.of(i, j), (long)(i + (j * j)));
					
				} else if (i < 2 || j < 2) {
					
					mapa.put(Pair.of(i, j), (long)((i * i) + j));
					
				} else {
					
					Long termino1 = mapa.get(Pair.of(i / 2, j - 1));
					Long termino2 = mapa.get(Pair.of(i / 3, j - 2));
					Long termino3 = mapa.get(Pair.of(i - 2, j / 4));
					
					mapa.put(Pair.of(i, j), (termino1 + termino2 + termino3));
					
				}
				
				j++;
				
			}
			
			i++;
			
		}
		
		return mapa.get(Pair.of(numeroA, numeroB));
		
	}
	
}
