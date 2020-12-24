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
					+ ejercicio2(conjunto) + "\n");

		}

	}

	/*
	 * Funcion que...
	 */
	private static Boolean ejercicio2(Tuple2<BinaryTree<String>, List<String>> conjunto) {

		if ((conjunto.getV1().getHeight() + 1) == conjunto.getV2().size()) {

			return true;

		} else {

			return false;

		}

	}

	/*
	 * public static Boolean realizarEjercicio(BinaryTree<String> b, List<String> l,
	 * Integer i) { Boolean base = false; Boolean hojaIzq = false; Boolean hojaDer =
	 * false; if (b.isBinary()) { if (i == l.size() - 1) { if
	 * (b.getLabel().equals(l.get(i))) { if (b.getLeft().getLabel().equals(l.get(i +
	 * 1))) { hojaIzq = realizarEjercicio(b.getLeft(), l, i + 1); } else if
	 * (b.getRight().getLabel().equals(l.get(i + 1))) { hojaDer =
	 * realizarEjercicio(b.getRight(), l, i + 1); } else { if (i == l.size() - 1) {
	 * return true; } else { return false; } } } else { return false; } } } else {
	 * return b.getLabel().equals(l.get(i)); }
	 * 
	 * return base && (hojaIzq hojaDer);
	 * 
	 * 
	 * if (i != (l.size() - 1)) { if (b.isBinary()) { if
	 * (b.getLabel().equals(l.get(i))) { return realizarEjercicio(b.getRight(), l, i
	 * + 1) realizarEjercicio(b.getLeft(), l, i + 1); } else { return false; } }
	 * else { return b.getLabel().equals(l.get(i)); } } else { return
	 * b.getLabel().equals(l.get(i)); }
	 * 
	 * }
	 */

}
