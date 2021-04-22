/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Pair;

/*
 *  Clase abogado para parsear la entrada por fichero del ejercicio creando objetos de clase Abogado con 
 *  sus respectivos atributos: Nombre y Lista de horas. Implemento la clase como extensión de Pair.
*/
public class Abogado extends Pair<String, List<Integer>>{

	// MÉTODOS DE LA CLASE
	public static Abogado ofLinea(String linea) {

		return new Abogado(linea);

	}

	// ATRIBUTOS DE LA CLASE
	public static String nombre;
	public static List<Integer> horas;

	// CONSTRUCTORES DE LA CLASE
	private Abogado(String datos) {
			
		super(nombre, horas);
		List<Integer> listaHoras = new ArrayList<Integer>();
			
		// Abogado_01: 1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5
		// Abogado_01
		// 1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5

		String[] contenido = datos.split(": ");
		
		String nombre = contenido[0];
		String[] horas = contenido[1].split(",");
					
		// Casteo los strings de "horas" a entero para meterlos en la lista:
		for (String numero : horas) {
						
			listaHoras.add(Integer.parseInt(numero));
						
		}

		Abogado.nombre = nombre;
		Abogado.horas = listaHoras;
			
	}

	// GETTTERS DE LA CLASE
	
	// Devuelve el nombre de un Abogado:
	public String getNombre() {

		return nombre;

	}

	// Devuelve la lista de horas de un Abogado:
	public List<Integer> getHoras() {

		return horas;

	}
	
	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
	@Override
	public String toString() {
		
		return "[Abogado_" + nombre + ", lista de horas: " + horas + "]";
		
	}

}
