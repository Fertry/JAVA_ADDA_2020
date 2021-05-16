/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package clases;

import java.util.ArrayList;
import java.util.List;

/*
 * Clase abogado para parsear la entrada por fichero del ejercicio creando objetos de clase Abogado con 
 * sus respectivos atributos: Nombre y Lista de horas.
*/
public class Abogado {

	// MÉTODOS DE LA CLASE
	public static Abogado ofLinea(String linea) {

		return new Abogado(linea);

	}

	// ATRIBUTOS DE LA CLASE
	private String nombre;
	private List<Integer> horas;

	// CONSTRUCTORES DE LA CLASE
	private Abogado() {
		
		super();
		
	}
	
	private Abogado(String datos) {
			
		super();
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

		this.nombre = nombre;
		this.horas = listaHoras;
			
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
	
	// HASHCODE Y EQUALS DE LA CLASE
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
	
	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
	@Override
	public String toString() {
		
		return "[Abogado_" + nombre + ", lista de horas: " + horas + "]";
		
	}

}
