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

import ejercicio1.Alumno;
import ejercicio1.Ejercicio1;
import ejercicio1.LP1;
import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.gurobi.GurobiLp;
import us.lsi.solve.AuxGrammar;

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

public class Ejercicio2 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por las clases
	 * PL y AG que resuelven el ejercicio. 
	*/
	public static List<String> abogados;
	public static List<List<Integer>> horas;
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde las clases PL y AG que resuelven el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		horas = new ArrayList<List<Integer>>();
		abogados = new ArrayList<String>();
		
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
		String nombre = contenido[0];
		String[] horas = contenido[1].split(",");
		
		List<Integer> aux = new ArrayList<Integer>();
		List<Integer> listaHoras = new ArrayList<Integer>();
		
		for (String numero : horas) {
						
			listaHoras.add(Integer.parseInt(numero));
						
		}
		
		abogados.add(nombre);
		
	}

	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio2(String fichero) {
		

		// Solución por Programación Lineal:
		try {

			LP2.ejercicio2LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Programación Lineal");
			e.printStackTrace();

		}
		
		// Solución por Algoritmos Genéticos:
//		try {
//
//			LP2.ejercicio2LP();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la solución mediante Programación Lineal");
//			e.printStackTrace();
//
//		}
			
	}

}
