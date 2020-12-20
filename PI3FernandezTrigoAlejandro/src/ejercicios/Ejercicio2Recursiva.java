/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.List;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple3;

public class Ejercicio2Recursiva {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 2 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	Funcion publica que dado una lista de numeros localiza la sublista cuya suma de adyacentes 
	es mayor usando divide y venceras y que se realiza llamando a la funcion privada 
	ejercicio1RecursivoPrivado para actuar de forma opaca hacia el usuario:  
	*/
	public static Tuple3 <Integer, Integer, Integer> ejercicio2Recursivo(List<Integer> lista) {

		// Tamaño menos 1:
		Integer i = lista.size() - 1;
		
		return ejercicio2RecursivoPrivado(lista, 0, i);
		
	}
	
	/*
	Funcion privada que emplea el algoritmo de divide y venceras sobre la lista de entrada
	tantas veces como sea necesario para devolver una tupla con los indices que definen la 
	subsecuencia y la suma asociada:
	* Recursividad: 1 Caso base + 2 recursivos
	*/
	private static Tuple3<Integer, Integer, Integer> ejercicio2RecursivoPrivado(List<Integer> lista, int inicio, int fin) {
		
		// Caso base:
		if (inicio == fin) {
			
			return Tuple.create(inicio, fin, lista.get(inicio));
			
		}
		
		int mitad = (inicio + fin) / 2;

		// Casos recursivos:
		// Calcula la suma de la izquierda:
		Tuple3<Integer, Integer, Integer> secuenciaIzquierda = ejercicio2RecursivoPrivado(lista, inicio, mitad);
		// Calcula la suma de la derecha:
		Tuple3<Integer, Integer, Integer> secuenciaDerecha = ejercicio2RecursivoPrivado(lista, mitad + 1, fin);
		// Calcula la suma del cruze:
		Tuple3<Integer, Integer, Integer> secuenciaMitad = calculaSecuenciaMitad(lista, inicio, fin, mitad);

		// Obtiene los valores de sus sumas:
		int totalIzquierda = secuenciaIzquierda.getV3();
		int totalDerecha = secuenciaDerecha.getV3();
		int totalMitad = secuenciaMitad.getV3();
		
		// Compara las sumas para devolver la mayor:
		if (totalIzquierda > totalDerecha && totalIzquierda > totalMitad) {
			
			return secuenciaIzquierda;
			
		} else if (totalDerecha > totalIzquierda && totalDerecha > totalMitad) {
			
			return secuenciaDerecha;
			
		} else {
			
			return secuenciaMitad;
			
		}
		
	}

	/*
	Funcion auxiliar para calcular la subsecuencia asociada al cruce; esto es
	devuelve una tupla con sus indices y la suma asociada para comparar:
	*/
	public static Tuple3<Integer, Integer, Integer> calculaSecuenciaMitad(List<Integer> lista, Integer i, Integer j, Integer k) {
		
		int total = lista.get(k);
		int maximoIzquierda = k;
		int maximoDerecha = k + 1;
		int totalDerecha = lista.get(k);
		int totalIzquierda = lista.get(k);
		
		int indice1 = k - 1;
		while (indice1 >= i) {
			
			total = total + lista.get(indice1);
			
			if (total > totalIzquierda) {
				
				totalIzquierda = total;
				maximoIzquierda = indice1;
				
			}
			
			indice1--;
			
		}
		
		// Reseteo:
		total = lista.get(k);
		
		int indice2 = k + 1;
		while (indice2 < j) {
			
			total = total + lista.get(indice2);
			
			if (total > totalDerecha) {
				
				totalDerecha = total;
				maximoDerecha = indice2 + 1;
				
			}
			
			indice2++;
			
		}

		return Tuple.create(maximoIzquierda, maximoDerecha, totalIzquierda + totalDerecha - lista.get(k));

	}

}
