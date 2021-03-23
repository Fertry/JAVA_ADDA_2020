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

	public static Abogado ofLinea(String datos) {

		return new Abogado(datos);

	}
	
	/*
	 * Método auxiliar para, dado un entero que corresponde a un caso
	 * (posición) y un Abogado, devuelve las horas que emplea dicho abogado 
	 * en ese caso o devuelve null si no existe dicho caso.
	 */
	public static Integer getHorasPorCaso(Abogado abogado, Integer caso) {
		
		Integer resultado = null;
		Integer numeroCasos = abogado.getHoras().size();
		
		if (caso > numeroCasos || caso < numeroCasos) {
			
			resultado = null;
			
		} else {
			
			resultado = abogado.getHoras().get(caso);
			
		}
		
		return resultado;
		
	}

	// ATRIBUTOS DE LA CLASE INMUTABLES
	private final String nombre;
	private final List<Integer> horas;

	// CONSTRUCTORES DE LA CLASE
	private Abogado() {
				
			this.nombre = null;
			this.horas = null;
			
	}

	private Abogado(String nombre, List<Integer> afinidades) {
			
			super();
			this.nombre = nombre;
			this.horas = afinidades;
			
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

		this.nombre = nombre;
		this.horas = listaHoras;
			
	}

	// GETTTERS DE LA CLASE
	public String getNombre() {

		return nombre;

	}

	public List<Integer> getHoras() {

		return horas;

	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horas == null) ? 0 : horas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abogado other = (Abogado) obj;
		if (horas == null) {
			if (other.horas != null)
				return false;
		} else if (!horas.equals(other.horas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Abogado [nombre=" + nombre + ", horas=" + horas + "]";
	}

}
