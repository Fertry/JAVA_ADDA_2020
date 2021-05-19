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

import ejercicio1.Ejercicio1;
import us.lsi.common.Files2;
import us.lsi.flujossecuenciales.StreamsS;
import vertices.VerticeAlumno;

public class Solucion1 {
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de A* y operar sobre dicha lista.
	*/
	public static void solucionA(List<VerticeAlumno> entrada, String fichero) {
		
		try {
		
			// Escribe el resultado a fichero para tratarlo a continuación:
			String datos = entrada.toString();
			Files2.toFile(datos.trim(), "salida/salidaEj1A" + fichero.replace("ficheros/PI7Ej1DatosEntrada", ""));
			formateoA("salida/salidaEj1A" + fichero.replace("ficheros/PI7Ej1DatosEntrada", ""), fichero);
				
		// Si hay algún problema se vuelca la salida directamente por consola:
		} catch (Exception e) {
			
			// e.printStackTrace();
			System.out.println("No se ha podido formatear la salida para el fichero " + fichero + ", en su lugar se muestra la lista de "
					+ "vertices devuelta por el algoritmo A* por pantalla.");
			
			for (VerticeAlumno vertice : entrada) {
				
				System.out.println(vertice.toString());
				
			}
			
		}

	}
	
	/*
	 * Método público para recibir la lista de vértices resultantes de la ejecución de Programación Dinámica y operar sobre dicha lista.
	*/
	public static void solucionPD(List<VerticeAlumno> entrada, String fichero) {

		try {
		
			// Escribe el resultado a fichero para tratarlo a continuación:
			String datos = entrada.toString();
			Files2.toFile(datos.trim(), "salida/salidaEj1PD" + fichero.replace("ficheros/PI7Ej1DatosEntrada", ""));
			formateoPD("salida/salidaEj1PD" + fichero.replace("ficheros/PI7Ej1DatosEntrada", ""), fichero);
				
		// Si hay algún problema se vuelca la salida directamente por consola:
		} catch (Exception e) {
			
			// e.printStackTrace();
			System.out.println("No se ha podido formatear la salida para el fichero " + fichero + ", en su lugar se muestra la lista de "
					+ "vertices devuelta por el algoritmo programación dinámica por pantalla.");
			
			for (VerticeAlumno vertice : entrada) {
				
				System.out.println(vertice.toString());
				
			}
			
		}
		
	}
	
	/*
	 * Método privado encargado de parsear todo el contenido de A* para adecuarlo al fichero de resultados.
	*/
	private static void formateoA(String fichero, String rutaOrigen) {
		
		int i = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		Map<String, List<Integer>> reparto = new HashMap<String, List<Integer>>();

		while (i < lista.size() - 1) {
			
			String linea = lista.get(i).trim();
			String[] datos = linea.trim().split(" - ");
			
			// Obtener el alumno:
			String[] splitIzquierdo = datos[0].trim().split(":");
			String alumno = "Alumno_" + (Integer.parseInt(splitIzquierdo[1].trim()) + 1);
			
			// Obtener la lista asociada:
			List<Integer> auxiliar = new ArrayList<Integer>();
			String[] splitDerecho = datos[1].trim().replace("[", "").replace("]", "").split(",");
			
			for (String numero : splitDerecho) {
				
				auxiliar.add(Integer.parseInt(numero.trim()));
				
			}
			
			// Meter el alumno con su lista en el mapa reparto: 
			if (reparto.containsKey(alumno)) {
				
				List<Integer> valor = reparto.get(alumno);
				reparto.put(alumno, valor);
				
			} else {
				
				reparto.put(alumno, auxiliar);
				
			}
			
			i++;
					
		}
		
		// Con el mapa creado compruebo a que grupo pertenece cada alumno gracias al método auxiliar 
		// cualHaCambiado() y los índices:		
		int j = 1;
		Double valor = 0.0;
		Map<String, Set<String>> resultado = new HashMap<String, Set<String>>();
		while (j < lista.size() - 1) {
			
			/*
			 * Esto me permite asignar los alumnos a su grupo, cosa que hago con un nuevo mapa que constituirá la 
			 * solución propiamente dicha:
			*/
			Set<String> setAlumnos = new HashSet<String>();
			Integer grupo = cualHaCambiado(reparto, "Alumno_" + j);
			if (resultado.containsKey("Grupo " + grupo)) {
				
				// Alumnos que pertenecen al grupo:
				setAlumnos = resultado.get("Grupo " + grupo);
				setAlumnos.add("Alumno_" + j);
				resultado.put("Grupo " + grupo, setAlumnos);
				
			} else {
				
				// Alumnos que pertenecen al grupo:
				setAlumnos.add("Alumno_" + j);
				resultado.put("Grupo " + grupo, setAlumnos);
				
			}
			
			valor += Ejercicio1.getAfinidadPorIndice(j-1, grupo);
	
			j++;
			
		}
		
		// Afinidad media:
		Double afininidadMedia = valor / Ejercicio1.getNAlumnos();
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ A ESTRELLA $$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(rutaOrigen.replace("ficheros/", "") + ":" + "\n");	
		System.out.println("Reparto obtenido:");
		for (String group : resultado.keySet()) {
			
			System.out.println("	" + group + ": " + resultado.get(group));	
						
		}
		System.out.println("Afinidad media del reparto: " + Math.round(afininidadMedia));
		
	}
	
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
			
			// Obtener el alumno:
			String[] splitIzquierdo = datos[0].trim().split(":");
			String alumno = "Alumno_" + (Integer.parseInt(splitIzquierdo[1].trim()) + 1);
			
			// Obtener la lista asociada:
			List<Integer> auxiliar = new ArrayList<Integer>();
			String[] splitDerecho = datos[1].trim().replace("[", "").replace("]", "").split(",");
			
			for (String numero : splitDerecho) {
				
				auxiliar.add(Integer.parseInt(numero.trim()));
				
			}
			
			// Meter el alumno con su lista en el mapa reparto: 
			if (reparto.containsKey(alumno)) {
				
				List<Integer> valor = reparto.get(alumno);
				reparto.put(alumno, valor);
				
			} else {
				
				reparto.put(alumno, auxiliar);
				
			}
			
			i++;
					
		}
		
		// Con el mapa creado compruebo a que grupo pertenece cada alumno gracias al método auxiliar 
		// cualHaCambiado() y los índices:
		int j = 1;
		Double valor = 0.0;
		Map<String, Set<String>> resultado = new HashMap<String, Set<String>>();
		while (j < lista.size() - 1) {
			
			/*
			 * Esto me permite asignar los alumnos a su grupo, cosa que hago con un nuevo mapa que constituirá la 
			 * solución propiamente dicha:
			*/
			Set<String> setAlumnos = new HashSet<String>();
			Integer grupo = cualHaCambiado(reparto, "Alumno_" + j);
			if (resultado.containsKey("Grupo " + grupo)) {
				
				// Alumnos que pertenecen al grupo:
				setAlumnos = resultado.get("Grupo " + grupo);
				setAlumnos.add("Alumno_" + j);
				resultado.put("Grupo " + grupo, setAlumnos);
				
			} else {
				
				// Alumnos que pertenecen al grupo:
				setAlumnos.add("Alumno_" + j);
				resultado.put("Grupo " + grupo, setAlumnos);
				
			}
			
			valor += Ejercicio1.getAfinidadPorIndice(j-1, grupo);
			
			j++;
			
		}
		
		// Afinidad media:
		Double afininidadMedia = valor / Ejercicio1.getNAlumnos();
		
		System.out.println("$$$$$$$$$$$$$$$$$ PROGRAMACIÓN DINÁMICA $$$$$$$$$$$$$$$$$$");
		System.out.println(rutaOrigen.replace("ficheros/", "") + ":" + "\n");	
		System.out.println("Reparto obtenido:");
		for (String group : resultado.keySet()) {
			
			System.out.println("	" + group + ": " + resultado.get(group));	
			
		}
		System.out.println("Afinidad media del reparto: " + Math.round(afininidadMedia));
		
	}
	
	// MÉTODOS AUXILIARES PARA EL FORMATEO DE LA SALIDA 
	
	/*
	 * Método privado que dado el reparto y un índice, dado dos listas solo difieren en UN valor, calcula cual es la 
	 * posición (que no el valor) que varía. Esta posición corresponde al grupo que buscamos. 
	*/
	private static Integer cualHaCambiado(Map<String, List<Integer>> reparto, String indice) {
		
		int i = 0;
		Integer resultado = 0;
		Integer numero = Integer.parseInt(indice.replace("Alumno_", "")) + 1;
		String siguiente = "Alumno_" + numero;
		
		List<Integer> listaActual = reparto.get(indice);
		List<Integer> listaSiguiente = reparto.get(siguiente);
		
		while (i < listaActual.size()) {
			
			// Posición en la que ambas listas difieren: grupo al que se ha asignado el alumno "numero":
			if (listaActual.get(i) != listaSiguiente.get(i)) {
				
				resultado = i;
				
			}
			
			i++;
			
		}
			
		return resultado;
		
	}
	
}
