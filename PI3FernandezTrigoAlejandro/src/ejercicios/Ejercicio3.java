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

public class Ejercicio3 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 3 				 #################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea un formato n=numero, hace split y se queda con los numeros
	// que son devueltos en una lista:
	public static List<Integer> leeDatosEjercicio3(String fichero) {

		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<Integer> resultado = new ArrayList<Integer>();
		
		while (i < lista.size()) {

			String fila = lista.get(i);
			String numero = fila.replace("n=", "");
			resultado.add(Integer.parseInt(numero));
			i++;

		}

		return resultado;

	}
	
	// Funcion auxiliar para, dado una lista de integers devuelta por
	// la funcion de lectura, invocar a las funciones que resuelven el 
	// ejercicio tantas veces como numeros tenga la lista de entrada:
	public static void funcionAuxiliarEjercicio3(List<Integer> lista) {
				
		List <Integer> resultadoIterativo = new ArrayList<Integer>();
		List <Integer> resultadoRecursivoConMemoria = new ArrayList<Integer>();
		List <Integer> resultadoRecursivoSinMemoria = new ArrayList<Integer>();
		
		for (Integer numero : lista) {
			
			resultadoIterativo = Ejercicio3Iterativa.ejercicio3Iterativo(numero);
			resultadoRecursivoConMemoria = Ejercicio3RecursivaConMemoria.ejercicio3RecursivoConMemoria(numero);
			resultadoRecursivoSinMemoria = Ejercicio3RecursivaSinMemoria.ejercicio3RecursivoSinMemoria(numero);
			
			System.out.println("\n");
			
		}
			
	}
	
	
}
