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
		
		Integer i = 0;
		Integer j = lista.size();
		
		return ejercicio2RecursivoPrivado(lista, i, j);
		
	}
	
	/*
	Funcion privada que emplea el algoritmo de divide y venceras sobre la lista de entrada
	tantas veces como sea necesario para devolver una tupla con la lista resultado, su suma 
	y su subsecuencia (indices):
	* Recursividad: ????????????????????????
	* Complejidad: ????????????????????????
	*/
	private static Tuple3<Integer, Integer, Integer> maxSumaCruce(List<Integer> lista, int inicio, int fin) {
		
		int mitad = (inicio + fin) / 2;
		int suma = 0;
		int maxIzq = 0;
		int sumaIzq = Integer.MIN_VALUE;
		int i = mitad;
		while (i >= inicio) {
			suma = suma + lista.get(i);
			if (suma > sumaIzq) {
				sumaIzq = suma;
				maxIzq = i;
			}
			i--;
		}
		suma = 0;
		int maxDer = lista.size() - 1;
		int sumaDer = Integer.MIN_VALUE;
		int j = mitad + 1;
		while (j <= fin) {
			suma = suma + lista.get(j);
			if (suma > sumaDer) {
				sumaDer = suma;
				maxDer = j;
			}
			j++;
		}
		return Tuple.create(maxIzq, maxDer, sumaIzq + sumaDer);
		
	}

	private static Tuple3<Integer, Integer, Integer> ejercicio2RecursivoPrivado(List<Integer> lista, int inicio, int fin) {
		if (inicio == fin) {
			return Tuple.create(inicio, fin, lista.get(inicio));
		}
		int mitad = (inicio + fin) / 2;

		Tuple3<Integer, Integer, Integer> subsecIzq = ejercicio2RecursivoPrivado(lista, inicio, mitad);
		Tuple3<Integer, Integer, Integer> subsecDer = ejercicio2RecursivoPrivado(lista, mitad + 1, fin);
		Tuple3<Integer, Integer, Integer> maxCrossingSubArray = maxSumaCruce(lista, inicio, fin);

		int sumaIzq = subsecIzq.getV3();
		int sumaDer = subsecDer.getV3();

		int sumaCruce = maxCrossingSubArray.getV3();
		if (sumaIzq > sumaDer && sumaIzq > sumaCruce) {
			return subsecIzq;
		} else if (sumaDer > sumaIzq && sumaDer > sumaCruce) {
			return subsecDer;
		} else {
			return maxCrossingSubArray;
		}
	}
	
	
	/*
	private static Tuple3<Integer, Integer, Integer> ejercicio2RecursivoPrivado(List<Integer> ls, Integer i, Integer j) {

		Tuple3<Integer, Integer, Integer> res;
		
		// Caso base
		if (j - i <= 1) { // solo hay un único elemento
			
			// retorna una tupla <i, j, ls[i]>
			res = Tuple.create(i, j, ls.get(i)); 
			
		} else {
			
			// Case Recursivo
			Integer k = (i + j) / 2;
			// 1) Suponemos que k sí está en la subsecuencia máxima
     		///////// ESTO ES LO QUE HAY QUE CAMBIAR
			Tuple3<Integer, Integer, Integer> s1 = maxSumaCruce(ls,i, j);
			//Tuple3<Integer, Integer, Integer> s1 = ejercicio2RecursivoPrivado(ls, i, j - 1);

			// 2) Suponemos que k no está en la subsecuencia máxima
			// 2a) Buscamos por la izquierda
			Tuple3<Integer, Integer, Integer> s2 = ejercicio2RecursivoPrivado(ls, i, k);
			// 2b) Buscamos por la derecha
			Tuple3<Integer, Integer, Integer> s3 = ejercicio2RecursivoPrivado(ls, k + 1, j);

			res = tuplaMayor(s1, s2, s3);

		}
		// Devolvemos la secuencia cuya suma sea máxima
		return res;
	}
	*/
	
	// Auxiliar:
	/*
	public static Tuple3<Integer, Integer, Integer> maxSumaCruce(List<Integer> lista, int inicio, int fin) {
		int mitad = (inicio + fin) / 2;
		int suma = 0;
		int maxIzq = 0;
		int sumaIzq = Integer.MIN_VALUE;
		int i = mitad;
		while (i >= inicio) {
			suma = suma + lista.get(i);
			if (suma > sumaIzq) {
				sumaIzq = suma;
				maxIzq = i;
			}
			i--;
		}
		suma = 0;
		int maxDer = lista.size() - 1;
		int sumaDer = Integer.MIN_VALUE;
		int j = mitad + 1;
		while (j <= fin) {
			suma = suma + lista.get(j);
			if (suma > sumaDer) {
				sumaDer = suma;
				maxDer = j;
			}
			j++;
		}
		return Tuple.create(maxIzq, maxDer, sumaIzq + sumaDer);
	}
	*/

	/*
	private static Tuple3 <Integer, Integer, Integer> ejercicio2RecursivoPrivado(List<Integer> lista, int i, int j) {
		
		Tuple3 <Integer, Integer, Integer> resultado = null;
		
		// Caso base: la lista de entrada es un unico numero:
		if (j - i <= 1) {
			
			resultado = Tuple.create(i, j, lista.get(i));
			
		} else {
			
			// Indice a la mitad de la lista:
			Integer k = ((i + j) / 2);
			
			// Caso recursivo: divide y venceras: Si k esta en la subsecuencia maxima:
			Tuple3 <Integer, Integer, Integer> sumaBase = null;
			Tuple3 <Integer, Integer, Integer> parte1 = ejercicio2RecursivoPrivado(lista, i, k);
			Tuple3 <Integer, Integer, Integer> parte2 = ejercicio2RecursivoPrivado(lista, (k + 1), j);
			
			if (parte1.v3 < parte2.v3) {
				
				sumaBase = Tuple.create(parte2.v1, parte2.v2, (parte1.v3 + parte2.v3));
				
			} else {
				
				sumaBase = Tuple.create(parte1.v1, parte1.v2, (parte1.v3 + parte2.v3));
				
			}

			// Caso recursivo: divide y venceras: Si k no esta en la subsecuencia maxima:
			// Hacia la izquierda <---
			Tuple3 <Integer, Integer, Integer> sumaIzquierda = ejercicio2RecursivoPrivado(lista, i, k);
			// Hacia la derecha --->
			Tuple3 <Integer, Integer, Integer> sumaDerecha = ejercicio2RecursivoPrivado(lista, (k + 1), j);
			
			resultado = tuplaMayor(sumaBase, sumaIzquierda, sumaDerecha);
			
		}
		
		return resultado;
		
	}
	*/
	
	/*
	Funcion privada que dadas tres tuplas cuyo tercer elemento se corresponde a la suma que buscamos,
	hace uso de la funcion privada mayorDeTres() para determinar cual es la mejor (aquella cuya suma
	sea mayor):
	*/
	
	/*
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
	*/
	
	/*
	Funcion privada que dados tres numeros enteros devuelve aquel que es mayor
	haciendo uso de conjuntos:
	*/
	
	/*
	private static Integer mayorDeTres(int numero1, int numero2, int numero3) {
		
		List<Integer> lista = new ArrayList<Integer>();
		
		lista.add(numero1);
		lista.add(numero2);
		lista.add(numero3);
			
		return Collections.max(lista);
		
	}
	*/
	
}
