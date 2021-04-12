/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

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
public class Solucion2 {
	
	public static void solucionLP2(String fichero, String entrada) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj2DatosEntrada" + fichero.replace("ficheros/PI6Ej2DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la función que lo parsea:
			formateo("volcado/salidaPLEj2DatosEntrada" + fichero.replace("ficheros/PI6Ej2DatosEntrada", ""), fichero);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	// Función que dado una solución de Algoritmos Genéticos escribe el resultado a fichero para parsearlo:
	public static void solucionAG2() {
		
		// TO-DO
		
	}
	
	public static void formateo(String fichero, String nombre) {
		
		// La primera línea representa el valor objetivo.
		// La segunda línea es descartable.
		// La tercera línea representa el tiempo total. 
		// A partir de la cuarta línea comienzan los datos.
		// El formato de cada línea es: 
		// x_n_m == 1 dónde n es el abogado y m el caso.
		
		int i = 3;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<Integer, List<String>> reparto = new HashMap<Integer, List<String>>();		
		
		while (i < lista.size()) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split("==");
			
			// El contenido a la derecha queda descartado dado que siempre es 1
			// A la izquierda, tras hacer split nos quedan tres valores:
			// Una x (se descarta), el abogado y el caso.
			String[] valores = datos[0].trim().split("_");
			
			// Añadir los valores al mapa en función del abogado al que se asocien, de forma 
			// que las claves son los abogados y los valores casos:
			List<String> casos = new ArrayList<String>();
			if (reparto.containsKey(Integer.parseInt(valores[1].trim()))) {
				// Abogados son [1]
				casos = reparto.get(Integer.parseInt(valores[1].trim()));
				Integer caso = Integer.parseInt(valores[2].trim()) + 1;
				casos.add("Caso " + caso);
				
				reparto.put(Integer.parseInt(valores[1].trim()), casos);
				
			} else {
				
				Integer caso = Integer.parseInt(valores[2].trim()) + 1;
				casos.add("Caso " + caso);
				
				reparto.put(Integer.parseInt(valores[1].trim()), casos);
				
			}
			
			i++;
			
		}
		
		// DEBUG: EL MAPA SE GENERA BIEN, ERROR POR DEBAJO DE ESTA LINEA
		// System.out.println(reparto);
		
		// Tiempo total, tiempo en paralelo y tiempo por abogado:
		Integer horasEmpleadas = 0;
		String[] tiempo = lista.get(2).trim().split("==");
		String horas = tiempo[1].trim();
		Integer horasTotal = Ejercicio2.tiempoSinParalelismo();
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- ·");
		for (Integer abogado : reparto.keySet()) {
			
			// DEBUG: FALLA AL RECORRER LOS CASOS
			System.out.println(reparto.get(abogado));
			
			// ============================================================
			for (String string : reparto.get(abogado)) {
				
				Integer n = Integer.parseInt(string) - 1;
				// Esta n es el caso:
				System.out.println(n);

				// Si quiero el tiempo dado un abogado y el caso n:
				System.out.println("Tiempo para el caso " + n + " asociado al abogado " + Ejercicio2.tiempoPorIndice(abogado, n));
				
			}
			
			
			// ============================================================

			
			// Sumatorio de horas dados los casos asociados a un abogado:
//			for (List<String> casos : reparto.values()) {
//				for (String caso : casos) {
//					
//					// Restar 1 al caso (se sumó +1 antes por conveniencia al mostrar los datos)
//					Integer casoEntero = Integer.parseInt(caso) - 1; 
//					horasEmpleadas += Ejercicio2.tiempoPorIndice(abogado, casoEntero);
//					
//				}
//				
//			}
			
			System.out.println("Abogado_" + (abogado + 1));
			System.out.println("	Horas empleadas: " + horasEmpleadas);
			System.out.println("	Casos estudiados: " + reparto.get(abogado));
			System.out.println("	Media (horas/casos): " + (horasEmpleadas / reparto.get(abogado).size()));
			
		}
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- ·");
		System.out.println("El estudio de todos los casos ha supuesto un total de " + horasTotal + " horas de trabajo\r\n"
				+ "para el bufete, que al trabajar en paralelo se ha podido llevar a cabo en " + horas + "\r\n"
				+ "horas.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
	}
	
}
