/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;

/*
 * Clase soluci�n que pretende parsear la salida del resolvedor Gurobi para mostrar los 
 * resultados acordes al fichero de resultados.
 */
public class Solucion4 {
	
	public static void solucionLP4(String fichero, String entrada, Integer indice, Double valor) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuaci�n:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj4DatosEntrada" + (indice + 1) + ".txt");
			
			// Con el fichero creado, se llama a la funci�n que lo parsea:
			formateo("volcado/salidaPLEj4DatosEntrada" + (indice + 1) + ".txt", fichero, valor);

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
		// x_n_m == 1 d�nde n es el elemento y m el conjunto.
		
		int i = 2;
		Map<Integer, List<Integer>> reparto = new HashMap<Integer, List<Integer>>();
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
				
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan tres valores:
			// Una x (se descarta), el elemento y el conjunto.
			String[] valores = datos[0].trim().split("_");
			
			// A�adir los valores al mapa en funci�n del grupo al que pertenecen, de forma que las claves
			// son los conjuntos y los valores elementos:
			List<Integer> elementos = new ArrayList<Integer>();
			if (reparto.containsKey(Integer.parseInt(valores[2].trim()))) {
				
				// N�TESE! Que el elemento se obtiene aqu� ya que Gurobi devuelve la posici�n NO el elemento!
				elementos = reparto.get(Integer.parseInt(valores[2].trim()));
				Integer elemento = Ejercicio4.elemento(Integer.parseInt(valores[1].trim()));
				elementos.add(elemento);
				
				reparto.put(Integer.parseInt(valores[2].trim()), elementos);
				
			} else {
				
				// N�TESE! Que el elemento se obtiene aqu� ya que Gurobi devuelve la posici�n NO el elemento!
				Integer elemento = Ejercicio4.elemento(Integer.parseInt(valores[1].trim()));
				elementos.add(elemento);
				
				reparto.put(Integer.parseInt(valores[2].trim()), elementos);
				
			}
			
			i++;
			
		}
		
		// Suma de elementos:
		Integer menor = (int)Math.round(valor);
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("Conjunto de entrada: " + Ejercicio4.conjunto());
		System.out.println("Suma Objetivo: " + sumaObjetivo(reparto));
		System.out.println("o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o");
		System.out.println("El menor conjunto tiene " + menor + " elemento/s.");
		for (Integer conjunto : reparto.keySet()) {
			
			System.out.println("Elementos del conjunto " + (conjunto + 1) + ":" + reparto.get(conjunto));
			
		}
		System.out.println("o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o~~~~�~~~~o");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
	// M�todo auxiliar para calcular la suma objetivo:
	private static Integer sumaObjetivo(Map<Integer, List<Integer>> reparto) {
		
		Integer suma = 0;
		Integer menor = 0;
		
		// Obtiene el menor conjunto:
		for (Integer conjunto : reparto.keySet()) {
			
			if (menor > reparto.get(conjunto).size()) {
				
				menor = conjunto;
				
			}
			
		}
		
		// Con el menor conjunto, calcula su sumatorio:
		for (Integer elemento : reparto.get(menor)) {
			
			suma += elemento;
			
		}
		
		return suma;
		
	}

}
