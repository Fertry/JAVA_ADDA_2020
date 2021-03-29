/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 6
 */

package ejercicio2;

import java.util.ArrayList;
import java.util.List;

//Clase abogado para parsear la entrada por fichero del ejercicio creando objetos de clase Abogado con 
//sus respectivos atributos: Nombre y Lista de horas.
public class Abogado {

	// MÉTODOS DE LA CLASE
	public static Abogado of() {

		return new Abogado();

	}

	public static Abogado ofDatos(String nombre, List<Integer> horas) {

		return new Abogado(nombre, horas);

	}

	public static Abogado ofLinea(String linea) {

		return new Abogado(linea);

	}
	
	/*
	 * Método auxiliar para, dado un entero que corresponde a un caso
	 * (posición) y un Abogado, devuelve las horas que emplea dicho abogado 
	 * en ese caso o devuelve null si no existe dicho caso.
	 */
	public static Integer getHorasPorCaso(Abogado abogado, Integer caso) {
		
		Integer resultado = null;
		Integer numeroCasos = Abogado.getHoras().size();
		
		if (caso > numeroCasos || caso < numeroCasos) {
			
			resultado = null;
			
		} else {
			
			resultado = Abogado.getHoras().get(caso);
			
		}
		
		return resultado;
		
	}

	// ATRIBUTOS DE LA CLASE INMUTABLES
	private static Integer n = 0;
	public static Integer id;
	public static String nombre;
	public static List<Integer> horas;

	// CONSTRUCTORES DE LA CLASE
	private Abogado() {
				
		Abogado.id = null;
		Abogado.nombre = null;
		Abogado.horas = null;
			
	}

	private Abogado(String nombre, List<Integer> afinidades) {
			
		super();
		Abogado.id = n; 
		Abogado.nombre = nombre;
		Abogado.horas = afinidades;
		n++;
			
	}

	private Abogado(String datos) {
			
		super();
		List<Integer> listaHoras = new ArrayList<Integer>();
			
		// Secuencia de trims y splits:
		// Abogado_01: 1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5
		// Abogado_01
		// 1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5,1,2,3,5

		// ********************************************************************************************
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
		// ********************************************************************************************

		Abogado.id = n;
		Abogado.nombre = nombre;
		Abogado.horas = listaHoras;
		n++;
			
	}

	// GETTTERS DE LA CLASE
	public static Integer getId() {
		
		return id;
		
	}
	
	public static String getNombre() {

		return nombre;

	}

	public static List<Integer> getHoras() {

		return horas;

	}
	
	public static Integer getNumeroCasos() {
		
		return horas.size();
		
	}
	
	// TO_STRING DE LA CLASE
	@Override
	public String toString() {
		
		return "Abogado [Nombre = " + nombre + ", Horas = " + horas + "]";
		
	}

}
