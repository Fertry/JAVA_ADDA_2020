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
		List<Tree<String>> resultado = new ArrayList<Tree<String>>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		while (i < lista.size()) {

			String fila = lista.get(i);
			Tree<String> arbol = Tree.parse(fila);
			resultado.add(arbol);
			i++;

		}

		return resultado;

	}

	/*
	Funcion auxiliar para recorrer la lista de arboles y por cada uno, mostrar dicho arbol
	por pantalla y llamar a la funcion que resuelve el ejercicio pasandole como argumento 
	la lista y el indice correspondiente al arbol a leer:
	*/
	public static void funcionAuxiliarEjercicio5(List<Tree<String>> lista) {

		int i = 0;
		System.out.println("\n");
		while (i < lista.size()) {
			
			System.out.println("Arbol de entrada: " + lista.get(i));
			System.out.println("Map de salida: " + ejercicio5Privado(lista, i));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			i++;
			
		}
		System.out.println("\n");

	}
	
	/*
	Funcion que llama de forma opaca al usuario a la funcion que resuelve el ejercicio
	pasandole a esta como parametros la lista de arboles y el indice que indica el arbol
	a leer. Ademas, se le pasa como parametro un mapa de tipo Integer, Set<Tree<String>>
	que corresponde al mapa a devolver:
	*/
	private static Map<Integer, Set<Tree<String>>> ejercicio5Privado(
			List<Tree<String>> arboles, 
			Integer arbol) {
		
        Map<Integer, Set<Tree<String>>> resultado = new HashMap<Integer, Set<Tree<String>>>();
        
        return ejercicio5(arboles, arbol, 0, 0, resultado);
        
    }
	
	/*
	Funcion que dado un arbol n-ario (lista de arboles e indice del arbol a leer), 
	devuelve un mapa de tipo Integer, Set<Tree<String>> donde las claves representan
	el nº de hijos del arbol y sus valores son un Set de arboles que contienen 
	ese mismo nº de hijos. Es decir, asociado a la clave 0, estaran los arboles cuyo
	nº de hijos sea 0, asociado a la clave 1, estaran los arboles cuyo nº de hijos 
	sea 1, etc:
	*/
    private static Map<Integer, Set<Tree<String>>> ejercicio5(
    		List<Tree<String>> arboles,
            Integer arbol, 
            Integer i, 
            Integer j,
            Map<Integer, Set<Tree<String>>> resultado) {
    	
    	// Altura del arbol:
        if (i < arboles.get(arbol).getHeight() + 1) {
        	
        	// Anchura del arbol (nivel):
            if (j < arboles.get(arbol).getLevel(i).size()) {
            	
            	// Conjunto vacio de tipo Tree:
                Set<Tree<String>> conjunto = new HashSet<Tree<String>>();
                
                // Si el conjunto ya contiene la clave:
                if (resultado.containsKey(arboles.get(arbol).getLevel(i).get(j).getNumOfChildren())) {
                	
                	conjunto = resultado.get(arboles.get(arbol).getLevel(i).get(j).getNumOfChildren());
                    
                	// Si el arbol NO es vacio:
                    if (!arboles.get(arbol).getLevel(i).get(j).isEmpty()) {
                    	
                    	conjunto.add(arboles.get(arbol).getLevel(i).get(j));
                    
                    // Si el arbol SI es vacio:
                    } else {
                    	
                    	conjunto.add(Tree.empty());
                        
                    }
                    
                    // Añadir al mapa resultado la clave (nº hijos) + el set de arboles:
                    resultado.put(arboles.get(arbol).getLevel(i).get(j).getNumOfChildren(), conjunto);
                
                // Si el conjunto no contiene la clave:
                } else {
                	
                	// Si el arbol NO es vacio:
                    if (!arboles.get(arbol).getLevel(i).get(j).isEmpty()) {
                    	
                    	conjunto.add(arboles.get(arbol).getLevel(i).get(j));
                      
                    // Si el arbol SI es vacio:	
                    } else {
                    	
                    	conjunto.add(Tree.empty());
                        
                    }
                    
                    // Añadir al mapa resultado la clave (nº hijos) + el set de arboles:
                    resultado.put(arboles.get(arbol).getLevel(i).get(j).getNumOfChildren(), conjunto);
                    
                }
                
                // Vaciar el set:
                conjunto = new HashSet<Tree<String>>();
                
                // Recursion: siguiente nivel:
                int indice = j + 1;
                resultado = ejercicio5(arboles, arbol, i, indice, resultado);
                
            }

            // Recursion: siguiente arbol:
            int indice = i + 1;
            resultado = ejercicio5(arboles, arbol, indice, j, resultado);

        // Caso base: si no entramos en el if, se devuelve el set vacio:
        } else {
        	
            return resultado;
            
        }
        
        return resultado;
        
    }
	
}
