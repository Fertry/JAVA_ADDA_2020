/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 4
 */

package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	Funcion que lee el fichero de entrada que, por cada linea, un arbol n-ario 
	de tipo generico que se parsea y añade a la lista resultante: 
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

		int i = 0;
		while (i < lista.size()) {
			
			System.out.println(realizarEjercicio(lista, i));
			i++;
			
		}

	}
	
	public static Map<Integer, Set<Tree<String>>> realizarEjercicio(List<Tree<String>> trees, Integer arbol) {
        Map<Integer, Set<Tree<String>>> res = new HashMap<Integer, Set<Tree<String>>>();
        return realizarEjercicio(trees, res, 0, arbol, 0, 0);
    }

    public static Map<Integer, Set<Tree<String>>> realizarEjercicio(List<Tree<String>> trees,
            Map<Integer, Set<Tree<String>>> res, Integer c, Integer arbol, Integer i, Integer j) {
        if (i < trees.get(arbol).getHeight() + 1) {
            if (j < trees.get(arbol).getLevel(i).size()) {
                Set<Tree<String>> resSet = new HashSet<Tree<String>>();
                if (res.containsKey(trees.get(arbol).getLevel(i).get(j).getNumOfChildren())) {
                    resSet = res.get(trees.get(arbol).getLevel(i).get(j).getNumOfChildren());
                    if (!trees.get(arbol).getLevel(i).get(j).isEmpty()) {
                        resSet.add(trees.get(arbol).getLevel(i).get(j));
                    } else {
                        resSet.add(Tree.empty());
                    }
                    res.put(trees.get(arbol).getLevel(i).get(j).getNumOfChildren(), resSet);
                } else {
                    if (!trees.get(arbol).getLevel(i).get(j).isEmpty()) {
                        resSet.add(trees.get(arbol).getLevel(i).get(j));
                    } else {
                        resSet.add(Tree.empty());
                    }
                    res.put(trees.get(arbol).getLevel(i).get(j).getNumOfChildren(), resSet);
                }
                resSet = new HashSet<Tree<String>>();
                res = realizarEjercicio(trees, res, c, arbol, i, j + 1);
            }
            res = realizarEjercicio(trees, res, c, arbol, i + 1, j);
        } else {
            return res;
        }
        return res;
    }
	
}
