/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package clases;

import java.util.ArrayList;
import java.util.List;

/*
 * Clase alumno para parsear la entrada por fichero del ejercicio creando objetos de clase Alumno con 
 * sus respectivos atributos.
*/
public class Alumno {

	// MÉTODOS DE LA CLASE
	public static Alumno ofLinea(String linea) {

		return new Alumno(linea);

	}
	
	// ATRIBUTOS DE LA CLASE
	private String nombre;
	private List<Integer> afinidades;
	
	// CONSTRUCTORES DE LA CLASE
	private Alumno() {
		
		super();
		
	}
	
	private Alumno(String datos) {
		
		super();
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

		this.nombre = nombre;
		this.afinidades = listaAfinidades;

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
	
	// HASHCODE Y EQUALS DE LA CLASE
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((afinidades == null) ? 0 : afinidades.hashCode());
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
		Alumno other = (Alumno) obj;
		if (afinidades == null) {
			if (other.afinidades != null)
				return false;
		} else if (!afinidades.equals(other.afinidades))
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
		
		return "[Alumno: " + nombre + ", lista de afinidades: " + afinidades + "]";
		
	}
	
}
