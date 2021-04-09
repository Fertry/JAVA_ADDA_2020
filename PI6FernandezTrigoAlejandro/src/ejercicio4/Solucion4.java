/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;

/*
 * Clase solución que pretende parsear la salida del resolvedor Gurobi para mostrar los 
 * resultados acordes al fichero de resultados.
 */
public class Solucion4 {
	
	public static void solucionLP4(String fichero, String entrada) {
		
		// Crear el objeto para escribir sobre fichero:
		PrintWriter writer = null;
		FileWriter archivo = null;
	
		try {
			
			// Crea el archivo para escribir sobre el:
			archivo = new FileWriter("volcado/salidaPLEj4DatosEntrada" + fichero.replace("ficheros/PI6Ej4DatosEntrada", ""));
			
			// Escribe sobre el archivo:
			writer = new PrintWriter(archivo);
			writer.println(entrada.trim());
			
			// Cierra el archivo cuando se acaba de escribir:
			archivo.close();
			
			// Con el fichero creado, se llama a la función que lo parsea:
			//formateo("volcado/salidaPLEj4DatosEntrada" + fichero.replace("ficheros/PI6Ej4DatosEntrada", ""), fichero);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			e.printStackTrace();
			
		}
				
	}
	
	public static void formateo(String fichero, String nombre) {
		
		// La primera línea representa el valor objetivo.
		// La segunda línea es descartable.
		// La tercera línea representa el tiempo total. 
		// A partir de la cuarta línea comienzan los datos.
		// El formato de cada línea es: 
		// x_n_m == 1 dónde n es el abogado y m el caso.
		
		int i = 3;
		Map<Integer, Integer> reparto = new HashMap<Integer, Integer>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
				
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan tres valores:
			// Una x (se descarta), el abogado y el caso.
			String[] valores = datos[0].trim().split("_");
			
			// Añadir los valores al mapa, esto es: Conjunto (como clave) y Elemento (como valor):
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
