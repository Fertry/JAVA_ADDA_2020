/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

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
	public static List<String> nombres;
	public static List<List<Integer>> horas;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde las clases PL y AG que resuelven el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		// Inicializar las variables de la clase Ejercicio2:
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
	 * M�todos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	// Obtiene el n� de abogados:
	public static Integer getNAbogados() {

		return nombres.size();
		
	}
	
	// Obtiene el n� de horas:
	public static Integer getNHoras() {
		
		return horas.get(0).size();
		
	}
		
	// Obtiene el tiempo de un abogado dado el abogado (i) para el caso (j):
	public static Integer tiempoPorIndice(Integer i, Integer j) {
		
		return horas.get(i).get(j);
		
	}
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio2(String fichero) {
		

		// Soluci�n por Programaci�n Lineal:
		try {

			LP2.ejercicio2LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			e.printStackTrace();

		}
		
		// Soluci�n por Algoritmos Gen�ticos:
//		try {
//
//			AG2.ejercicio2AG();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la soluci�n mediante Algoritmos Gen�ticos ");
//			System.out.println("para el fichero: " + fichero + ".\n");
//			e.printStackTrace();
//
//		}
			
	}

}
