/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.ValuesInRangeChromosome;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio1AG implements ValuesInRangeProblemAG<Integer, List<Integer>> {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * AG que resuelve el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<List<Integer>> afinidades;

	/*
	 * Métodos inicializadores de la clase AG.
	*/
	private Ejercicio1AG(String fichero) {
		
		Ejercicio1AG.iniDatos(fichero);
		
	}
	
	public static Ejercicio1AG AG(String fichero) {
		
		return new Ejercicio1AG(fichero);
		
	}
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde la clase AG que resuelve el ejercicio.
	*/
	private static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio1AG:
		nombres = new ArrayList<String>();
		afinidades = new ArrayList<List<Integer>>();
		
		int i = 0;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
        	
            String linea = lista.get(i);            
            
            // Creo un objeto de tipo Alumno del cual extraer sus propieades:
            Alumno alumno = Alumno.ofLinea(linea);
            
            nombres.add(alumno.getNombre());
            
            List<Integer> auxiliar = new ArrayList<Integer>();
            for (Integer afinidad : alumno.getAfinidades()) {
            	
            	auxiliar.add(afinidad);
            	
            }
            
            afinidades.add(auxiliar);
            
            i++;
            
        }

	}
	
	/*
	 * Métodos auxiliares para definir las restricciones del problema y métodos para ser usados
	 * por el algoritmo de resolución. Son invocados en la clase AG1. 
	*/	
	
	// Obtiene el nº de alumnos:
	public static Integer getNAlumnos() { 
		
		return nombres.size();
		
	}
	
	// Obtiene el nº de afinidades:
	private static Integer getNAfinidades() { 
		
		return afinidades.get(0).size();
		
	}
	
	// Obtiene el tamaño del reparto: alumnos / afinidades (grupos) = tamaño grupos
	private static Integer getNGrupos() {
		
		return getNAlumnos() / getNAfinidades();
		
	}

	// Obtiene la afinidad de un alumno dado el alumno (i) para el grupo (j):
	public static Integer afinidadPorIndice(Integer i, Integer j) {

		return afinidades.get(i).get(j);
		
	}
	
	// Define el tipo de cromosoma que usa el problema: 
	@Override
	public ChromosomeType getType() {
		
		return ChromosomeType.Range;
		
	}

	// Define el nº de elementos del problema: Nº de alumnos:
	@Override
	public Integer getCellsNumber() {

		return getNAlumnos();
		
	}

	// Define el límite superior del problema: Nº de grupos:
	@Override
	public Integer getMax(Integer i) {
		
		return Ejercicio1AG.getNGrupos();
		
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
		
		int i = 0;
		while (i < cromosomas.size()) {
			
			// max sum(afinidadPorIndice(i, j) x[i, j], i in 0 .. alumnos, j in 0 .. afinidades)
			recompensa += Ejercicio1AG.afinidadPorIndice(i, cromosomas.get(i));
			i++;
			
		}
		
		return recompensa;
		
	}

	/*
	 * Método de "castigo" o penalización para cromosomas que no cumplen las restricciones.
	*/
	private Double penalizacion(List<Integer> cromosomas) {
		
		Double penalizacion = 0.0;
		Map<Integer, Integer> auxiliar = new HashMap<Integer, Integer>();
		
		/*
		 * Primera restricción del problema:
		 * sum(x[i, j], j in 0 .. afinidades) = 1, i in 0 .. alumnos 
		*/
		int i = 0;
		while(i < cromosomas.size()) {
			
			// Si el valor es 0, aumenta el castigo:
			if (Ejercicio1AG.afinidadPorIndice(i, cromosomas.get(i)) == 0) {
				
				penalizacion++;
				
			}
			
			// Si el mapa contiene el cromosoma, obtengo su valor y lo añado al mapa:
			if (auxiliar.containsKey(cromosomas.get(i))) {
				
				auxiliar.put(cromosomas.get(i), (auxiliar.get(cromosomas.get(i))) + 1);
				
			} else {
				
				auxiliar.put(cromosomas.get(i), 1);
				
			}
			
			i++;
			
		}
		
		/*
		 * Segunda restricción del problema:
		 * sum(x[i, j], i in 0 .. alumnos | afinidadPorIndice(i, j) > 0) = nGrupos, j in 0 .. afinidades 
		*/
		for (int cromosoma : auxiliar.keySet()) { 
			
			// alumnos | afinidadPorIndice(i, j)
			Integer valor = Ejercicio1AG.getNAlumnos() / Ejercicio1AG.getNAfinidades();
			
			// Si el valor del cromosoma != alumnos | afinidadPorIndice(i, j), aumenta el castigo:
			if (auxiliar.get(cromosoma) != valor) {
				
				penalizacion++;
				
			}
			
		}
		
		// Valor de penalización: 100000, 120000, 150000, 80000, etc.
		return penalizacion * 120000;
		
	}

	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio1AG(String fichero) {
		
		// Solución por Algoritmos Genéticos - Cromosoma de rango:
		try {

			AG1.ejercicio1AG(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Algoritmos Genéticos ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}
		
	}

}
