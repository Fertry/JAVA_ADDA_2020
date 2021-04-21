/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import us.lsi.ag.SeqNormalProblemAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.SeqNomalChromosome;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;

/*
	Se tiene un grafo cuyos v�rtices son Ciudades y sus Aristas son Carreteras, y un
	predicado sobre carreteras. Se desea saber cu�l es el camino cerrado m�s corto
	que pase por todos los v�rtices del grafo una sola vez y que contiene al menos una
	arista que cumple el predicado.
	
	Se pide solucionar por Algoritmos Gen�ticos
*/

public class Ejercicio5 implements SeqNormalProblemAG<List<Integer>> {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * AG que resuelve el ejercicio. 
	*/
	public static List<Ciudad> ciudades;
	public static List<Carretera> carreteras;
	
	/*
	 * M�todos inicializadores de la clase AG.
	*/
	public Ejercicio5(String fichero) {
		
		Ejercicio5.iniDatos(fichero);
		
	}
	
	public static Ejercicio5 AG(String fichero) {
		
		return new Ejercicio5(fichero);
		
	}
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro. Se acceder� a los datos desde la clase AG que resuelve el ejercicio.
	*/
	private static void iniDatos(String fichero) {

		// Inicializar las variables de la clase Ejercicio5:
		ciudades = new ArrayList<Ciudad>();
		carreteras = new ArrayList<Carretera>();
		
		// Creo un objeto de tipo Circuito del cual extraer sus propiedades:
		Circuito circuito = Circuito.ofFichero(fichero);

		ciudades = circuito.getCiudades();
		carreteras = circuito.getCarreteras();
		
	}

	/*
	 * M�todos auxiliares para definir las restricciones del problema y m�todos para ser usados
	 * por el algoritmo de resoluci�n. Son invocados en la clase AG5. 
	*/	
	
	// Obtiene el n� de ciudades:
	public static Integer getNCiudades() {
		
		return ciudades.size();
		
	}
	
	// Obtiene el n� de carreteras:
	public static Integer getNCarreteras() {
		
		return carreteras.size();
		
	}
	
	// Obtiene una ciudad en base un �ndice:
	public static Ciudad ciudadPorIndice(Integer i) {
		
		return ciudades.get(i);
		
	}
	
	// Obtiene una carretera en base a un �ndice:
	public static Carretera carreteraPorIndice(Integer i) {
		
		return carreteras.get(i);
		
	}
	
	// Define el tipo de cromosoma que usa el problema:
	@Override
	public ChromosomeType getType() {

		return ChromosomeType.Permutation;
		
	}

	// Define el n� de elementos del problema: N� de ciudades:
	@Override
	public Integer getIndexNumber() {

		return getNCiudades();
		
	}

	/*
	 * M�todos de Algoritmos Gen�ticos para determinar la recompensa / penalizaci�n del cromosoma
	 * seleccionado.
	*/
	
	// Funci�n de fitness que define el problema:
	@Override
	public Double fitnessFunction(SeqNomalChromosome cromosoma) {

		List<Integer> cromosomas = cromosoma.decode();

		return recompensa(cromosomas) - penalizacion(cromosomas);

	}

	// Funci�n decode:
	@Override
	public List<Integer> getSolucion(SeqNomalChromosome cromosoma) {

		return cromosoma.decode();

	}

	/*
	 * M�todo objetivo o recompensa para recompensar cromosomas que cumplan las
	 * restricciones.
	*/
	public Double recompensa(List<Integer> cromosomas) {

		Double recompensa = 0.0;

		int i = 0;
		while (i < cromosomas.size() - 1) {
		
			Ciudad origen = ciudadPorIndice(cromosomas.get(i));
			Ciudad destino = ciudadPorIndice(cromosomas.get(i + 1));
				
			if (getExistenciaCarretera(origen, destino)) {
					
				recompensa += getDistanciaCiudades(origen, destino);
				
			} else if (getExistenciaCarretera(destino, origen)) {
				
				recompensa += getDistanciaCiudades(destino, origen);
				
			} else {
				
				// Si no hay carretera, no aumenta la recompensa:
				recompensa += 0;
				
			}
			
			i++;

		}
			
		// Minimizar un problema es = -(maximizar):
		return -(recompensa);		
		
	}

	/*
	 * M�todo de "castigo" o penalizaci�n para cromosomas que no cumplen las
	 * restricciones.
	*/
	public Double penalizacion(List<Integer> cromosomas) {

		Double penalizacion = 0.0;
		
		int i = 0;
		while (i < cromosomas.size() - 1) {
		
			Ciudad origen = ciudadPorIndice(cromosomas.get(i));
			Ciudad destino = ciudadPorIndice(cromosomas.get(i + 1));
				
			if (getExistenciaCarretera(origen, destino)) {
					
				// Obtener la carretera concreta:
				Carretera carretera = getCarreteraPorCiudades(origen, destino);
			
				// Si la carretera cumple el predicado no castiga:
				if (predicado100.test(carretera)) {
					
					penalizacion += 0;
					
				} else {
					
					// De lo contrario aumenta la penalizaci�n:
					penalizacion++;
					
				}
				
			} else if (getExistenciaCarretera(destino, origen)) {
				
				// Obtener la carretera concreta:
				Carretera carretera = getCarreteraPorCiudades(destino, origen);
				
				// Si la carretera cumple el predicado no castiga:
				if (predicado100.test(carretera)) {
					
					penalizacion += 0;
					
				} else {
					
					// De lo contrario aumenta la penalizaci�n:
					penalizacion++;
					
				}
				
			} else {
				
				// Si no hay carretera, aumenta la penalizaci�n:
				penalizacion++;
				
			}
			
			i++;

		}
		
		// Valor de penalizaci�n: 100000, 120000, 150000, 80000, etc.
		return penalizacion * 120000;
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio5(String fichero) {
				
		// Soluci�n por Algoritmos Gen�ticos - Cromosoma de Permutaci�n:
		try {
			
			AG5.ejercicio5AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Algoritmos Gen�ticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

	}
	
	/*
	 * M�todos adicionales y predicados:
	 */
	
	// Devuelve la arista que existe entre dos ciudades dadas como par�metro:
	public static Carretera getCarreteraPorCiudades(Ciudad ciudad1, Ciudad ciudad2) {
		
		Carretera arista = null;

		int i = 0;
		while (i < carreteras.size()) {
			
			if (carreteras.get(i).getSource() == ciudad1 && carreteras.get(i).getTarget() == ciudad2) {
				
				arista = carreteras.get(i);
				
			}
			
			if (carreteras.get(i).getSource() == ciudad2 && carreteras.get(i).getTarget() == ciudad1) {
				
				arista = carreteras.get(i);
				
			}
			
			i++;
			
		}
		
		return arista;
		
	}
	
	// Devuelve un booleano que responde a la existencia o no de camino entre dos ciudades:
	public static Boolean getExistenciaCarretera(Ciudad ciudad1, Ciudad ciudad2) {
		
		Boolean existencia = false;

		int i = 0;
		while (i < carreteras.size()) {
			
			if (carreteras.get(i).getSource() == ciudad1 && carreteras.get(i).getTarget() == ciudad2) {
				
				existencia = true;
				
			}
			
			if (carreteras.get(i).getSource() == ciudad2 && carreteras.get(i).getTarget() == ciudad1) {
				
				existencia = true;
				
			}
			
			i++;
			
		}
		
		return existencia;
		
	}
	
	// Devuelve la distancia como doble entre dos ciudades:
	public static Double getDistanciaCiudades(Ciudad ciudad1, Ciudad ciudad2) {
		
		Double distancia = 0.0;

		int i = 0;
		while (i < carreteras.size()) {
			
			if (carreteras.get(i).getSource() == ciudad1 && carreteras.get(i).getTarget() == ciudad2) {
				
				distancia = carreteras.get(i).getKm();
				
			}
			
			if (carreteras.get(i).getSource() == ciudad2 && carreteras.get(i).getTarget() == ciudad1) {
				
				distancia = carreteras.get(i).getKm();
				
			}
			
			i++;
			
		}
		
		return distancia;
		
	}
	
	/*
	 * Predicados que se aplican al ejercicio 5: 
	 * 1. Carreteras de menos de 100 kms
	 * 2. Carreteras de m�s de 200 kms
	*/
	
	// Predicate (booleano) que se cumple si la carretera no excede los 100 Kms:
	public static Predicate<Carretera> predicado100 = new Predicate<Carretera>() {

		@Override
		public boolean test(Carretera carretera) {

			// Deber�a recibir como par�metro una arista, de la cual comprueba (booleano) si el peso
			// (kilometraje) es menor a 100 Km o no:
			return carretera.getKm() < 100;
			
		}
		
	};

	// Predicate (booleano) que se cumple si la carretera excede los 200 Kms:
	public static Predicate<Carretera> predicado200 = new Predicate<Carretera>() {

		@Override
		public boolean test(Carretera carretera) {
			
			// Deber�a recibir como par�metro una arista, de la cual comprueba (booleano) si el peso
			// (kilometraje) es mayor a 200 Km o no:
			return carretera.getKm() > 200;
			
		}
		
	};

//	private static void seleccionaPredicado(Integer seleccion) {
//		
//		if (seleccion == 1) {
//			
//			predicadoSeleccionado = predicado100;
//			
//		} else if (seleccion == 2) {
//			
//			predicadoSeleccionado = predicado200;
//			
//		} else {
//			
//			System.out.println("Se ha seleccionado un predicado incorrecto.");
//			
//		}
//		
//	}
	
}

