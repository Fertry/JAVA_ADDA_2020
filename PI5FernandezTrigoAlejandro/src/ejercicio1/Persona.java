/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio1;

// Clase persona que representan nodos siendo estos usuarios de
// una red social.
public class Persona {

	// MÉTODOS DE LA CLASE
	public static Persona of() {
		
		return new Persona("");
		
	}

	public static Persona ofFormat(String[] formato) {
		
		return new Persona(formato);
		
	}

	public static Persona ofName(String nombre) {
		
		return new Persona(nombre);
		
	}
	
	// ATRIBUTOS DE LA CLASE INMUTABLES
	private final String nombre;

	// CONSTRUCTORES DE LA CLASE
	private Persona(String nombre) {
		
		super();
		this.nombre = nombre;
		
	}

	private Persona(String[] formato){
		
		super();
		this.nombre = formato[0];
		
	}
	
	// GETTTERS DE LA CLASE
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
		Persona other = (Persona) obj;
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
