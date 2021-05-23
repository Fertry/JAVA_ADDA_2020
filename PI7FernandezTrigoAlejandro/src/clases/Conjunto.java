/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 7
*/

package clases;

import java.util.ArrayList;
import java.util.List;

/* 
 * Clase conjunto para parsear la entrada por fichero del ejercicio creando objetos de clase Conjunto con 
 * sus respectivos atributos: Id y Lista de elementos.
*/
public class Conjunto {
	
	// MÉTODOS DE LA CLASE
	public static Conjunto ofLinea(String linea) {

		return new Conjunto(linea);

	}
	
	// ATRIBUTOS DE LA CLASE
	private static Integer n = 0;
	private Integer id; 
	private List<Integer> elementos;

	// CONSTRUCTORES DE LA CLASE
	private Conjunto() {
		
		super();
		
	}
	
	private Conjunto(String datos) {
			
		super();
		List<Integer> listaNumeros = new ArrayList<Integer>(); 
		
		// 1, 2, 3, 4, 5, 7, 8, 15
		// [1, 2, 3, 4, 5, 7, 8, 15]
		
		String[] contenido = datos.split(", ");

		// Casteo los strings de "contenido" a entero para meterlos en la lista:
		for (String numero : contenido) {
			
			listaNumeros.add(Integer.parseInt(numero));
			
		}
		
		this.id = n + 1;
		this.elementos = listaNumeros;

	}
	
	// GETTTERS DE LA CLASE

	// Devuelve la lista de elementos de un Conjunto:
	public List<Integer> getElementos() {
		
		return elementos;
		
	}
	
	// HASHCODE Y EQUALS DE LA CLASE
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elementos == null) ? 0 : elementos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Conjunto other = (Conjunto) obj;
		if (elementos == null) {
			if (other.elementos != null)
				return false;
		} else if (!elementos.equals(other.elementos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		
	}	
	
	// TO_STRING DE LA CLASE (SOLO PARA HACER DEBUG)
	@Override
	public String toString() {
		
		return "[Conjunto_" + id + ", elementos: " + elementos + "]";
		
	}
	
}
