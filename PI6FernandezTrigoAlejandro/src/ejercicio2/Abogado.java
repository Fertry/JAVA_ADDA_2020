/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.util.ArrayList;
import java.util.List;

// Clase abogado para parsear la entrada por fichero del ejercicio creando objetos de clase Abogado con 
// sus respectivos atributos: Nombre y Lista de horas.
public class Abogado {

	// MÉTODOS DE LA CLASE
	public static Abogado of() {

		return new Abogado();

	}

	public static Abogado ofLinea(String linea) {

		return new Abogado(linea);

	}

	// ATRIBUTOS DE LA CLASE
	public static String nombre;
	public static List<Integer> horas;

	// CONSTRUCTORES DE LA CLASE
	private Abogado() {
				
		Abogado.nombre = null;
		Abogado.horas = null;
			
	}

	// Este constructor representa el constructor principal de la clase encargado de parsear cada línea de fichero:
	private Abogado(String datos) {
			
		super();
		List<Integer> listaHoras = new ArrayList<Integer>();
			
		// Secuencia de trims y splits:
		// Abogado_01: 1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5
		// Abogado_01
		// 1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5

		// Hacer split en base a los dos puntos y quedarnos con la parte izquierda
	    // que representa los nombres, hacer split nuevamente en base a
		// la coma (en la derecha) para quedarnos con la lista de horas:
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
	public static String getNombre() {

		return nombre;

	}

	// Devuelve la lista de horas de un Abogado:
	public static List<Integer> getHoras() {

		return horas;

	}
	
	// Devuelve el nº de horas de un Abogado:
	public static Integer getNumeroCasos() {
		
		return horas.size();
		
	}
	
	// Devuelva el tiempo i de un Abogado:
	public Integer getHora(Integer i) {
		
		return horas.get(i);
		
	}
	
	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Abogado [Nombre = " + nombre + ", Horas = " + horas + "]";
		
	}

}
