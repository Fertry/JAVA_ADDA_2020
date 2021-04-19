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
	
	// Función que dado una solución de LP desde Gurobi escribe el resultado a fichero para parsearlo:
	public static void solucionLP2(String fichero, String entrada, Double valor) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			Files2.toFile(entrada.trim(), "volcado/salidaPLEj2DatosEntrada" + fichero.replace("ficheros/PI6Ej2DatosEntrada", ""));
			
			// Con el fichero creado, se llama a la función que lo parsea:
			formateoPL("volcado/salidaPLEj2DatosEntrada" + fichero.replace("ficheros/PI6Ej2DatosEntrada", ""), fichero, valor);

		// Si algo falla, mostramos el contenido de forma directa: 
		} catch (Exception e) {
			
			System.out.println("No se ha podido formatear la salida así que se vuelca el ");
			System.out.println("resultado directamente por consola.\n");
			System.out.println(entrada + "\n");
			// e.printStackTrace();
			
		}
				
	}
	
	// Función que dado una solución de Algoritmos Genéticos parsea la solución:
	public static void solucionAG2(String fichero, List<Integer> entrada) {
		
		// La lista incluye como indice a los casos, cada indice representa
		// a un caso y el valor en dicha posición el abogado asignado:
		// Ej: [8, 7, 1, 7, 8, 8, 5, 0, 2, 2, 0, 7, 6, 8, 5, 9, 0, 6, 4, 8]
		// Se mantiene un mapa cuyas claves son los abogados y los valores, los casos asignados:
		
		Double valor = 0.0;
		Map<Integer, List<String>> reparto = new HashMap<Integer, List<String>>();
		
		int i = 0;
		while (i < entrada.size()) {
			
			if (reparto.containsKey(entrada.get(i) + 1)) {
			
				List<String> casos = new ArrayList<>();
				casos = reparto.get(entrada.get(i) + 1);
				casos.add("Caso " + (i + 1));
				
				//reparto.put(entrada.get(i) + 1, casos);
				reparto.put(entrada.get(i), casos);
				
			} else {
				
				List<String> casos = new ArrayList<>();
				casos.add("Caso " + (i + 1));
				
				//reparto.put(entrada.get(i) + 1, casos);
				reparto.put(entrada.get(i), casos);
				
			}
			
			// Valor representa el sumatorio de afinidades para el calculo de la afinidad media:
			valor += Ejercicio2AG.tiempoPorIndice(entrada.get(i), i);
			
			i++;
				
		}
			
		// Con el mapa creado, se llama a la función que lo parsea:
		formateoAG(fichero, reparto, valor);
		
	}
	
	// Función que parsea el fichero generado por solucionLP2 para mostrar el resultado por pantalla:
	public static void formateoPL(String fichero, String nombre, Double valor) {
		
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
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~PROGRAMACIÓN LINEAL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- ·");
		for (Integer abogado : reparto.keySet()) {
	
			System.out.println("Abogado_" + (abogado + 1));
			System.out.println("	Horas empleadas: " + Math.round(sumatorioHoras(reparto, abogado)));
			System.out.println("	Casos estudiados: " + reparto.get(abogado));
			
		}
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- ·");
		System.out.println("El estudio de todos los casos ha supuesto un total de " + Math.round(sumatorioHorasTotal(reparto)) + " horas de trabajo\r\n"
				+ "para el bufete, que al trabajar en paralelo se ha podido llevar a cabo en " + Math.round(valor) + "\r\n"
				+ "horas.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
	}
	
	// Función que parsea la salida de solucionAG1 para mostrar el resultado por pantalla:
	public static void formateoAG(String nombre, Map<Integer, List<String>> reparto, Double valor) {
		
		// Salida final por pantalla:
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ALGORITMOS GENÉTICOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(nombre.replace("ficheros/", "") + ":");	
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- ·");
		for (Integer abogado : reparto.keySet()) {
	
			System.out.println("Abogado_" + (abogado + 1));
			System.out.println("	Horas empleadas: " + Math.round(sumatorioHoras(reparto, abogado)));
			System.out.println("	Casos estudiados: " + reparto.get(abogado));
			System.out.println("	Media (horas/casos): " + Math.round((sumatorioHoras(reparto, abogado) / reparto.get(abogado).size())));
			
		}
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- ·");
		System.out.println("El estudio de todos los casos ha supuesto un total de " + Math.round(sumatorioHorasTotal(reparto)) + " horas de trabajo\r\n"
				+ "para el bufete, que al trabajar en paralelo se ha podido llevar a cabo en " + Math.round(valor) + "\r\n"
				+ "horas.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	// Método auxiliar para calcular el tiempo empleado por abogado en base a sus casos asociados:
	private static Double sumatorioHoras(Map<Integer, List<String>> reparto, Integer abogado) {
		
		Integer suma = 0;
		
		for (String caso : reparto.get(abogado)) {
			
			// Los casos que son Strings los casteo a entero: 
			Integer n = Integer.parseInt(caso.replace("Caso ", ""));

			suma += Ejercicio2LP.tiempoPorIndice(abogado, n - 1);
			
		}
		
		return (double)suma;
		
	}
	
	// Método auxiliar para calcular el tiempo total empleado sin paralelismo según el reparto:
	private static Double sumatorioHorasTotal(Map<Integer, List<String>> reparto) {
		
		Integer suma = 0;
		
		for (Integer abogado : reparto.keySet()) {
			
			for (String caso : reparto.get(abogado)) {
				
				// Los casos que son Strings los casteo a entero: 
				Integer n = Integer.parseInt(caso.replace("Caso ", ""));
				
				suma += Ejercicio2LP.tiempoPorIndice(abogado, n - 1);
				
			}
			
		}
		
		return (double)suma;
	
	}

}
