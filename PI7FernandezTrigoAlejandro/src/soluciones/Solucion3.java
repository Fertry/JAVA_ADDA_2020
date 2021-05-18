/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package soluciones;

import java.util.List;

import us.lsi.common.Files2;
import vertices.VerticeAlumno;

public class Solucion3 {
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de A* y operar sobre dicha lista.
	*/
	public static void solucionA(List<VerticeAlumno> entrada, String fichero) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			String datos = entrada.toString();
			Files2.toFile(datos.trim(), "salida/salidaEj3A" + fichero.replace("ficheros/PI7Ej3DatosEntrada", ""));
			formateoA("salida/salidaEj3A" + fichero.replace("ficheros/PI7Ej3DatosEntrada", ""), fichero);
				
		// Si hay algún problema se vuelca la salida directamente por consola:
		} catch (Exception e) {
			
			// e.printStackTrace();
			System.out.println("No se ha podido formatear la salida para el fichero " + fichero + ", en su lugar se muestra la lista de "
					+ "vertices devuelta por el algoritmo A* por pantalla.");
			
			for (VerticeAlumno vertice : entrada) {
				
				System.out.println(vertice.toString());
				
			}
			
		}
		
	}
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de Programación Dinámica y operar sobre dicha lista.
	*/
	public static void solucionPD() {
		
		
	}
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de Backtracking manual y operar sobre dicha lista.
	*/
	public static void solucionBTManual() {
		
		
	}
	
	/*
	 * Método privado encargado de parsear todo el contenido de A* para adecuarlo al fichero de resultados.
	*/
	private static void formateoA(String fichero, String rutaOrigen) {
		
		
	}
	
	/*
	 * Método privado encargado de parsear todo el contenido de Programación Dinámica para adecuarlo al fichero de resultados.
	*/
	private static void formateoPD() {
		
		
	}

	/*
	 * Método privado encargado de parsear todo el contenido de Backtracking manual para adecuarlo al fichero de resultados.
	*/
	private static void formateoBTManual() {
		
		
	}

}
