/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Alumno;
import us.lsi.flujossecuenciales.StreamsS;

/*
	Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo número de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Solución por A*.
*/

public class Ejercicio1A {
	
	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	private static List<String> nombres;
	private static List<List<Integer>> afinidades;

	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	*/
	private static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio1A:
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
	 * Método inicial para construir el grafo a partir de las propiedades extraidas de la lectura.
	*/
	
	/*
	 * Métodos auxiliares para resolver el problema. 
	*/	
	
	// Obtiene el nº de alumnos:
	private static Integer getNAlumnos() { 
		
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
	private static Integer afinidadPorIndice(Integer i, Integer j) {

		return afinidades.get(i).get(j);
		
	}
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio1A(String fichero) {

		
	}
	
}
