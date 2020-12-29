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
	Funcion que lee el fichero de entrada que, por cada linea, representa un arbol binario
	de tipo entero y devuelve una lista de BinaryTree tras parsearlos:
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
	Funcion auxiliar para recorrer la lista de arboles y por cada uno, mostrar dicho arbol
	por pantalla y llamar a la funcion que resuelve el ejercicio pasandole como argumento 
	dicho arbol:
	*/
	public static void funcionAuxiliarEjercicio1(List <BinaryTree<Integer>> lista) {
		
		System.out.println("\n");
		for (BinaryTree<Integer> arbol : lista) {
			
			System.out.println("Arbol de entrada: " + arbol);
			System.out.println("¿Cumple el predicado?: " + ejercicio1(arbol));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}
		System.out.println("\n");
		
	}
	
	/*
	Funcion que dado un arbol binario suma las componentes de sus hijos
	y devuelve como booleano el resultado, siendo este true cuando la suma
	de sus valores sea igual a la del padre y false en caso contrario. Para 
	ello se llama recursivamente a la funcion una vez por cada rama:
	*/
	private static Boolean ejercicio1(BinaryTree<Integer> arbol) {
		
        if (arbol.isBinary()) {
        	
            int label = arbol.getLabel();
            int izquierda = arbol.getLeft().getLabel();
            int derecha = arbol.getRight().getLabel();
            
            Boolean iguales = (izquierda + derecha) == label;
            
            return iguales && ejercicio1(arbol.getLeft()) && ejercicio1(arbol.getRight());
            
        } else {
        	
            return true;
            
        }
        
    }
    
}
