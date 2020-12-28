/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 4
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio3 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 3 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	* Funcion que lee...
	*/
	public static List <Tree<String>> leeDatosEjercicio3(String fichero) {
		
		int i = 0;
		List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List <Tree<String>> resultado = new ArrayList<Tree<String>>();
		
		while (i < lista.size()) {
			
			String fila = lista.get(i);
			Tree<String> arbol = Tree.parse(fila);
			resultado.add(arbol);
			i++;
			
		}
		
		return resultado;
		
	}
	
	/*
	* Funcion que...
	*/
	public static void funcionAuxiliarEjercicio3(List <Tree<String>> lista) {
		
		System.out.println("############### Predicado Par ###############");
		for (Tree<String> arbol : lista) {
			
			funcionAuxiliarEjercicio3Par(arbol);
			
		}
		
		System.out.println("############### Predicado Primo ##############");
		for (Tree<String> arbol : lista) {
			
			funcionAuxiliarEjercicio3Primo(arbol);
			
		}
		
	}

	/*
	* Funcion que...
	*/
	private static void funcionAuxiliarEjercicio3Par(Tree<String> arbol) {
		
		System.out.println("Arbol de entrada: " + arbol);
		System.out.println("¿Cumple el predicado? " + predicadoPar(arbol) + "\n");
			
	}
	
	/*
	* Funcion que...
	*/
	private static void funcionAuxiliarEjercicio3Primo(Tree<String> arbol) {
		
		System.out.println("Arbol de entrada: " + arbol);
		System.out.println("¿Cumple el predicado? " + predicadoPrimo(arbol) + "\n");
			
	}
	
	// Predicado 1: predicado sobre enteros que devuelve cierto cuando el entero es par.
	/*
	* Funcion que...
	*/
	private static List<Boolean> predicadoPar(Tree<String> arbol) {
		
		return null;
		
	}
	
	// Predicado 2: predicado sobre enteros que devuelve cierto cuando el entero es primo.
	/*
	* Funcion que...
	*/
	private static List<Boolean> predicadoPrimo(Tree<String> arbol) {
		
		return null;
		
	}
	
}
