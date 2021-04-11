/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;

/*
 * Clase solución que pretende parsear la salida del resolvedor Gurobi para mostrar los 
 * resultados acordes al fichero de resultados.
 */
public class Solucion4 {
	
	public static void solucionLP4(String fichero, String entrada, Integer indice) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj4DatosEntrada" + (indice + 1) + ".txt");
			
			// Con el fichero creado, se llama a la función que lo parsea:
			formateo("volcado/salidaPLEj4DatosEntrada" + (indice + 1) + ".txt", fichero);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	public static void formateo(String fichero, String nombre) {
		
		// La primera línea representa el valor objetivo.
		// La segunda línea es descartable.
		// A partir de la tercera línea comienzan los datos.
		// El formato de cada línea es: 
		// x_n_m == 1 dónde n es el elemento y m el conjunto.
		
		int i = 2;
		Map<Integer, Integer> reparto = new HashMap<Integer, Integer>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
				
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan tres valores:
			// Una x (se descarta), el conjunto y el elemento.
			String[] valores = datos[0].trim().split("_");
			
			// Añadir los valores al mapa, esto es: Elemento (como clave) y Conjunto (como valor):
			reparto.put(Integer.parseInt(valores[1].trim()), Integer.parseInt(valores[2].trim()));
			
			i++;
			
		}
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Reparto obtenido:");
		System.out.println(reparto);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}
