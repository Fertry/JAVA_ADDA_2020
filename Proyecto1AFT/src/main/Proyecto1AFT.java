/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 1
 */

package main;

// Librerias:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

public class Proyecto1AFT {
	
	// Funcion principal:
	public static void main(String[] args) {
		
		// Variables:
		List <Integer> listaEnteros = leeDatosEjercicio1("Tests/PI1Ej1DatosEntrada.txt");
		List <Integer> resultadoEjercicio1 = compruebaSiEsPrimo(listaEnteros);
		
		System.out.println("###################################################");
		System.out.println("################## Test de Ejercicio 1 ############");
		System.out.println("Datos de entrada --> Lista de enteros: ");
		System.out.println(listaEnteros);
		System.out.println("Resultado del ejercicio 1 --> Lista de primos: ");
		System.out.println(resultadoEjercicio1);
		System.out.println("###################################################");
		System.out.println("###################################################");
		System.out.println("");
		
		System.out.println("###################################################");
		System.out.println("################## Test de Ejercicio 2 ############");
		//System.out.println("Datos de entrada --> Limite: ");
		System.out.println("###################################################");
		System.out.println("###################################################");
		System.out.println("");
		
		System.out.println("###################################################");
		System.out.println("################## Test de Ejercicio 3 ############");
		//System.out.println("Datos de entrada --> Lista de puntos: ");
		System.out.println("###################################################");
		System.out.println("###################################################");
		
	}
		
	//###################################################################################
	//###################################################################################
	//#######################		EJERCICIO 1                         #################
	//###################################################################################
	//###################################################################################
	
	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea numeros enteros separados por comas, devuelve una lista
	// formada por todos los numeros del fichero:
	public static List <Integer> leeDatosEjercicio1 (String fichero) {
		
		int i = 0;
		List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List <Integer> resultado = new ArrayList <Integer>();
		while (i < lista.size()) {
		    
			String fila = lista.get(i);
			String[] numeros = fila.split(",");
			
			//resultado.add(Integer.parseInt(numero));
			for (String numero : numeros) {
				
				resultado.add(Integer.parseInt(numero));
				
			}
			
			i++;
					    	
		}
			
		return resultado;
		  					
	}
	
	// Dada una lista, comprueba que elementos son primos y los
	// devuelve, todos, en una lista nueva como resultado:
	public static List <Integer> compruebaSiEsPrimo (List <Integer> lista) {
		
		List <Integer> resultado = new ArrayList <Integer>();
		
		for (Integer numero : lista) {
			
			if (esPrimo(numero)) {
				
				resultado.add(numero);
				
			}
			
		}

		return resultado;
		
	}
	
	// Funcion auxiliar que comprueba si un numero dado es
	// primo o no y devuelve el resultado en forma de una
	// variable logica:
	public static boolean esPrimo (Integer numero) {
		
		return true;
		
	}
	
	//###################################################################################
	//###################################################################################
	//#######################		EJERCICIO 2                         #################
	//###################################################################################
	//###################################################################################
	
	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea un concepto "Limite: numero", toma ese numero para pasarlo como
	// parametro a la funcion del ejercicio 2:
	public static List <Integer> leeDatosEjercicio2 (String fichero) {
		
		List <Integer> resultado = new ArrayList <Integer>();
		
		
		return resultado;
				
	}
	
	// Dado un numero entero, devuelve una cadena (con saltos de linea) formada por
	// todos los nº primos desde el 1 hasta el limite (numero introducido como parametro):
	public static String primosHastaLimite (Integer limite) {
		
		String resultado = "";
		
		return resultado;
		
	}
	
	//###################################################################################
	//###################################################################################
	//#######################		EJERCICIO 3                         #################
	//###################################################################################
	//###################################################################################
	
	// Funcion que lee una lista de puntos y....
	
	// Dado un punto...
			
}
