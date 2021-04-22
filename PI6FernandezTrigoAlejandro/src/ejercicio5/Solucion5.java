/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.util.ArrayList;
import java.util.List;
import us.lsi.grafos.datos.Ciudad;

/*
 * Clase solución que pretende parsear la salida la salida de algoritmos genéticos para mostrar 
 * los resultados acordes al fichero de resultados.
*/
public class Solucion5 {
	
	// Función que dado una solución de Algoritmos Genéticos parsea la solución:
	public static void solucionAG5(String fichero, List<Integer> entrada, Integer predicado) {
		
		// La lista incluye cómo índice a las ciudades seleccionadas en el orden en el que aparecen:
		// Ej: [3, 6, 8, 0, 7, 1, 5, 4, 2]
		// Se mantiene una lista formada por las ciudades:
		
		Double kilometraje = 0.0;
		List<Ciudad> seleccion = new ArrayList<Ciudad>();
		
		int i = 0;
		while(i < entrada.size()) {
			
			Ciudad ciudad = Ejercicio5.ciudadPorIndice(entrada.get(i));
			seleccion.add(ciudad);
			
			i++;
			
		}
		
		/*
		 * Para que la lista muestre un camino cerrado, esto es, empieza y acaba en la misma ciudad, 
		 * obtengo por separado la primera ciudad del reparto y la añado al final de la lista. Si la 
		 * lista de ciudades tiene 9 ciudades, la lista final incluirá 10. 
		*/
		Ciudad destino = Ejercicio5.ciudadPorIndice(entrada.get(0));
		seleccion.add(destino);
		
		/*
		 * La distancia total, se calcula mediante el método getDistanciaCiudades de la clase Ejercicio5
		 * ya que la propiedad getKm no es observable aquí. Se pasa como parámetro dos ciudades de la
		 * selección de las que se sabe que ¡ya existe camino! y se aumenta el valor de kilometraje.
		*/
		int j = 0;
		while (j < seleccion.size() -1) {
			
			Ciudad ciudad1 = seleccion.get(j);
			Ciudad ciudad2 = seleccion.get(j + 1);
			
			// Obtener su ponderación = kilómetros:
			kilometraje += Ejercicio5.getDistanciaCiudades(ciudad1, ciudad2);
					
			j++;
			
		}
		
		// Con la lista creada, se llaa a la función que lo parsea:
		formateo(fichero, seleccion, kilometraje, predicado);
		
	}
	
	// Función que parsea la salida de solucionAG5 para mostrar el resultado por pantalla:
	private static void formateo(String nombre, List<Ciudad> seleccion, Double kilometraje, Integer predicado) {
		
		// Seleccion de predicado y coste total en kilómetros:
		String predicadoSeleccionado = compruebaPredicadoSeleccionado(predicado);		
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ALGORITMOS GENÉTICOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");
		System.out.println(predicadoSeleccionado);
		System.out.println("	Camino propuesto: " + seleccion);
		System.out.println("	Coste total: " + kilometraje + " Kms.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	// Método auxiliar que se encarga de comprobar el predicado introducido:
	private static String compruebaPredicadoSeleccionado(Integer seleccionado) {
		
		/*
		 * La llamada de algoritmos genéticos podría recibir como entrada un nº que no se corresponde a 
		 * ningún predicado, lo cual se resuelve en la clase Ejercicio5 asignando un predicado por defecto.
		 * Esta función existe para mostrar por pantalla el mensaje correspondiente al predicado seleccionado.
		*/
		
		String palabra = ""; 
		Integer numero = 0;
		
		if (seleccionado == 2) {
			
			palabra = "más ";
			numero = 200;
			
		} else {
			
			palabra = "menos ";
			numero = 100;
			
		}
		
		return "Predicado Carreteras de " + palabra + numero + " Kms:";
		
	}
		
}
