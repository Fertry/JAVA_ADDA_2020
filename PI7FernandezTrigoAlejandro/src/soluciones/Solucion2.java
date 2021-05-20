/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package soluciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import aristas.AristaAbogado;
import ejercicio2.Ejercicio2;
import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;
import vertices.VerticeAbogado;

public class Solucion2 {
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de A* y operar sobre dicha lista.
	*/
	public static void solucionA(List<AristaAbogado> entrada, String fichero) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			String datos = entrada.toString();
			Files2.toFile(datos.trim(), "salida/salidaEj2A" + fichero.replace("ficheros/PI7Ej2DatosEntrada", ""));
			formateoA("salida/salidaEj2A" + fichero.replace("ficheros/PI7Ej2DatosEntrada", ""), fichero);
				
		// Si hay algún problema se vuelca la salida directamente por consola:
		} catch (Exception e) {
			
			// e.printStackTrace();
			System.out.println("No se ha podido formatear la salida para el fichero " + fichero + ", en su lugar se muestra la lista de "
					+ "aristas devuelta por el algoritmo A* por pantalla.");
			
			for (VerticeAbogado vertice : entrada) {
				
				System.out.println(vertice.toString());
				
			}
			
		}
		
	}
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de Programación Dinámica y operar sobre dicha lista.
	*/
	public static void solucionPD(List<VerticeAbogado> entrada, String fichero) {
		
		try {
			
			// Escribe el resultado a fichero para tratarlo a continuación:
			String datos = entrada.toString();
			Files2.toFile(datos.trim(), "salida/salidaEj2PD" + fichero.replace("ficheros/PI7Ej2DatosEntrada", ""));
			formateoPD("salida/salidaEj2PD" + fichero.replace("ficheros/PI7Ej2DatosEntrada", ""), fichero);
				
		// Si hay algún problema se vuelca la salida directamente por consola:
		} catch (Exception e) {
			
			// e.printStackTrace();
			System.out.println("No se ha podido formatear la salida para el fichero " + fichero + ", en su lugar se muestra la lista de "
					+ "vertices devuelta por el algoritmo programación dinámica por pantalla.");
			
			for (VerticeAbogado vertice : entrada) {
				
				System.out.println(vertice.toString());
				
			}
			
		}
		
	}
	
	private static void formateoA(String fichero, String rutaOrigen) {
		
		
	}
	
	/*
	 * Método privado encargado de parsear todo el contenido de A* para adecuarlo al fichero de resultados.
	*/
//	private static void formateoA(String fichero, String rutaOrigen) {
//		
//		int i = 0;
//		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
//		Map<String, List<Integer>> reparto = new HashMap<String, List<Integer>>();
//
//		while (i < lista.size() - 1) {
//			
//			String linea = lista.get(i).trim();
//			String[] datos = linea.trim().split(" - ");
//			
//			// Obtener el caso:
//			String[] splitIzquierdo = datos[0].trim().split(":");
//			String caso = "Caso " + (Integer.parseInt(splitIzquierdo[1].trim()) + 1);
//			
//			// Obtener la lista asociada:
//			List<Integer> auxiliar = new ArrayList<Integer>();
//			String[] splitDerecho = datos[1].trim().replace("[", "").replace("]", "").split(",");
//			
//			for (String numero : splitDerecho) {
//				
//				auxiliar.add(Integer.parseInt(numero.trim()));
//				
//			}
//			
//			// Meter el caso con su lista en el mapa reparto: 
//			if (reparto.containsKey(caso)) {
//				
//				List<Integer> valor = reparto.get(caso);
//				reparto.put(caso, valor);
//				
//			} else {
//				
//				reparto.put(caso, auxiliar);
//				
//			}
//			
//			i++;
//					
//		}
//		
//		// Con el mapa creado compruebo a que abogado se asigna cada caso gracias al método auxiliar 
//		// cualHaCambiado() y los índices:		
//		int j = 1;
//		Set<String> setCasos = new HashSet<String>();
//		Map<String, Set<String>> resultado = new HashMap<String, Set<String>>();
//		while (j < lista.size() - 1) {
//			
//			/*
//			 * Esto me permite asignar los casos a abogados, cosa que hago con un nuevo mapa que constituirá la 
//			 * solución propiamente dicha:
//			*/
//			Integer abogado = cualHaCambiado(reparto, "Caso " + j);
//			if (resultado.containsKey("Abogado_" + abogado)) {
//				
//				// Casos asignados al abogado:
//				setCasos = resultado.get("Abogado_" + abogado);
//				setCasos.add("Caso " + j);
//				resultado.put("Abogado_" + abogado, setCasos);
//				
//			} else {
//				
//				// Casos asignados al abogado:
//				Set<String> setAux = new HashSet<String>();
//				setAux.add("Caso " + j);
//				resultado.put("Abogado_" + abogado, setAux);
//				
//			}
//			
//			j++;
//			
//		}
//		
//		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ A ESTRELLA $$$$$$$$$$$$$$$$$$$$$$$");
//		System.out.println(rutaOrigen.replace("ficheros/", "") + ":" + "\n");	
//		System.out.println("Reparto obtenido:");
//		for (String abogado : resultado.keySet()) {
//			
//			// Sumo 1 para empezar a contar desde el índice 1 no desde el 0:
//			Integer abogadoInteger = Integer.parseInt(abogado.replace("Abogado_", "")) + 1;
//			String abogadoString = "Abogado_" + abogadoInteger;
//			System.out.println(abogadoString);
//			System.out.println("    " + "Horas empleadas: " + Math.round(horasEmpleadas(resultado, abogado)));
//			System.out.println("    " + "Casos estudiados: " + resultado.get(abogado));
//						
//		}
//		System.out.println("El estudio de todos los casos ha supuesto un total de " + "X" + " horas de trabajo para el\r\n"
//				+ "bufete al trabajar en paralelo.");
//		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · --");
//		
//	}

	/*
	 * Método privado encargado de parsear todo el contenido de Programación Dinámica para adecuarlo al fichero de resultados.
	*/
	private static void formateoPD(String fichero, String rutaOrigen) {
		
		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<String, List<Integer>> reparto = new HashMap<String, List<Integer>>();

		while (i < lista.size() - 1) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split(" - ");
			
			// Obtener el caso:
			String[] splitIzquierdo = datos[0].trim().split(":");
			String caso = "Caso " + (Integer.parseInt(splitIzquierdo[1].trim()) + 1);
			
			// Obtener la lista asociada:
			List<Integer> auxiliar = new ArrayList<Integer>();
			String[] splitDerecho = datos[1].trim().replace("[", "").replace("]", "").split(",");
			
			for (String numero : splitDerecho) {
				
				auxiliar.add(Integer.parseInt(numero.trim()));
				
			}
			
			// Meter el caso con su lista en el mapa reparto: 
			if (reparto.containsKey(caso)) {
				
				List<Integer> valor = reparto.get(caso);
				reparto.put(caso, valor);
				
			} else {
				
				reparto.put(caso, auxiliar);
				
			}
			
			i++;
					
		}
		
		// Con el mapa creado compruebo a que abogado se asigna cada caso gracias al método auxiliar 
		// cualHaCambiado() y los índices:		
		int j = 1;
		Set<String> setCasos = new HashSet<String>();
		Map<String, Set<String>> resultado = new HashMap<String, Set<String>>();
		while (j < lista.size() - 1) {
			
			/*
			 * Esto me permite asignar los casos a abogados, cosa que hago con un nuevo mapa que constituirá la 
			 * solución propiamente dicha:
			*/
			Integer abogado = cualHaCambiado(reparto, "Caso " + j);
			if (resultado.containsKey("Abogado_" + abogado)) {
								
				// Casos asignados al abogado:
				setCasos = resultado.get("Abogado_" + abogado);
				setCasos.add("Caso " + j);
				resultado.put("Abogado_" + abogado, setCasos);
				
			} else {
				
				// Casos asignados al abogado:
				Set<String> setAux = new HashSet<String>();
				setAux.add("Caso " + j);
				resultado.put("Abogado_" + abogado, setAux);
				
			}
			
			j++;
			
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$ PROGRAMACIÓN DINÁMICA $$$$$$$$$$$$$$$$$$");
		System.out.println(rutaOrigen.replace("ficheros/", "") + ":" + "\n");	
		System.out.println("Reparto obtenido:");
		for (String abogado : resultado.keySet()) {
			
			// Sumo 1 para empezar a contar desde el índice 1 no desde el 0:
			Integer abogadoInteger = Integer.parseInt(abogado.replace("Abogado_", "")) + 1;
			String abogadoString = "Abogado_" + abogadoInteger;
			System.out.println(abogadoString);
			System.out.println("    " + "Casos estudiados: " + resultado.get(abogado));
						
		}
		System.out.println("El estudio de todos los casos ha supuesto un total de " + "X" + " horas de trabajo para el\r\n"
				+ "bufete al trabajar en paralelo.");
		System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · --");
		
	}
	
	// MÉTODOS AUXILIARES PARA EL FORMATEO DE LA SALIDA 
	
	/*
	 * Método privado que dado el reparto y un índice, dado dos listas solo difieren
	 * en UN valor, calcula cual es la posición (que no el valor) que varía. Esta
	 * posición corresponde al abogado que buscamos.
	*/
	private static Integer cualHaCambiado(Map<String, List<Integer>> reparto, String indice) {

		int i = 0;
		Integer resultado = 0;
		Integer numero = Integer.parseInt(indice.replace("Caso ", "")) + 1;
		String siguiente = "Caso " + numero;

		List<Integer> listaActual = reparto.get(indice);
		List<Integer> listaSiguiente = reparto.get(siguiente);

		while (i < listaActual.size()) {

			// Posición en la que ambas listas difieren: abogado al que se ha asignado el
			// caso "numero":
			if (listaActual.get(i) != listaSiguiente.get(i)) {

				resultado = i;

			}

			i++;

		}

		return resultado;

	}
	
	/*
	 * Método privado para calcular el nº de horas empleadas por un abogado indicado en 
	 * base a sus casos asociados. 
	*/
	private static Double horasEmpleadas(Map<String, Set<String>> resultado, String abogado) {
		
		Double horasEmpleadas = 0.0;
		
		for (String casoAsociado : resultado.get(abogado)) {

			Integer abogadoInteger = Integer.parseInt(abogado.replace("Abogado_", ""));
			Integer casoInteger = Integer.parseInt(casoAsociado.replace("Caso ", ""));
			horasEmpleadas += Ejercicio2.tiempoPorIndice(abogadoInteger, casoInteger - 1);
			
		}
		
		return horasEmpleadas;
		
	}
	
}
