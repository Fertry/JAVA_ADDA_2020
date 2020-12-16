/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Tuple3;
import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio2 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 2 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	y en cada linea nºs separados por comas, devuelve una lista de listas donde 
	cada lista interna representa un conjunto de números que se pasan al ejercicio: 
	*/
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
	
	/*
	Funcion auxiliar para, dado una lista de listas de integers devuelta por
	la función de lectura, invocar a la funcion recursiva que resuelve el 
	ejercicio tantas veces como filas tenga el fichero de entrada:
	*/
	public static void funcionAuxiliarEjercicio2(List<List<Integer>> lista) {
						
		for (List<Integer> miniLista : lista) {
		
			//Tuple3 <Integer, Integer, Integer> resultado = Ejercicio2Recursiva.ejercicio2Recursivo(miniLista);
			
			System.out.println("Lista de entrada: " + miniLista);
			//System.out.println(resultado);
			//System.out.println("Secuencia de suma mayor en intervalo: [" + resultado.v1 + "," + resultado.v2 +")");
			//System.out.println("Subsecuencia: " + resultado.v3 + " Suma obtenida: " + resultado.v3);
			System.out.println("\n");
			
		}
		
	}
				
}
	