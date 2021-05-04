/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
	Una academia de ingl�s tiene n alumnos a ser repartidos en m grupos (n m�ltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo n�mero de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no est�
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Soluci�n por A*.
*/

public class Ejercicio1A {
	
	/*
	 * Variables de la clase necesarias para resolver el ejercicio. 
	*/
	private static List<String> nombres;
	private static List<List<Integer>> afinidades;

	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
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
	 * M�todo inicial para construir el grafo a partir de las propiedades extraidas de la lectura.
	*/
	
	/*
	 * M�todos auxiliares para resolver el problema. 
	*/	
	
	// Obtiene el n� de alumnos:
	private static Integer getNAlumnos() { 
		
		return nombres.size();
		
	}
	
	// Obtiene el n� de afinidades:
	private static Integer getNAfinidades() { 
		
		return afinidades.get(0).size();
		
	}
	
	// Obtiene el tama�o del reparto: alumnos / afinidades (grupos) = tama�o grupos
	private static Integer getNGrupos() {
		
		return getNAlumnos() / getNAfinidades();
		
	}

	// Obtiene la afinidad de un alumno dado el alumno (i) para el grupo (j):
	private static Integer afinidadPorIndice(Integer i, Integer j) {

		return afinidades.get(i).get(j);
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio1A(String fichero) {

		
	}
	
}
