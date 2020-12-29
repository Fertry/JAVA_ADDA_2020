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
import us.lsi.math.Math2;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio3 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 3 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	Funcion que lee el fichero de entrada que, por cada linea, un arbol n-ario 
	de tipo generico que se parsea y añade a la lista resultante: 
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
	Funcion que llama a las funciones encargadas de comprobar el predicado 
	para cada arbol de la lista devuelta por la lectura. Se recorre dicha lista 
	dos veces, una para para cada predicado, y se muestra por pantalla el arbol
	de entrada a la vez que se usa el indice como parametro para la funcion que
	resuelve el ejercicio:
	*/
	public static void funcionAuxiliarEjercicio3(List <Tree<String>> lista) {
		
		int i = 0;
		System.out.println("\n");
		System.out.println("============================= Predicado par =============================");
		while (i < lista.size()){
			
			System.out.println("Arbol de entrada: " + lista.get(i));
			System.out.println("¿Cumple el predicado? " + ejercicioPredicadoPar(lista, i));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			i++;
			
		}
		System.out.println("\n");
		
		int j = 0;
		System.out.println("============================= Predicado primo =============================");
		while (j < lista.size()) {
			
			System.out.println("Arbol de entrada: " + lista.get(j));
			System.out.println("¿Cumple el predicado? " + ejercicioPredicadoPrimo(lista, j));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			j++;
			
		}
		System.out.println("\n");
		
	}

	/*
	Llamada opaca al usuario de la comprobacion del predicado par para una lista de arboles,
	dado dicha lista y el indice que corresponde al arbol que hay que leer, se le pasan la 
	lista resultante y dos listas auxiliares:
	*/
	private static List<Boolean> ejercicioPredicadoPar(List<Tree<String>> arboles, Integer arbol) {
		
		List<Boolean> resultado = new ArrayList<Boolean>();
		List<Boolean> booleanos = new ArrayList<Boolean>();
		List<Tree<String>> niveles = new ArrayList<Tree<String>>();
		
		return funcionAuxiliarPredicadoPar(arboles, resultado, niveles, booleanos, 0, arbol);
			
	}
	
	/*
	Llamada opaca al usuario de la comprobacion del predicado primo para una lista de arboles,
	dado dicha lista y el indice que corresponde al arbol que hay que leer, se le pasan la 
	lista resultante y dos listas auxiliares:
	*/
	private static List<Boolean> ejercicioPredicadoPrimo(List<Tree<String>> arboles, Integer arbol) {
		
		List<Boolean> resultado = new ArrayList<Boolean>();
		List<Boolean> booleanos = new ArrayList<Boolean>();
		List<Tree<String>> niveles = new ArrayList<Tree<String>>();
		
		return funcionAuxiliarPredicadoPrimo(arboles, resultado, niveles, booleanos, 0, arbol);
			
	}
	
	/*
	Funcion que dado la lista de arboles, las listas auxiliares y el indice correspondiente al
	arbol a leer, comprueba para cada nivel si toodos los elementos del nivel verifican el 
	predicado esPar en ese nivel y devuelve una lista de tantos elementos como niveles tenga 
	el arbol con valores booleanos correspondientes a la verificacion o no del predicado en ese 
	nivel. Para ello hace uso de una funcion auxiliar llamada predicadoPar():
	*/
	private static List<Boolean> funcionAuxiliarPredicadoPar(
			List<Tree<String>> arboles, 
			List<Boolean> resultado, 
			List<Tree<String>> nivel, 
			List<Boolean> lista, 
			Integer i, 
			Integer arbol) {
		
		if (i < arboles.get(arbol).getHeight() + 1) {
			
			nivel = arboles.get(arbol).getLevel(i);
			resultado.add(predicadoPar(nivel, 0, true));
			resultado = funcionAuxiliarPredicadoPar(arboles, resultado, nivel, lista, i + 1, arbol);
			
		} 
			
		return resultado;
	
	}
	
	/*
	Funcion que dado la lista de arboles, las listas auxiliares y el indice correspondiente al
	arbol a leer, comprueba para cada nivel si toodos los elementos del nivel verifican el 
	predicado esPrimo en ese nivel y devuelve una lista de tantos elementos como niveles tenga 
	el arbol con valores booleanos correspondientes a la verificacion o no del predicado en ese 
	nivel. Para ello hace uso de una funcion auxiliar llamada predicadoPrimo():
	*/
	private static List<Boolean> funcionAuxiliarPredicadoPrimo(
			List<Tree<String>> arboles, 
			List<Boolean> resultado, 
			List<Tree<String>> nivel, 
			List<Boolean> lista, 
			Integer i, 
			Integer arbol) {
		
		if (i < arboles.get(arbol).getHeight() + 1) {
			
			nivel = arboles.get(arbol).getLevel(i);
			resultado.add(predicadoPrimo(nivel, 0, true));
			resultado = funcionAuxiliarPredicadoPrimo(arboles, resultado, nivel, lista, i + 1, arbol);
			
		} 
			
		return resultado;
	
	}
	
	// Predicado 1: predicado sobre enteros que devuelve cierto cuando el entero es par.
	/*
	Funcion que comprueba, dado un nivel de un arbol n-ario, de forma recursiva, que todos
	los elementos del nivel verifican el predicado esPar usando la libreria Math2 y devuelve
	el resultado como booleano:
	*/
	private static Boolean predicadoPar(
			List<Tree<String>> arboles, 
			Integer i, 
			Boolean resultado) {
		
		if (i < arboles.size()) {
			
			if (!arboles.get(i).isEmpty()) {
				
				resultado = resultado && Math2.esPar(Integer.parseInt(arboles.get(i).getLabel()));
				
			}
				
			resultado = predicadoPar(arboles, i + 1, resultado);
				
		} else {
			
			return resultado;
			
		}
		
		return resultado;
		
	}
	
	// Predicado 2: predicado sobre enteros que devuelve cierto cuando el entero es primo.
	/*
	Funcion que comprueba, dado un nivel de un arbol n-ario, de forma recursiva, que todos
	los elementos del nivel verifican el predicado esPrimo usando la libreria Math2 y devuelve
	el resultado como booleano:
	*/
	private static Boolean predicadoPrimo(
			List<Tree<String>> arboles, 
			Integer i, 
			Boolean resultado) {
		
		if (i < arboles.size()) {

			if (!arboles.get(i).isEmpty()) {

				resultado = resultado && Math2.esPrimo(Integer.parseInt(arboles.get(i).getLabel()));

			} 

			resultado = predicadoPrimo(arboles, i + 1, resultado);

		} else {

			return resultado;

		}

		return resultado;
		
	}
	
}
