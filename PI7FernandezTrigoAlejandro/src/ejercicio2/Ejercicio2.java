/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Abogado;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
	casos relacionados entre sí (m>=n), y deben terminar dicho análisis global lo antes
	posible para lo que trabajarán en paralelo. Cada caso será analizado por un único
	abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
	horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
	tiempo puede diferir para cada caso en función de qué abogado realice el análisis).
	Determine cuál es la mejor asignación de casos a abogados para conseguir el
	objetivo indicado (terminar de analizar todos los casos lo antes posible). 
*/

public class Ejercicio2 {

	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	private static List<String> nombres;
	private static List<List<Integer>> horas;
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	*/
	public static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio2A:
		nombres = new ArrayList<String>();
		horas = new ArrayList<List<Integer>>();
		
		int i = 0;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
        	
            String linea = lista.get(i);            
            
            // Creo un objeto de tipo Abogado del cual extraer sus propiedades:
            Abogado abogado = Abogado.ofLinea(linea);
            
            nombres.add(abogado.getNombre());
            
            List<Integer> auxiliar = new ArrayList<Integer>();
            for (Integer hora : abogado.getHoras()) {
				
            	auxiliar.add(hora);
            	
			}
            
            horas.add(auxiliar);
            
            i++;
            
        }

	}
	
	/*
	 * Métodos auxiliares para resolver el problema.
	*/
	
	// Obtiene el nº de abogados:
	public static Integer getNAbogados() {

		return nombres.size();
		
	}
	
	// Obtiene el nº de horas:
	public static Integer getNCasos() {
		
		return horas.get(0).size();
		
	}
	
	// Obtiene el nº total de horas dado un abogado (i):
	public static Integer tiempoTotalPorIndice(Integer i) {
		
		int j = 0;
		Integer suma = 0;
		
		while (j < getNCasos()) {
			
			suma += tiempoPorIndice(i, j);
			j++;
			
		}
		
		return suma;
		
	}
		
	// Obtiene el tiempo de un abogado dado el abogado (i) para el caso (j):
	public static Integer tiempoPorIndice(Integer i, Integer j) {
		
		return horas.get(i).get(j);
		
	}
	
}
