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

public class Ejercicio5 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 5 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	* Funcion que lee...
	*/
	public static List<Tree<String>> leeDatosEjercicio5(String fichero) {

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
	public static void funcionAuxiliarEjercicio5(List<Tree<String>> lista) {

		for (Tree<String> arbol : lista) {

			System.out.println("Arbolito: " + arbol + "\n");

		}

	}

}
