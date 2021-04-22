/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.ag.agchromosomes.ValuesInRangeChromosome;

/*
	Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
	casos relacionados entre sí (m>=n), y deben terminar dicho análisis global lo antes
	posible para lo que trabajarán en paralelo. Cada caso será analizado por un único
	abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
	horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
	tiempo puede diferir para cada caso en función de qué abogado realice el análisis).
	Determine cuál es la mejor asignación de casos a abogados para conseguir el
	objetivo indicado (terminar de analizar todos los casos lo antes posible).
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio2AG implements ValuesInRangeProblemAG<Integer, List<Integer>> {

	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * AG que resuelve el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<List<Integer>> horas;
	
	/*
	 * Métodos inicializadores de la clase AG.
	*/
	private Ejercicio2AG(String fichero) {
		
		Ejercicio2AG.iniDatos(fichero);
		
	}
	
	public static Ejercicio2AG AG(String fichero) {
		
		return new Ejercicio2AG(fichero);
		
	}
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde la clase AG que resuelve el ejercicio.
	*/
	private static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio2AG:
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
	 * Métodos auxiliares para definir las restricciones del problema y métodos para ser usados
	 * por el algoritmo de resolución. Son invocados en la clase AG2. 
	*/	
	
	// Obtiene el nº de abogados:
	private static Integer getNAbogados() {

		return nombres.size();

	}

	// Obtiene el nº de horas:
	private static Integer getNHoras() {

		return horas.get(0).size();

	}

	// Obtiene el tiempo de un abogado dado el abogado (i) para el caso (j):
	public static Integer tiempoPorIndice(Integer i, Integer j) {

		return horas.get(i).get(j);

	}
	
	// Define el tipo de cromosoma que usa el problema: 
	@Override
	public ChromosomeType getType() {
		
		return ChromosomeType.Range;
		
	}

	// Define el nº de elementos del problema: Nº de casos:
	@Override
	public Integer getCellsNumber() {

		return getNHoras();
		
	}

	// Define el límite superior del problema: Nº de abogados:
	@Override
	public Integer getMax(Integer i) {

		return getNAbogados();
		
	}

	// Devuelve el límite inferior del problema: siempre 0:
	@Override
	public Integer getMin(Integer i) {
		
		return 0;
		
	}

	/*
	 * Métodos de Algoritmos Genéticos para determinar la recompensa / penalización del cromosoma
	 * seleccionado.
	*/
	
	// Función de fitness que define el problema: 
	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cromosoma) {
		
		List<Integer> cromosomas = cromosoma.decode();
		
		return recompensa(cromosomas) - penalizacion(cromosomas);
		
	}

	// Función decode:
	@Override
	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> cromosoma) {
		
		return cromosoma.decode();
		
	}
	
	/*
	 * Método objetivo o recompensa para recompensar cromosomas que cumplan las restricciones.
	*/
	private Double recompensa(List<Integer> cromosomas) {
		
		Double recompensa = 0.0;
		Map<Integer, Double> cromosomasConHoras = calculaCromosomasConHoras(cromosomas);
		
		// min max(tiempoPorIndice(i, j))
		for (Integer abogado : cromosomasConHoras.keySet()) {
			
			// Recorrer el sumatorio del tiempo por abogados:
			if (cromosomasConHoras.get(abogado) > recompensa) {
					
				recompensa = cromosomasConHoras.get(abogado);
					
			}
			
		}

		// Minimizar un problema es = -(maximizar):
		return -(recompensa);

	}
	
	/*
	 * Método de "castigo" o penalización para cromosomas que no cumplen las restricciones.
	*/
	private Double penalizacion(List<Integer> cromosomas) {
		
		Double penalizacion = 0.0;
		
		int i = 0;
		while (i < cromosomas.size()) {
			
			/*
			 * Primera restricción del problema:
			 * sum(x[i, j], i in 0 .. abogados) = 1, j in 0 .. casos 
			*/
			if (cromosomas.get(i) >= getCellsNumber()) {
				
				penalizacion++;
				
			}
			
			/*
			 * Segunda restricción del problema:
			 * sum(tiempoPorIndice(i, j) x[i, j], j in 0 .. casos) - t[0] <= 0, i in 0 .. abogados
			*/
			if (cromosomas.get(i) < 0) {
				
				penalizacion++;
				
			}
			
			i++;
			
		}
		
		// Valor de penalización: 100000, 120000, 150000, 80000, etc.
		return penalizacion * 150000;
		
	}

	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio2AG(String fichero) {
		
		// Solución por Algoritmos Genéticos - Cromosoma de rango:
		try {

			AG2.ejercicio2AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Algoritmos Genéticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}
		
	}
	
	/*
	 * Métodos adicionales. 
	*/
	
	// Método que guarda los abogados (cromosomas) junto a su sumatorio de horas para determinar el mayor:
	private static Map<Integer, Double> calculaCromosomasConHoras(List<Integer> cromosomas) {
		
		Integer abogado = 0;
		Double sumatorio = 0.0;
		Map<Integer, Double> resultado = new HashMap<Integer, Double>();
		
		int i = 0;
		while(i < cromosomas.size()) {
			
			if(resultado.containsKey(cromosomas.get(i))) {
				
				// Obtener el abogado:
				abogado = cromosomas.get(i);
				
				// Obtener el tiempo del mapa para ese abogado:
				sumatorio = resultado.get(abogado);
				
				// Calcular el tiempo para dicho abogado y sumarlo al mapa:
				resultado.put(abogado, sumatorio + tiempoPorIndice(abogado, i));
				
			} else {
				
				// Obtener el abogado:
				abogado = cromosomas.get(i);
				
				// Calcular el tiempo para dicho abogado y sumarlo al mapa:
				resultado.put(abogado, sumatorio + tiempoPorIndice(abogado, i));
				
			}
			
			i++;
			
		}
		
		return resultado;
		
	}
	
}
