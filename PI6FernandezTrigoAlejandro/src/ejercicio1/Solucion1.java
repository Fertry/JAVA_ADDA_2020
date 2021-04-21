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
	
	// Funci�n que dado una soluci�n de LP desde Gurobi escribe el resultado a fichero para parsearlo:
	public static void solucionLP1(String fichero, String entrada, Double valor) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuaci�n:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la funci�n que lo parsea:
			formateoPL("volcado/salidaPLEj1DatosEntrada" + fichero.replace("ficheros/PI6Ej1DatosEntrada", ""), fichero, valor);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida as� que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	// Funci�n que dado una soluci�n de Algoritmos Gen�ticos parsea la soluci�n:
	public static void solucionAG1(String fichero, List<Integer> entrada) {

		// La lista incluye como indice a los alumnos, cada indice representa
		// a un alumno y el valor en dicha posici�n el grupo asignado:
		// Ej: [3, 2, 2, 1, 1, 0, 0, 0, 2, 2, 1, 1, 2, 2, 2, 2, 3, 0, 3, 3]
		// Se mantiene un mapa cuyas claves son los grupos y los valores, los alumnos asociados:
		
		Double valor = 0.0;
		Map<Integer, List<String>> reparto = new HashMap<Integer, List<String>>();

		int i = 0;
		while (i < entrada.size()) {
			
			if (reparto.containsKey(entrada.get(i) + 1)) {
				
				List<String> alumnos = new ArrayList<>();
				alumnos = reparto.get(entrada.get(i) + 1);
				alumnos.add(Ejercicio1AG.nombres.get(i));
				
				reparto.put(entrada.get(i) + 1, alumnos);
				
			} else {
				
				List<String> alumnos = new ArrayList<>();
				alumnos.add(Ejercicio1AG.nombres.get(i));
				
				reparto.put(entrada.get(i) + 1, alumnos);
				
			}
			
			// Valor representa el sumatorio de afinidades para el calculo de la afinidad media:
			valor += Ejercicio1AG.afinidadPorIndice(i, entrada.get(i));
			
			i++;
				
		}
			
		// Con el mapa creado, se llama a la funci�n que lo parsea:
		formateoAG(fichero, reparto, valor);

	}
	
	// Funci�n que parsea el fichero generado por solucionLP1 para mostrar el resultado por pantalla:
	private static void formateoPL(String fichero, String nombre, Double valor) {
		
		// La primera l�nea representa el valor objetivo.
		// La segunda l�nea es descartable.
		// A partir de la tercera l�nea comienzan los datos.
		// El formato de cada l�nea es: 
		// x_n_m == 1 d�nde n es el alumno y m el grupo.
		
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
			
			// A�adir los valores al mapa en funci�n del grupo al que pertenecen, de forma que las claves
			// son los grupos y los valores alumnos:
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
		Double afinidadMedia = valor / Ejercicio1LP.getNAlumnos();
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~PROGRAMACI�N LINEAL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Reparto obtenido:");
		for (Integer entrada : reparto.keySet()) {
			
			System.out.println("Grupo " + (entrada + 1) + ": " + reparto.get(entrada).toString());
			
		}
		System.out.println("Afinidad media: " + Math.round(afinidadMedia));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	// Funci�n que parsea la salida de solucionAG1 para mostrar el resultado por pantalla:
	private static void formateoAG(String nombre, Map<Integer, List<String>> reparto, Double valor) {
		
		// Afinidad media:
		Double afinidadMedia = valor / Ejercicio1AG.getNAlumnos();
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ALGORITMOS GEN�TICOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");
		System.out.println("Reparto obtenido:");
		for (Integer entrada : reparto.keySet()) {

			System.out.println("Grupo " + (entrada) + ": " + reparto.get(entrada).toString());

		}
		System.out.println("Afinidad media: " + Math.round(afinidadMedia));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
}
