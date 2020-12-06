/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.HashSet;

public class Ejercicio1Recursiva {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 1 				 #################
	// ###################################################################################
	// ###################################################################################
	
	/*
	Funcion que dada una matriz calcula primero si sus elementos en las cuatro
	esquinas son distintos, si no es asi devuelve false, de lo contrario, 
	parte la matriz en cuatro (las matrices siempre son cuadradas) y repite el proceso.
	Esta funcion publica se usa para llamar a la recursiva privada de forma opaca 
	al usuario:
	*/
	public static Boolean ejercicio1Recursivo(Integer [][] matriz) {
		
		int fila = 0;
		int columna = 0;
		int dimension = matriz.length;
		
		return ejercicio1RecursivoPrivada(matriz, fila, columna, dimension);
		
	}
	
	/*
	Funcion privada recursiva que se llama a si misma para reducir la matriz a la par que
	se comprueba si sus extremos siguen siendo distintos o no mediante el uso
	de HashSets para evitar emplear excesivos booleanos. Se llama tantas veces como sea 
	necesario hasta que la matriz sea 2x2 o no se cumpla el requerimiento de que 
	sus cuatro esquinas difieran:
	* Recursividad: 2 casos base + 1 caso recursivo multiple
	* Complejidad: ????????????????????????
	*/
	private static Boolean ejercicio1RecursivoPrivada(Integer [][] matriz, Integer fila, Integer columna, Integer dimension) {
		
		Boolean resultado = false;
		
		if (dimension == 2) {

			// Caso base:
			HashSet<Integer> extremos1 = new HashSet<>(); 
			extremos1.add(matriz[fila][columna]);				// [0][0]
			extremos1.add(matriz[fila][columna + 1]);			// [0][1]
			extremos1.add(matriz[fila + 1][columna]);			// [1][0]
			extremos1.add(matriz[fila + 1][columna + 1]);		// [1][1]
			
			if (extremos1.size() == 4) {
				
				resultado = true;
				
			} else {
				
				resultado = false;
				
			}
			
		} else {
			
			// Caso recursivo:
			HashSet<Integer> extremos2 = new HashSet<>(); 
			extremos2.add(matriz[fila][columna]);				// [0][0]
			extremos2.add(matriz[fila][columna + 1]);			// [0][1]
			extremos2.add(matriz[fila + 1][columna]);			// [1][0]
			extremos2.add(matriz[fila + 1][columna + 1]);		// [1][1]
			
			if (extremos2.size() == 4) {
				
				Boolean matriz1 = ejercicio1RecursivoPrivada(matriz, fila, columna, (dimension / 2));
				Boolean matriz2 = ejercicio1RecursivoPrivada(matriz, fila, (columna + dimension / 2), (dimension / 2));
				Boolean matriz3 = ejercicio1RecursivoPrivada(matriz, (fila + dimension / 2), columna, (dimension / 2));
				Boolean matriz4 = ejercicio1RecursivoPrivada(matriz, (fila + dimension / 2), (columna + dimension / 2), (dimension / 2));
				
				resultado = matriz1 && matriz2 && matriz3 && matriz4;
				
			} else {
				
				resultado = false;
				
			}
			
		}
		
		return resultado;
		
	}
	
}
