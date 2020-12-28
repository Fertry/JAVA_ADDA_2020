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
	// ####################### EJERCICIO 2 #################
	// ###################################################################################
	// ###################################################################################

	/*
	* Funcion que lee...
	*/
	public static List<Tuple2<BinaryTree<String>, List<String>>> leeDatosEjercicio2(String fichero) {

		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<Tuple2<BinaryTree<String>, List<String>>> resultado = new ArrayList<Tuple2<BinaryTree<String>, List<String>>>();

		while (i < lista.size()) {

			String fila = lista.get(i);
			String[] contenido = fila.split("#");
			List<String> letras = new ArrayList<String>();
			BinaryTree<String> arbol = BinaryTree.parse(contenido[0]);

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
	* Funcion que...
	*/
	public static void funcionAuxiliarEjercicio2(List<Tuple2<BinaryTree<String>, List<String>>> tupla) {

		for (Tuple2<BinaryTree<String>, List<String>> conjunto : tupla) {

			System.out.println("Arbol de entrada: " + conjunto.getV1().toString());
			System.out.println("¿Existe camino desde la raiz para " + conjunto.getV2().toString() + "? "
					+ ejercicio2Privado(conjunto) + "\n");

		}

	}

	/*
	* Funcion que...
	*/
	private static Boolean ejercicio2Privado(Tuple2<BinaryTree<String>, List<String>> conjunto) {
		
		BinaryTree<String> arbol = conjunto.getV1();
		List<String> lista = conjunto.getV2();
		
		return ejercicio2(arbol, lista, 0);
		
	}
	
	/*
	* Funcion que...
	*/
	private static Boolean ejercicio2(BinaryTree<String> arbol, List<String> lista, Integer i) {
		
		if (arbol.isBinary()) {
			
			return arbol.getLabel().equals(lista.get(i)) && (ejercicio2(arbol.getLeft(), lista, i +1) || ejercicio2(arbol.getRight(), lista, i + 1));
			
		} else {
			
			if (i == lista.size() - 1) {
				
				return arbol.getLabel().equals(lista.get(i));
				
			} else {
				
				return false;
				
			}
			
		}

	}

}
