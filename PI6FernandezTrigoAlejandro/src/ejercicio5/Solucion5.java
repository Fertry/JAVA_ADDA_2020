/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.util.ArrayList;
import java.util.List;
import us.lsi.grafos.datos.Ciudad;

/*
 * Clase soluci�n que pretende parsear la salida la salida de algoritmos gen�ticos para mostrar 
 * los resultados acordes al fichero de resultados.
*/
public class Solucion5 {
	
	// Funci�n que dado una soluci�n de Algoritmos Gen�ticos parsea la soluci�n:
	public static void solucionAG5(String fichero, List<Integer> entrada, Integer predicado) {
		
		// La lista incluye c�mo �ndice a las ciudades seleccionadas en el orden en el que aparecen:
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
		 * obtengo por separado la primera ciudad del reparto y la a�ado al final de la lista. Si la 
		 * lista de ciudades tiene 9 ciudades, la lista final incluir� 10. 
		*/
		Ciudad destino = Ejercicio5.ciudadPorIndice(entrada.get(0));
		seleccion.add(destino);
		
		/*
		 * La distancia total, se calcula mediante el m�todo getDistanciaCiudades de la clase Ejercicio5
		 * ya que la propiedad getKm no es observable aqu�. Se pasa como par�metro dos ciudades de la
		 * selecci�n de las que se sabe que �ya existe camino! y se aumenta el valor de kilometraje.
		*/
		int j = 0;
		while (j < seleccion.size() -1) {
			
			Ciudad ciudad1 = seleccion.get(j);
			Ciudad ciudad2 = seleccion.get(j + 1);
			
			// Obtener su ponderaci�n = kil�metros:
			kilometraje += Ejercicio5.getDistanciaCiudades(ciudad1, ciudad2);
					
			j++;
			
		}
		
		// Con la lista creada, se llaa a la funci�n que lo parsea:
		formateo(fichero, seleccion, kilometraje, predicado);
		
	}
	
	// Funci�n que parsea la salida de solucionAG5 para mostrar el resultado por pantalla:
	private static void formateo(String nombre, List<Ciudad> seleccion, Double kilometraje, Integer predicado) {
		
		// Seleccion de predicado y coste total en kil�metros:
		String predicadoSeleccionado = compruebaPredicadoSeleccionado(predicado);		
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ALGORITMOS GEN�TICOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");
		System.out.println(predicadoSeleccionado);
		System.out.println("	Camino propuesto: " + seleccion);
		System.out.println("	Coste total: " + kilometraje + " Kms.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	// M�todo auxiliar que se encarga de comprobar el predicado introducido:
	private static String compruebaPredicadoSeleccionado(Integer seleccionado) {
		
		/*
		 * La llamada de algoritmos gen�ticos podr�a recibir como entrada un n� que no se corresponde a 
		 * ning�n predicado, lo cual se resuelve en la clase Ejercicio5 asignando un predicado por defecto.
		 * Esta funci�n existe para mostrar por pantalla el mensaje correspondiente al predicado seleccionado.
		*/
		
		String palabra = ""; 
		Integer numero = 0;
		
		if (seleccionado == 2) {
			
			palabra = "m�s ";
			numero = 200;
			
		} else {
			
			palabra = "menos ";
			numero = 100;
			
		}
		
		return "Predicado Carreteras de " + palabra + numero + " Kms:";
		
	}
		
}
