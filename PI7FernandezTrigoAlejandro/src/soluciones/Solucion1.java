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
import aristas.AristaAlumno;
import ejercicio1.Ejercicio1;

public class Solucion1 {
	
	/*
	 * Método público para recibir la lista de aristas resultantes de la ejecución de los algoritmos y operar sobre dicha lista.
	*/
	public static void solucion(List<AristaAlumno> entrada, String ruta) {

		int i = 0;
		Double valor = 0.0;
		Map<String, Set<String>> reparto = new HashMap<String, Set<String>>();
		
		while (i < entrada.size()) {
			
			// Obtener el par de valores Alumno/Grupo de cada arista:
			String arista = entrada.get(i).toString();
			String[] parDeValores = arista.trim().split(",");
			
			// Obtener el alumno:
			String alumno = "Alumno_" + parDeValores[0].replace("(", "");
		
			// Obtener el grupo:
			String grupo = "Grupo" + parDeValores[1].replace(")", "");
			
			// Añadir al mapa el grupo con sus alumnos:
			if (reparto.containsKey(grupo)) {
				
				Set<String> setAlumnos = new HashSet<String>();
				setAlumnos = reparto.get(grupo);
				// Sumar 1 al alumno para no empezar en 0:
				Integer alumnoIntegerBucle = Integer.parseInt(alumno.replace("Alumno_", "")) + 1;
				String alumnoStringBucle = "Alumno_" + alumnoIntegerBucle;
				setAlumnos.add(alumnoStringBucle);
				reparto.put(grupo, setAlumnos);
				
			} else {
				
				Set<String> setAux = new HashSet<String>();
				Integer alumnoIntegerBucle = Integer.parseInt(alumno.replace("Alumno_", "")) + 1;
				String alumnoStringBucle = "Alumno_" + alumnoIntegerBucle;
				setAux.add(alumnoStringBucle);
				reparto.put(grupo, setAux);
				
			}
			
			// Calculo de la afinidad en base al grupo:
			Integer alumnoInteger = Integer.parseInt(alumno.replace("Alumno_", "")); 
			Integer grupoInteger = Integer.parseInt(grupo.replace("Grupo ", "")); 
			valor += Ejercicio1.getAfinidadPorIndice(alumnoInteger, grupoInteger);
			i++;
			
		}
		
		// Mostrar los datos finales por pantalla:
		System.out.println(ruta.replace("ficheros/", "") + ":" + "\n");	
		System.out.println("Reparto obtenido:");
		for (String group : reparto.keySet()) {

			// Sumo 1 para que comience a contar desde 1 y no 0:
			Integer grupoIntegerMasUno = Integer.parseInt(group.replace("Grupo ", "")) + 1;
			String grupoStringMasUno = "Grupo " + grupoIntegerMasUno;
			
			System.out.println("	" + grupoStringMasUno + ": " + reparto.get(group));	
						
		}
		System.out.println("Afinidad media del reparto: " + Math.round(valor/Ejercicio1.getNAlumnos()));
	
	}

}
