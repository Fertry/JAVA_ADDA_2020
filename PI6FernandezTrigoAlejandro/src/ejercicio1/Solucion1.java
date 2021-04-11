/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
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
 * Clase soluci�n que pretende parsear la salida del resolvedor Gurobi y la salida
 * de algoritmos gen�ticos para mostrar los resultados acordes al fichero de resultados.
 */
public class Solucion1 {
	
	public static void solucionLP1(String fichero, String entrada, Double valor) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuaci�n:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la funci�n que lo parsea:
			formateo("volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""), fichero, valor);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida as� que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	public static void formateo(String fichero, String nombre, Double valor) {
		
		// La primera l�nea representa el valor objetivo.
		// La segunda l�nea es descartable.
		// A partir de la tercera l�nea comienzan los datos.
		// El formato de cada l�nea es: 
		// x_n_m == 1 d�nde n es el alumno y m el grupo.
		
		int i = 2;
		Map<Integer, Integer> reparto = new HashMap<Integer, Integer>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
				
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan tres valores:
			// Una x (se descarta), el alumno y el grupo.
			String[] valores = datos[0].trim().split("_");
			
			// A�adir los valores al mapa, esto es: Alumno (como clave) y Grupo (como valor):
			reparto.put(Integer.parseInt(valores[1].trim()), Integer.parseInt(valores[2].trim()));
			
			i++;
			
		}

		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Valor objetivo: " + valor);
		System.out.println("Reparto obtenido:");
		System.out.println(reparto);

		Map<Integer, List<Integer>> aux = new HashMap<Integer, List<Integer>>();
		for (Integer grupo : reparto.values()) {
			
			System.out.println(grupo);
			List<Integer> list = new ArrayList<Integer>();
			
			if (!aux.containsKey(grupo)) {
				
				list.add(reparto.get(grupo));
				aux.put(grupo, list);

			} 

		}
		
		System.out.println(aux);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}