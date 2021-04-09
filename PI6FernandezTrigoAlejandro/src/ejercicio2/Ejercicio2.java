/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
	casos relacionados entre s� (m>=n), y deben terminar dicho an�lisis global lo antes
	posible para lo que trabajar�n en paralelo. Cada caso ser� analizado por un �nico
	abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
	horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
	tiempo puede diferir para cada caso en funci�n de qu� abogado realice el an�lisis).
	Determine cu�l es la mejor asignaci�n de casos a abogados para conseguir el
	objetivo indicado (terminar de analizar todos los casos lo antes posible).
	
    Se piden soluciones por Programaci�n Lineal y Algoritmos Gen�ticos
*/

public class Ejercicio2 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por las clases
	 * PL y AG que resuelven el ejercicio. 
	*/
	public static List<String> abogados;
	public static List<List<Integer>> horas;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde las clases PL y AG que resuelven el ejercicio.
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
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio2(String fichero) {
		

		// Soluci�n por Programaci�n Lineal:
		try {

			LP2.ejercicio2LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal");
			e.printStackTrace();

		}
		
		// Soluci�n por Algoritmos Gen�ticos:
//		try {
//
//			LP2.ejercicio2LP();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal");
//			e.printStackTrace();
//
//		}
			
	}

}
