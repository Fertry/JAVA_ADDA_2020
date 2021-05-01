/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
 */

package clases;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Pair;

/*
 * Clase alumno para parsear la entrada por fichero del ejercicio creando objetos de clase Alumno con 
 * sus respectivos atributos: Nombre y Lista de afinidades. Implemento la clase como extensión de Pair.
*/
public class Alumno extends Pair<String, List<Integer>> {
	
	// MÉTODOS DE LA CLASE
	public static Alumno ofLinea(String linea) {

		return new Alumno(linea);

	}
	
	// ATRIBUTOS DE LA CLASE
	public static String nombre;
	public static List<Integer> afinidades;

	// CONSTRUCTORES DE LA CLASE
	private Alumno(String datos) {
		
		super(nombre, afinidades);
		List<Integer> listaAfinidades = new ArrayList<Integer>();
		
		// Alumno_08: 5,3,2,0
		// Alumno_08
		// 5,3,2,0

		String[] contenido = datos.split(": ");
		String nombre = contenido[0];
		String[] numeros = contenido[1].split(",");
		
		// Casteo los strings de "numeros" a entero para meterlos en la lista:
		for (String numero : numeros) {
			
			listaAfinidades.add(Integer.parseInt(numero));
			
		}

		Alumno.nombre = nombre;
		Alumno.afinidades = listaAfinidades;

	}

	// GETTTERS DE LA CLASE
	
	// Devuelve el nombre de un Alumno:
	public String getNombre() {
		
		return nombre;
		
	}

	// Devuelve la lista de afinidades de un Alumno:
	public List<Integer> getAfinidades() {
		
		return afinidades;
		
	}
	
	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
	@Override
	public String toString() {
		
		return "[Alumno_" + nombre + ", lista de afinidades: " + afinidades + "]";
		
	}

}
