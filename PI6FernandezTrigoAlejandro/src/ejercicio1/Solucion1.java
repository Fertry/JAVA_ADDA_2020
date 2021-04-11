/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;

/*
 * Clase solución que pretende parsear la salida del resolvedor Gurobi y la salida
 * de algoritmos genéticos para mostrar los resultados acordes al fichero de resultados.
 */
public class Solucion1 {
	
	// Función que dado una solución de LP desde Gurobi escribe el resultado a fichero para parsearlo:
	public static void solucionLP1(String fichero, String entrada, Double valor) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la función que lo parsea:
			formateo("volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""), fichero, valor);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	// Función que parsea el fichero generado por solucionLP1 para mostrar el resultado por pantalla:
	public static void formateo(String fichero, String nombre, Double valor) {
		
		// La primera línea representa el valor objetivo.
		// La segunda línea es descartable.
		// A partir de la tercera línea comienzan los datos.
		// El formato de cada línea es: 
		// x_n_m == 1 dónde n es el alumno y m el grupo.
		
		int i = 2;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<Integer, List<String>> reparto = new HashMap<Integer, List<String>>();
		
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan tres valores:
			// Una x (se descarta), el alumno y el grupo.
			String[] valores = datos[0].trim().split("_");
			
			// Añadir los valores al mapa en función del grupo al que pertenecen, de forma que las claves
			// son los alumnos y los valores el grupo:
			List<String> alumnos = new ArrayList<String>();
			if (reparto.containsKey(Integer.parseInt(valores[2].trim()))) {
				
				alumnos = reparto.get(Integer.parseInt(valores[2].trim()));
				Integer alumno = Integer.parseInt(valores[1].trim()) + 1;
				alumnos.add("Alumno_" + alumno);
				
				reparto.put(Integer.parseInt(valores[2].trim()), alumnos);
				
			} else {
				
				Integer alumno = Integer.parseInt(valores[1].trim()) + 1;
				alumnos.add("Alumno_" + alumno);
				
				reparto.put(Integer.parseInt(valores[2].trim()), alumnos);
				
			}
			
			i++;
			
		}

		// Afinidad media:
		Double afinidadMedia = valor / Ejercicio1.getNAlumnos();
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Reparto obtenido:");
		for (Integer entrada : reparto.keySet()) {
			
			System.out.println("Grupo " + (entrada + 1) + ": " + reparto.get(entrada).toString());
			
		}
		System.out.println("Afinidad media: " + afinidadMedia);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}
