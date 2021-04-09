/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * Clase solución que pretende parsear la salida del resolvedor Gurobi y la salida
 * de algoritmos genéticos para mostrar los resultados acordes al fichero de resultados.
 */
public class Solucion1 {
	
	public static void solucionLP1(String fichero, String entrada) {
		
		// Crear el objeto para escribir sobre fichero:
		PrintWriter writer = null;
		FileWriter archivo = null;
	
		try {
			
			// Crea el archivo para escribir sobre el:
			archivo = new FileWriter("volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""));
			
			// Escribe sobre el archivo:
			writer = new PrintWriter(archivo);
			writer.println(entrada.trim());
			
			// Cierra el archivo cuando se acaba de escribir:
			archivo.close();
		
		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			//e.printStackTrace();
			
		}
		
	}

}
