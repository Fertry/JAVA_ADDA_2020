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
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {
	
	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 1 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	Funcion que lee...
	*/
	public static List <BinaryTree<Integer>> leeDatosEjercicio1(String fichero) {
		
		int i = 0;
		List <String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List <BinaryTree<Integer>> resultado = new ArrayList<BinaryTree<Integer>>();
		
		while (i < lista.size()) {
			
			BinaryTree<Integer> arbol = BinaryTree.parse(lista.get(i), s -> Integer.parseInt(s));
			resultado.add(arbol);
			i++;
			
		}
		
		return resultado;
		
	}
	
	/*
	Funcion que...
	*/
	public static void funcionAuxiliarEjercicio1(List <BinaryTree<Integer>> lista) {
		
		for (BinaryTree<Integer> arbol : lista) {
			
			System.out.println("Arbol de entrada: " + arbol);
			System.out.println("¿Cumple el predicado?: " + ejercicio1(arbol) + "\n");
			
		}
		
	}
	
	/*
	Funcion que...
	*/
	private static Boolean ejercicio1(BinaryTree<Integer> arbol) {
		
        if (arbol.isBinary()) {
        	
            int label = arbol.getLabel();
            int left = arbol.getLeft().getLabel();
            int right = arbol.getRight().getLabel();
            
            Boolean sonIguales = (left + right) == label;
            
            return sonIguales && ejercicio1(arbol.getLeft()) && ejercicio1(arbol.getRight());
            
        } else {
        	
            return true;
            
        }
        
    }
    
}
