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

	public static Relacion ofWeight(Persona p1, Persona p2) {
		
		return new Relacion(p1, p2);
		
	}
	
	public static Relacion reverse(Relacion r) {
		
		return new Relacion(r.destino, r.origen);
		
	}
	
	// ATRIBUTOS DE LA CLASE
	private double id;
	private Persona origen;
	private Persona destino;
	private static double numero = 0.0;

	// CONSTRUCTORES DE LA CLASE
	private Relacion(Persona p1, Persona p2) {
		
		this.origen = p1;
		this.destino = p2;
		this.id = numero;
		numero++;
		
	}
	
	private Relacion() {
		
		this.origen = null;
		this.destino = null;
		this.id = numero;
		numero++;
		
	} 
	
	private Relacion(Persona origen, Persona destino, Double n, String nombre) {
		
		super();
		this.origen = origen;
		this.destino = destino;
		this.id = numero;
		numero++;
		
	}

	private Relacion(Persona p1, Persona p2, String[] nombre) {
		
		this.origen = p1;
		this.destino = p2;
		this.id = numero;
		numero++;
		
	}
	
	private Relacion(Persona p1, Persona p2, Double n) {
		
		this.origen = p1;
		this.destino = p2;
		this.id = numero;
		numero++;
		
	}

	// SETTERS/GETTTERS DE LA CLASE
	public Persona getOrigen(){
		
		return origen;
		
	}
	
	public Persona getDestino(){
		
		return destino;
		
	}
	
	public double getId() {
		
		return this.id;
		
	}

	// HASHCODE, EQUALS, TOSTRING DE LA CLASE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		long temp;
		temp = Double.doubleToLongBits(id);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
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
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return "("+getOrigen()+","+getDestino()+")";
		
	}

}
