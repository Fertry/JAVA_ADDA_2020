/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio2 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 2 				 #################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea n�s separados por comas, devuelve una lista de listas donde 
	// cada lista interna representa un conjunto de n�meros que se pasan al ejercicio:
	public static List<List<Integer>> leeDatosEjercicio2(String fichero) {
		
		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
			
		while (i < lista.size()) {
				
			String fila = lista.get(i);
			String[] numeros = fila.split(", ");
			List<Integer> miniLista = new ArrayList<>();
				
			while (j < numeros.length) {
					
				miniLista.add(Integer.parseInt(numeros[j]));
				j++;
					
			}
				
			resultado.add(miniLista);
			j = 0;
			i++;
				
		}
			
		return resultado;
			
	}
	
	// Funcion auxiliar para, dado una lista de listas de integers devuelta por
	// la funci�n de lectura, invocar a la funcion recursiva que resuelve el 
	// ejercicio tantas veces como filas tenga el fichero de entrada:
	public static void funcionAuxiliarEjercicio2(List<List<Integer>> lista) {
				
		//List <Integer> resultado = new ArrayList <Integer>();
		int numero = 0;
				
		for (List<Integer> miniLista : lista) {
		
			//resultado = Ejercicio2Recursiva.ejercicio1Recursivo(miniLista);
			
			System.out.println("Lista de entrada: " + miniLista);
			System.out.println("Secuencia de suma mayor en intervalo: [" + numero + "," + numero +")");
			//System.out.println("Subsecuencia: " + resultado + " Suma obtenida: " + sumatorio(resultado));
			System.out.println("\n");
			
		}
		
	}
	
	// Funcion privada que dado una lista de enteros, devuelve su suma:
	private static Integer sumatorio(List <Integer> lista) {
		
		int resultado = 0;
		
		for (Integer numero : lista) {
			
			resultado += numero;
			
		}
		
		return resultado;
		
	}
					
}
	