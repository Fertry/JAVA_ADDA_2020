/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package soluciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import aristas.AristaAbogado;
import ejercicio2.Ejercicio2;

public class Solucion2 {
	
	/*
	 * Método público para recibir la lista de aristas resultantes de la ejecución de los algoritmos y operar sobre dicha lista.
	*/
	public static void solucion(List<AristaAbogado> entrada, String ruta) {

		int i = 0;
		Map<String, Set<String>> reparto = new HashMap<String, Set<String>>();

		while (i < entrada.size()) {

			// Obtener el par de valores Caso/Abogado de cada arista:
			String arista = entrada.get(i).toString();
			String[] parDeValores = arista.trim().split(",");

			// Obtener el caso:
			String caso = "Caso " + parDeValores[0].replace("(", "");

			// Obtener el abogado:
			String abogado = "Abogado_" + parDeValores[1].replace(")", "").trim();

			// Añadir al mapa el abogado con sus casos:
			if (reparto.containsKey(abogado)) {

				Set<String> setCasos = new HashSet<String>();
				setCasos = reparto.get(abogado);
				// Sumar 1 al caso para no empezar en 0:
				Integer casoIntegerBucle = Integer.parseInt(caso.replace("Caso ", "")) + 1;
				String casoStringBucle = "Caso " + casoIntegerBucle;
				setCasos.add(casoStringBucle);
				reparto.put(abogado, setCasos);

			} else {

				Set<String> setAux = new HashSet<String>();
				Integer casoIntegerBucle = Integer.parseInt(caso.replace("Caso ", "")) + 1;
				String casoStringBucle = "Caso " + casoIntegerBucle;
				setAux.add(casoStringBucle);
				reparto.put(abogado, setAux);

			}

			i++;

		}

		// Calculo de valores:
		Integer horas = 0;
		Integer acumuladorHoras = 0;
		
		// Mostrar los datos finales por pantalla:
		System.out.println(ruta.replace("ficheros/", "") + ":" + "\n");
		System.out.println("Reparto obtenido:");
		for (String abogadoIndice : reparto.keySet()) {

			// Sumo 1 para que comience a contar desde 1 y no 0:
			Integer abogadoIntegerMasUno = Integer.parseInt(abogadoIndice.replace("Abogado_", "")) + 1;
			String abogadoStringMasUno = "Abogado_" + abogadoIntegerMasUno;

			System.out.println(abogadoStringMasUno);
			System.out.println("    " + "Horas empleadas: " + horasAsociadas(reparto.get(abogadoIndice), abogadoIndice));
			System.out.println("    " + "Casos estudiados: " + reparto.get(abogadoIndice));
			System.out.println("    " + "Media (horas/caso): " + Math.round(mediaHoras(reparto.get(abogadoIndice), abogadoIndice)));
			System.out.println("· -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · -- - -- · --");
			
			horas = horasAsociadas(reparto.get(abogadoIndice), abogadoIndice);
			acumuladorHoras =+ horasAsociadas(reparto.get(abogadoIndice), abogadoIndice);
			
		}
		
		System.out.println("El estudio de todos los casos ha supuesto un total de " + acumuladorHoras + " horas de trabajo para el\r\n"
		+ "bufete, que al trabajar en paralelo se ha podido llevar a cabo en " + horas + " horas.");

	}
	
	// MÉTODOS PRIVADOS PARA EL FORMATEO DE LA SOLUCIÓN
	
	/*
	 * Método privado para calcular el sumatorio de horas de un abogado en base a sus casos asociados.
	*/
	private static Integer horasAsociadas(Set<String> casos, String abogado) {
		
		Integer resultado = 0;
		
		for (String caso : casos) {
			
			Integer casoInteger = Integer.parseInt(caso.replace("Caso ", ""));
			Integer abogadoInteger = Integer.parseInt(abogado.replace("Abogado_", ""));
			resultado += Ejercicio2.tiempoPorIndice(abogadoInteger, casoInteger - 1);
			
		}
		
		return resultado;
	
	}
	
	/*
	 * Método privado para calcular la media de horas en base a los casos asociados.
	*/
	private static Double mediaHoras(Set<String> casos, String abogado) {
		
		Double resultado = 0.0;
		
		resultado = (double) horasAsociadas(casos, abogado) / casos.size();
		
		return resultado;
		
	}
	
}
