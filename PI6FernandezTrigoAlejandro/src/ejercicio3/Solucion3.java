/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;

/*
 * Clase soluci�n que pretende parsear la salida del resolvedor Gurobi y la salida
 * de algoritmos gen�ticos para mostrar los resultados acordes al fichero de resultados.
 */
public class Solucion3 {
	
	public static void solucionLP3(String fichero, String entrada) {

		try {
			
			// Escribe el resultado a fichero para tratarlo a continuaci�n:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj3DatosEntrada" + fichero.replace("ficheros/PI6Ej3DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la funci�n que lo parsea:
			formateo("volcado/salidaPLEj3DatosEntrada" + fichero.replace("ficheros/PI6Ej3DatosEntrada", ""), fichero);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida as� que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	// Funci�n que dado una soluci�n de Algoritmos Gen�ticos escribe el resultado a fichero para parsearlo:
	public static void solucionAG3() {
		
		// TO-DO
		
	}
	
	public static void formateo(String fichero, String nombre) {
		
		// La primera l�nea representa el valor objetivo.
		// La segunda l�nea es descartable.
		// A partir de la tercera l�nea comienzan los datos.
		// El formato de cada l�nea es: 
		// x_n == 1 d�nde n es el producto.
		
		int i = 2;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		
		List<Integer> seleccion = new ArrayList<Integer>();		
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan dos valores:
			// Una x (se descarta) y el producto.
			String[] valores = datos[0].trim().split("_");
			
			// A�adir los valores a la lista:
			seleccion.add(Integer.parseInt(valores[1]) + 1);
			
			i++;
			
		}

		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Reparto obtenido:");
		System.out.println(seleccion);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}
