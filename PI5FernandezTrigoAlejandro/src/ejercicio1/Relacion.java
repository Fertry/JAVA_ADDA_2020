/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 5
 */

package ejercicio1;

// Clase relaci�n que representa una arista entre dos nodos (Personas), a modo 
// de relaci�n de amistad entre dos usuarios. 
public class Relacion {

	// M�TODOS DE LA CLASE
	public static Relacion of() {
		
		return new Relacion();
		
	}

	public static Relacion ofVertex(Persona p1, Persona p2) {
		
		return new Relacion(p1, p2);
		
	}
	
	public static Relacion ofFormat(Persona p1, Persona p2, String[] formato) {
		
		return new Relacion(p1, p2, formato);
		
	}

	// ATRIBUTOS DE LA CLASE
	private double id;
	private Persona p1;
	private Persona p2;
	private static double numero = 0.0;

	// CONSTRUCTORES DE LA CLASE
	private Relacion(Persona p1, Persona p2) {
		
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.id = numero;
		numero++;
		
	}
	
	private Relacion() {
		
		this.p1 = null;
		this.p2 = null;
		this.id = numero;
		numero++;
		
	} 
	
	private Relacion(Persona p1, Persona p2, String[] formato) {
		
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.id = numero;
		numero++;
		
	}

	// SETTERS/GETTTERS DE LA CLASE
	public Persona getOrigen(){
		
		return p1;
		
	}
	
	public Persona getDestino(){
		
		return p2;
		
	}
	
	public double getId() {
		
		return this.id;
		
	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(id);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
			return false;
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
