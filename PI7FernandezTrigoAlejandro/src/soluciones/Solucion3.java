/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package soluciones;

import java.util.List;

import us.lsi.common.Files2;
import vertices.VerticeAlumno;

public class Solucion3 {
	
	/*
	 * M�todo p�blico para recibir la lista de v�rtices resultantes de la ejecuci�n de A* y operar sobre dicha lista.
	*/
	public static void solucionA(List<VerticeAlumno> entrada, String fichero) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuaci�n:
			String datos = entrada.toString();
			Files2.toFile(datos.trim(), "salida/salidaEj3A" + fichero.replace("ficheros/PI7Ej3DatosEntrada", ""));
			formateoA("salida/salidaEj3A" + fichero.replace("ficheros/PI7Ej3DatosEntrada", ""), fichero);
				
		// Si hay alg�n problema se vuelca la salida directamente por consola:
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
	 * M�todo p�blico para recibir la lista de v�rtices resultantes de la ejecuci�n de Programaci�n Din�mica y operar sobre dicha lista.
	*/
	public static void solucionPD() {
		
		
	}
	
	/*
	 * M�todo p�blico para recibir la lista de v�rtices resultantes de la ejecuci�n de Backtracking manual y operar sobre dicha lista.
	*/
	public static void solucionBTManual() {
		
		
	}
	
	/*
	 * M�todo privado encargado de parsear todo el contenido de A* para adecuarlo al fichero de resultados.
	*/
	private static void formateoA(String fichero, String rutaOrigen) {
		
		
	}
	
	/*
	 * M�todo privado encargado de parsear todo el contenido de Programaci�n Din�mica para adecuarlo al fichero de resultados.
	*/
	private static void formateoPD() {
		
		
	}

	/*
	 * M�todo privado encargado de parsear todo el contenido de Backtracking manual para adecuarlo al fichero de resultados.
	*/
	private static void formateoBTManual() {
		
		
	}

}
