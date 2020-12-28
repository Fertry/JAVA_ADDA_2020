/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 4
 */

package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	* Funcion que lee...
	*/
	public static List<Tree<String>> leeDatosEjercicio4(String fichero) {

		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<Tree<String>> resultado = new ArrayList<Tree<String>>();

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
	public static void funcionAuxiliarEjercicio4(List<Tree<String>> lista) {

		for (Tree<String> arbol : lista) {

			System.out.println("Arbol de entrada: " + arbol);
			System.out.println("Map de salida: " + ejercicio4(arbol) + "\n");

		}

	}
	
	/*
	* Funcion que...
	*/
	private static Map<Integer, List<Integer>> ejercicio4(Tree<String> arbol) {
		
		Map<Integer, List<Integer>> resultado = new HashMap<Integer, List<Integer>>();
		
		return resultado;
		
	}

}
