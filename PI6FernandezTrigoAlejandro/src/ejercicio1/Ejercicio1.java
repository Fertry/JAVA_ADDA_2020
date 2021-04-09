/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Una academia de ingl�s tiene n alumnos a ser repartidos en m grupos (n m�ltiplo
	de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
	afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
	rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
	todos los grupos deben tener el mismo n�mero de alumnos, maximizando la
	afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no est�
	permitido asignar un alumno a un grupo para el que presente afinidad 0.
	
	Se piden soluciones por Programaci�n Lineal y Algoritmos Gen�ticos
*/

public class Ejercicio1 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por las clases
	 * PL y AG que resuelven el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<List<Integer>> afinidades;

	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde las clases PL y AG que resuelven el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		afinidades = new ArrayList<List<Integer>>();
		nombres = new ArrayList<String>();
		
		int i = 0;
        List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());

        while (i < lista.size()) {
        	
            String linea = lista.get(i);            
            create(linea);
            i++;
            
        }

	}
	
	public static void create(String s) {
		
		String[] contenido = s.split(": ");
		String nombre2 = contenido[0];
		String[] numeros = contenido[1].split(",");

		List<Integer> afinidadesAux = new ArrayList<Integer>();
		
		for (String numero : numeros) {
			
			afinidadesAux.add(Integer.parseInt(numero));
			
		}

		nombres.add(nombre2);
		afinidades.add(afinidadesAux);
		
	}
	
	/*
	 * M�todos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	
	// Obtiene el n� de alumnos:
	public static Integer getNAlumnos() { 
		
		return nombres.size();
		
	}
	
	// Obtiene el n� de afinidades:
	public static Integer getNAfinidades() { 
		
		return afinidades.get(0).size();
		
	}
	
	// Obtiene el tama�o del reparto: alumnos / afinidades (grupos) = tama�o grupos
	public static Integer getSizeGrupos() {
		
		return getNAlumnos() / getNAfinidades();
		
	}

	// Obtiene la afinidad de un alumno dado el alumno (i) para el grupo (j):
	public static Integer afinidadPorIndice(Integer i, Integer j) {

		return afinidades.get(i).get(j);
		
	}

	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio1(String fichero) {

		// Soluci�n por Programaci�n Lineal:
		try {

			LP1.ejercicio1LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			//e.printStackTrace();

		}
		
		// Soluci�n por Algoritmos Gen�ticos:
//		try {
//
//			PL.ejercicio1LP();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal");
//			e.printStackTrace();
//
//		}
		
	}
	
}
