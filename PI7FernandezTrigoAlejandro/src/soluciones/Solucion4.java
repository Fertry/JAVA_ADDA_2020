/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package soluciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import aristas.AristaConjunto;

public class Solucion4 {
	
	/*
	 * Método público para recibir la lista de aristas resultantes de la ejecución de los algoritmos y operar sobre dicha lista.
	*/
	public static void solucion(List<AristaConjunto> entrada) {
	
		int i = 0;
		Map<Integer, List<Integer>> reparto = new HashMap<Integer, List<Integer>>();
		
		while (i < entrada.size()) {
			
			// Obtener el par de valores Elemento/Conjunto de cada arista:
			String arista = entrada.get(i).toString();
			String[] parDeValores = arista.trim().split(",");
			
			// Obtener el elemento:
			Integer elemento = Integer.parseInt(parDeValores[0].replace("(", "").trim());
		
			// Obtener el conjunto:
			Integer conjunto = Integer.parseInt(parDeValores[1].replace(")", "").trim());
			
			// Añadir al mapa el conjunto con sus elementos:
			if (reparto.containsKey(conjunto)) {

				List<Integer> listaElementos = new ArrayList<Integer>();
				listaElementos = reparto.get(conjunto);
				listaElementos.add(elemento);
				reparto.put(conjunto, listaElementos);

			} else {

				List<Integer> listaAux = new ArrayList<Integer>();
				listaAux.add(elemento);
				reparto.put(conjunto, listaAux);

			}
						
			i++;
			
		}
		
		// Mostrar los datos finales por pantalla:
		System.out.println(reparto);
		System.out.println("El menor conjunto tiene " + menorConjunto(reparto) + " elementos.\n");
		for (Integer conjunto : reparto.keySet()) {

			// Sumo 1 para que comience a contar desde 1 y no 0:
			System.out.println("Elementos del conjunto " + (conjunto + 1) + ": " + reparto.get(conjunto));
			
		}

	}
	
	// MÉTODOS PRIVADOS PARA EL FORMATEO DE LA SOLUCIÓN
	
	/*
	 * Método privado para calcular el tamaño del menor conjunto del reparto efectuado.  
	*/
	private static Integer menorConjunto(Map<Integer, List<Integer>> reparto) {
		
		Integer resultado = 0;
		Integer menor = reparto.get(0).size();
		
		for (Integer conjunto : reparto.keySet()) {
			
			Integer size = reparto.get(conjunto).size();
			if (size < menor) {
				
				menor = size;
				
			}
			
		}
		
		resultado = menor;
		
		return resultado;
		
	}

}
