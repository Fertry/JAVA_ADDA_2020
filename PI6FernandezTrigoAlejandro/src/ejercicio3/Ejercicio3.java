/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
	de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
	desea diseñar un lote con una selección de dichos productos que cubran un
	conjunto de funcionalidades deseadas entre todos productos seleccionados al
	menor precio.
	
	Se piden soluciones por Programación Lineal y Algoritmos Genéticos
*/

public class Ejercicio3 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por las clases
	 * PL y AG que resuelven el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<List<Integer>> funcionalidades;
	
	/*
	 * Método inicial para la lectura de datos del fichero que se pasa como
	 * parámetro usando Collectors y el método StreamsS proporcionado por la librería.
	 * Se accederá a los datos desde las clases PL y AG que resuelven el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		funcionalidades = new ArrayList<List<Integer>>();
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
		funcionalidades.add(afinidadesAux);
		
	}
	
	/*
	 * Métodos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	
	/*
	 * Método público para ejecutar todo el ejercicio desde el fichero de Test.java
	 */
	public static void ejercicio3(String fichero) {
		
		// Solución por Programación Lineal:
		try {

			LP3.ejercicio3LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la solución mediante Programación Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			// e.printStackTrace();

		}

		// Solución por Algoritmos Genéticos:
//		try {
//
//			PL.ejercicio1LP();
//
//		} catch (IOException e) {
//
//			System.out.println("No se ha podido calcular la solución mediante Algoritmos Genéticos ");
//			System.out.println("para el fichero: " + fichero + ".\n");
//			e.printStackTrace();
//
//		}

	}

}
