/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 3
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

public class Ejercicio4 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea dos enteros separados por coma, devuelve una lista de listas
	// de enteros donde cada minilista representa un par de enteros:
	public static List<List<Integer>> leeDatosEjercicio4(String fichero) {
		
		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
			
		while (i < lista.size()) {
				
			String fila = lista.get(i);
			String[] numeros = fila.split(",");
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
	// la funcion de lectura, invocar a las funciones que resuelven el 
	// ejercicio tantas veces como pares de numeros tenga la lista de entrada:
	public static void funcionAuxiliarEjercicio4(List<List<Integer>> lista) {
				
		Integer resultadoIterativo;
		Integer resultadoRecursivoConMemoria;
		Integer resultadoRecursivoSinMemoria;
		
		for (List<Integer> miniLista : lista) {
			
			Integer a = miniLista.get(0);
			Integer b = miniLista.get(1);
			
			resultadoIterativo = Ejercicio4Iterativa.ejercicio4Iterativo(a, b);
			resultadoRecursivoConMemoria = Ejercicio4RecursivaConMemoria.ejercicio4RecursivoConMemoria(a, b);
			resultadoRecursivoSinMemoria = Ejercicio4RecursivaSinMemoria.ejercicio4RecursivoSinMemoria(a, b);
				
			System.out.println("Par de entrada: (a,b) = (" + a + "," + b + "): ");
			System.out.println("1. Resultado iterativo: " + resultadoIterativo);
			System.out.println("2. Resultado recursivo con memoria: " + resultadoRecursivoConMemoria);
			System.out.println("3. Resultado recursivo sin memoria: " + resultadoRecursivoSinMemoria);
			System.out.println("\n");
			
		}
			
	}
	
}
