/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio2;

//Clase profesor que representan nodos/vértices
public class Profesor {

	// MÉTODOS DE LA CLASE
	public static Profesor of() {

		return new Profesor("");

	}

	public static Profesor ofFormat(String[] formato) {

		return new Profesor(formato);

	}

	public static Profesor ofName(String nombre) {

		return new Profesor(nombre);

	}

	// ATRIBUTOS DE LA CLASE
	private String nombre;

	// CONSTRUCTORES DE LA CLASE
	private Profesor(String nombre) {

		super();
		this.nombre = nombre;

	}

	private Profesor(String[] formato) {

		super();
		this.nombre = formato[0];

	}

	// SETTERS/GETTTERS DE LA CLASE
	public String getNombre() {

		return nombre;

	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Profesor other = (Profesor) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return this.nombre;
		
	}
	
}
