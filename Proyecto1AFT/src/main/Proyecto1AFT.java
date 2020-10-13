/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 1
 */

package main;

// Librerias:
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.math.Math2;

public class Proyecto1AFT {
	
	// Funcion principal:
	public static void main(String[] args) {
		
		// Variables:
		List <List <Integer> > listaEnteros = leeDatosEjercicio1("Tests/PI1Ej1DatosEntrada.txt");
		List <Integer> resultadoEjercicio1 = compruebaSiEsPrimo(listaEnteros);
		List <Integer> listaLimites = leeDatosEjercicio2("Tests/PI1Ej2DatosEntrada.txt");
		//String resultadoEjercicio2 = primosHastaLimite(numeroDeMierda);
		
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
		System.out.println("Datos de entrada --> Lista de limites: ");
		System.out.println(listaLimites);
		System.out.println("Resultado del ejercicio 2 --> Cuadrado de primos: ");
		//System.out.println(resultadoEjercicio2.toString());
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
	// y en cada linea numeros enteros separados por comas, devuelve una lista de listas
	// formadas por los numeros del fichero:
	public static List <List <Integer> > leeDatosEjercicio1 (String fichero) {
		
		int i = 0;
		int j = 0;
        List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
        List <List <Integer> > resultado = new ArrayList<>();
       
        while (i < lista.size()) {
        	
            String fila = lista.get(i);
            String[] numeros = fila.split(", ");
            List <Integer> miniLista = new ArrayList<>();
            
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
	
	// Dada una lista, comprueba que elementos son primos y los
	// devuelve, todos, en una lista nueva como resultado:
	public static List <Integer> compruebaSiEsPrimo (List <List <Integer> > lista) {
		
		int i = 0;
		int j = 0;
		List <Integer> resultado = new ArrayList <Integer>();
		
		while (i < lista.size()) {			
			while (j < lista.get(i).size()) {
				
				if (Math2.esPrimo(lista.get(i).get(j))) {
					
					resultado.add(lista.get(i).get(j));
					
				}
				
				j++;
			
			}
			
			j = 0;
			i++;
			
		}
			
		return resultado;
		
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
		
		int i = 0;
		List <Integer> resultado = new ArrayList <Integer>();
		List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {
			
            String fila = lista.get(i);
            String numero = fila.replace("Limite:", "");
            resultado.add(Integer.parseInt(numero));
            i++;
			
		}
		
		return resultado;
				
	}
	
	// Dado un numero entero, devuelve una cadena (con saltos de linea) formada por
	// todos los nº primos (al cuadrado) desde el 1 hasta el limite (numero introducido como parametro):
	public static String primosHastaLimite (Integer limite) {
		
		int i = 0;
		Integer cuadrado = 0;
		String resultado = new String();
		
		while (i < limite + 1) {
			
			if (Math2.siguientePrimo(i) < limite + 1) {
				
				//cuadrado = (int) Math.pow(Math2.siguientePrimo(i), 2);
				resultado = resultado + cuadrado.toString() + "\n";
				
			}
			
			// El iterador pasa al siguiente primo
			i = Math2.siguientePrimo(i);
			
		}
		
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
