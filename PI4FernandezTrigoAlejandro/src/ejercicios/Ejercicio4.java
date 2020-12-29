/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
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
import us.lsi.math.Math2;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 4 				 #################
	// ###################################################################################
	// ###################################################################################

	/*
	Funcion que lee el fichero de entrada que, por cada linea, un arbol n-ario 
	de tipo generico que se parsea y añade a la lista resultante: 
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
	Funcion auxiliar para recorrer la lista de arboles y por cada uno, mostrar dicho arbol
	por pantalla y llamar a la funcion que resuelve el ejercicio pasandole como argumento 
	la lista y el indice correspondiente al arbol a leer:
	*/
	public static void funcionAuxiliarEjercicio4(List<Tree<String>> lista) {
		
		int i = 0;
		System.out.println("\n");
		while (i < lista.size()) {
			
			System.out.println("Arbol de entrada: " + lista.get(i));
			System.out.println("Map de salida: " + ejercicio4Privado(lista, i));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			i++;
			
		}
		System.out.println("\n");
		
	}

	/*
	Funcion que llama de forma opaca al usuario a la funcion que resuelve el ejercicio
	pasandole a esta como parametros la lista de arboles y el indice que indica el arbol
	a leer:
	*/
	private static Map<Integer, List<String>> ejercicio4Privado(
			List<Tree<String>> arboles, 
			Integer arbol) {
		
        return ejercicio4(arboles, new HashMap<Integer, List<String>>(), 0, arbol);
        
    }

	/*
	Funcion que dado la lista de arboles, el mapa resultante de tipo entero y lista de string
	junto con un indice y el arbol a leer, genera un mapa cuyas claves representan los niveles
	del arbol y sus valores son listas de nodos del mismo nivel que tiene un nº par de hijos. 
	Para ello se emplea la funcion auxiliar predicado() que comprueba la validez del predicado
	(nodo binario) para cada nivel dado:
	*/
    private static Map<Integer, List<String>> ejercicio4(
    		List<Tree<String>> arboles, 
    		Map<Integer, List<String>> resultado,
            Integer i, 
            Integer arbol) {
    	
    	// Recursion:
        if (i < arboles.get(arbol).getHeight() + 1) {
        	
        	// Lista a añadir como valor del mapa para la clave i:
            List<String> lista = new ArrayList<String>();
            
            // Llamada a la funcion auxiliar predicado() con el nivel:
            lista.addAll(predicado(arboles.get(arbol).getLevel(i), 0, new ArrayList<String>()));
            
            // Añadir al mapa la clave con su valor:
            resultado.put(i, lista);
            
            // Vaciar la lista:
            lista = new ArrayList<String>();
            
            // Llamada recursiva al ejercicio incrementando el nivel:
            resultado = ejercicio4(arboles, resultado, i + 1, arbol);

        // Caso base:
        } else {
        	
            return resultado;
        }
        
        return resultado;
        
    }
    
	/*
	Funcion auxiliar que dado 
	*/
    private static List<String> predicado(
    		List<Tree<String>> l, 
    		Integer i, 
    		List<String> listaAuxiliar) {
    	
        if (i < l.size()) {
        	
            if (!l.get(i).isEmpty() && l.get(i).getNumOfChildren() != 0 && Math2.esPar(l.get(i).getNumOfChildren())) {
            	
                listaAuxiliar.add(l.get(i).getLabel());
                
            }
            
            listaAuxiliar = predicado(l, i + 1, listaAuxiliar);
            
        } else {
        	
            return listaAuxiliar;
        }
        
        return listaAuxiliar;
        
    }

}
