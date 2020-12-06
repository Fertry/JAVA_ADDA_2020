/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
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
	public static Tuple3 <Integer, Integer, Integer> ejercicio1Recursivo(List<Integer> lista) {
		
		Integer i = 0;
		Integer j = lista.size();
		
		return ejercicio1RecursivoPrivado(lista, i, j);
		
	}
	
	/*
	Funcion privada que emplea el algoritmo de divide y venceras sobre la lista de entrada
	tantas veces como sea necesario para devolver una tupla con la lista resultado, su suma 
	y su subsecuencia (indices):
	* Recursividad: ????????????????????????
	* Complejidad: ????????????????????????
	*/
	private static Tuple3 <Integer, Integer, Integer> ejercicio1RecursivoPrivado(List<Integer> lista, int i, int j) {
		
		Tuple3 <Integer, Integer, Integer> resultado = null;
		
		// Caso base: la lista de entrada es un unico numero:
		if (j - i <= 1) {
			
			resultado = Tuple.create(i, j, lista.get(i));
			
		} else {
			
			// Indice a la mitad de la lista:
			Integer k = ((i + j) / 2);
			
			// Caso recursivo: divide y venceras: Si k esta en la subsecuencia maxima:
			Tuple3 <Integer, Integer, Integer> sumaBase = null;
			Tuple3 <Integer, Integer, Integer> parte1 = ejercicio1RecursivoPrivado(lista, i, k);
			Tuple3 <Integer, Integer, Integer> parte2 = ejercicio1RecursivoPrivado(lista, (k + 1), j);
			
			if (parte1.v3 < parte2.v3) {
				
				sumaBase = Tuple.create(parte2.v1, parte2.v2, (parte1.v3 + parte2.v3));
				
			} else {
				
				sumaBase = Tuple.create(parte1.v1, parte1.v2, (parte1.v3 + parte2.v3));
				
			}

			// Caso recursivo: divide y venceras: Si k no esta en la subsecuencia maxima:
			// Hacia la izquierda <---
			Tuple3 <Integer, Integer, Integer> sumaIzquierda = ejercicio1RecursivoPrivado(lista, i, k);
			// Hacia la derecha --->
			Tuple3 <Integer, Integer, Integer> sumaDerecha = ejercicio1RecursivoPrivado(lista, (k + 1), j);
			
			resultado = tuplaMayor(sumaBase, sumaIzquierda, sumaDerecha);
			
		}
		
		return resultado;
		
	}
	
	/*
	Funcion privada que dadas tres tuplas cuyo tercer elemento se corresponde a la suma que buscamos,
	hace uso de la funcion privada mayorDeTres() para determinar cual es la mejor (aquella cuya suma
	sea mayor):
	*/
	private static Tuple3 <Integer, Integer, Integer> tuplaMayor(Tuple3 <Integer, Integer, Integer> tupla1, Tuple3 <Integer, Integer, Integer> tupla2, Tuple3 <Integer, Integer, Integer> tupla3) {
		
		int numeroTupla1 = tupla1.v3;
		int numeroTupla2 = tupla2.v3;
		int numeroTupla3 = tupla3.v3;
		
		int mayorNumero = mayorDeTres(numeroTupla1, numeroTupla2, numeroTupla3);
		
		if (numeroTupla1 == mayorNumero) {
			
			return tupla1;
			
		} else if (numeroTupla2 == mayorNumero) {
			
			return tupla2;
			 
		} else {
			
			return tupla3;
			
		} 
			
	}
	
	/*
	Funcion privada que dados tres numeros enteros devuelve aquel que es mayor
	haciend uso de conjuntos:
	*/
	private static Integer mayorDeTres(int numero1, int numero2, int numero3) {
		
		List<Integer> lista = new ArrayList<Integer>();
		
		lista.add(numero1);
		lista.add(numero2);
		lista.add(numero3);
			
		return Collections.max(lista);
		
	}
	
}
