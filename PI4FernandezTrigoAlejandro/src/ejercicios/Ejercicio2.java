/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 4
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio2 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 2 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	Funcion que lee el fichero de entrada que, por cada linea, representa un arbol binario
	de tipo string y, separado por un "#", una lista de caracteres. Devuelve una tupla 
	conteniendo el BinaryTree y la lista tras parsearlos usando split para separar ambos
	contenidos en base al regex ("#"):
	*/
	public static List<Tuple2<BinaryTree<String>, List<String>>> leeDatosEjercicio2(String fichero) {

		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<Tuple2<BinaryTree<String>, List<String>>> resultado = new ArrayList<Tuple2<BinaryTree<String>, List<String>>>();

		while (i < lista.size()) {

			// Hacer split el base al "#": 
			String fila = lista.get(i);
			String[] contenido = fila.split("#");
			
			// Parsear el contenido a la izquierda del split, 
			// correspondiente al arbol binario:
			List<String> letras = new ArrayList<String>();
			BinaryTree<String> arbol = BinaryTree.parse(contenido[0]);

			// Eliminar caracteres "[, ]" y hacer split en base a la coma:
			contenido[1] = contenido[1].replace("[", "");
			contenido[1] = contenido[1].replace("]", "");
			contenido[1] = contenido[1].replace("", "");
			String[] listaDeLetras = contenido[1].split(",");

			while (j < listaDeLetras.length) {

				letras.add(listaDeLetras[j]);
				j++;

			}

			j = 0;
			i++;

			resultado.add(Tuple.create(arbol, letras));

		}

		return resultado;

	}

	/*
	Funcion auxiliar para recorrer la lista de tuplas devuelta por la lectura y, por cada tupla, obtener sus
	valores (arbol y lista) que se muestran por pantalla y se pasan como parametros a la funcion que resuelve
	el ejercicio:
	*/
	public static void funcionAuxiliarEjercicio2(List<Tuple2<BinaryTree<String>, List<String>>> tupla) {

		System.out.println("\n");
		for (Tuple2<BinaryTree<String>, List<String>> conjunto : tupla) {

			System.out.println("Arbol de entrada: " + conjunto.getV1().toString());
			System.out.println("¿Existe camino desde la raiz para " + conjunto.getV2().toString() + "? " + ejercicio2Privado(conjunto));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		}
		System.out.println("\n");

	}

	/*
	Funcion que llama de forma opaca al usuario a la funcion que resuelve el ejercicio
	pasandole a esta como parametros los valores de la tupla ya extraidos de la misma:
	*/
	private static Boolean ejercicio2Privado(Tuple2<BinaryTree<String>, List<String>> conjunto) {
		
		BinaryTree<String> arbol = conjunto.getV1();
		List<String> lista = conjunto.getV2();
		
		return ejercicio2(arbol, lista, 0);
		
	}
	
	/*
	Funcion que dado el arbol de tipo string y una lista de strings, comprueba por cada rama si existe
	un camino donde sus caracteres (los del arbol) coinciden con los de la lista dada. Usa el índice i 
	para recorrer la lista de caracteres y se llama de forma recursiva para cada rama:
	*/
	private static Boolean ejercicio2(
			BinaryTree<String> arbol, 
			List<String> lista, 
			Integer i) {
		
		// Recursividad:
		if (arbol.isBinary()) {
			
			return arbol.getLabel().equals(lista.get(i)) && (ejercicio2(arbol.getLeft(), lista, i + 1) || ejercicio2(arbol.getRight(), lista, i + 1));

		// Caso base:
		} else {
			
			if (i == lista.size() - 1) {
				
				return arbol.getLabel().equals(lista.get(i));
				
			} else {
				
				return false;
				
			}
			
		}

	}

}
