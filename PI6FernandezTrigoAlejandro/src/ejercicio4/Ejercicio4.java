/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
	Dado un conjunto de enteros determinar si puede particionarse en tres
	subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
	misma, y que el tama�o de uno de ellos sea lo menor posible.
	
	Se pide solucionar por Programaci�n Lineal
*/

public class Ejercicio4 {
	
	/*
	 * Variables de la clase necesarias para ser accedidas por la clase
	 * PL que resuelve el ejercicio. 
	*/
	public static List<String> nombres;
	public static List<List<Integer>> elementos;
	
	/*
	 * M�todo inicial para la lectura de datos del fichero que se pasa como
	 * par�metro usando Collectors y el m�todo StreamsS proporcionado por la librer�a.
	 * Se acceder� a los datos desde la clase PL que resuelve el ejercicio.
	*/
	public static void iniDatos(String fichero) {
		
		elementos = new ArrayList<List<Integer>>();
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
		elementos.add(afinidadesAux);
		
	}
	
	/*
	 * M�todos auxiliares para definir las restricciones del problema. Son invocados
	 * en el fichero .lsi para generar el modelo .lp. 
	*/
	
	/*
	 * M�todo p�blico para ejecutar todo el ejercicio desde el fichero de Test.java
	*/
	public static void ejercicio4(String fichero) {

		// Soluci�n por Programaci�n Lineal:
		try {

			LP4.ejercicio4LP(fichero);

		} catch (IOException e) {

			System.out.println("No se ha podido calcular la soluci�n mediante Programaci�n Lineal ");
			System.out.println("para el fichero: " + fichero + ".\n");
			//e.printStackTrace();

		}
		
	}

}
