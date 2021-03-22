/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio1;

// Clase relación que representa una arista entre dos nodos (Personas), a modo 
// de relación de amistad entre dos usuarios. 
public class Relacion {

	// MÉTODOS DE LA CLASE
	public static Relacion of() {
		
		return new Relacion();
		
	}

	public static Relacion ofVertex(Persona p1, Persona p2) {
		
		return new Relacion(p1, p2);
		
	}
	
	public static Relacion ofFormat(Persona p1, Persona p2, String[] formato) {
		
		return new Relacion(p1, p2, formato);
		
	}

	// ATRIBUTOS DE LA CLASE INMUTABLES
	private final Persona p1;
	private final Persona p2;

	// CONSTRUCTORES DE LA CLASE
	private Relacion(Persona p1, Persona p2) {
		
		super();
		this.p1 = p1;
		this.p2 = p2;
		
	}
	
	private Relacion() {
		
		this.p1 = null;
		this.p2 = null;
		
	} 
	
	private Relacion(Persona p1, Persona p2, String[] formato) {
		
		super();
		this.p1 = p1;
		this.p2 = p2;
		
	}

	// GETTTERS DE LA CLASE
	public Persona getOrigen(){
		
		return p1;
		
	}
	
	public Persona getDestino(){
		
		return p2;
		
	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
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
		Relacion other = (Relacion) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return "("+getOrigen()+","+getDestino()+")";
		
	}

}
